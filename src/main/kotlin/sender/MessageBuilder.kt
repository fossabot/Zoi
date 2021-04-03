package sender

import net.mamoe.mirai.contact.Contact
import net.mamoe.mirai.message.data.At
import net.mamoe.mirai.message.data.MessageChain
import net.mamoe.mirai.message.data.MessageChainBuilder
import net.mamoe.mirai.message.data.PlainText
import net.mamoe.mirai.utils.ExternalResource.Companion.uploadAsImage
import utils.ImageHelper
import java.io.File

class MessageBuilder(private val contact: Contact) {
    private val messageChain: MessageChainBuilder = MessageChainBuilder()

    fun add(text: String): MessageBuilder {
        messageChain.append(PlainText(text))
        return this
    }

    suspend fun addImage(url: String): MessageBuilder {
        val fileName = ImageHelper().downloadPicture(url)
        println(ImageHelper.imgTempDir)
        val file = File(ImageHelper.imgTempDir + fileName)
        return addImage(file)
    }

    suspend fun addImage(imgFile: File): MessageBuilder {
        println(imgFile.toString())
        val image = imgFile.uploadAsImage(contact)
        messageChain.append(image)
        return this
    }

    fun at(userId: Long): MessageBuilder {
        messageChain.append(At(userId))
        return this
    }

    fun newLine(): MessageBuilder {
        messageChain.append(PlainText("\n"))
        return this
    }

    fun build(): MessageChain {
        return messageChain.build()
    }
}