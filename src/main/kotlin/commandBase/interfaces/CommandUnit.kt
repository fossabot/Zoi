package commandBase.interfaces

import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.Message

interface CommandUnit {
    val name: List<String>
    suspend fun commandResponse(event: GroupMessageEvent): Message
}