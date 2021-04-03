package utils

import BotInit
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.File
import java.io.FileOutputStream

class ImageHelper {
    /**
     * 图片临时目录
     */
    companion object {
        val imgTempDir = "${BotInit.workDir}/temp/img/"
    }

    /**
     *
     * @param url String 网络图片URL
     * @return Int 图片文件名称 无后缀
     */
    fun downloadPicture(url: String): Int {
        val dir = File(imgTempDir)
        if (!dir.exists()) {
            dir.mkdirs()
        }
        val fileName = url.hashCode()
        val file = File("${BotInit.workDir}/temp/img/$fileName")
        if (file.exists()) {
            return fileName
        }
        val client = OkHttpClient()
        val request = Request.Builder().get()
            .url(url)
            .build()
        val response = client.newCall(request).execute()
        val inputStream = response.body!!.byteStream()
        val fos: FileOutputStream
        try {
            fos = FileOutputStream(file)
            fos.write(inputStream.readBytes())
            fos.flush()
            fos.close()
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
        return fileName
    }
}