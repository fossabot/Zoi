package commandBase.interfaces

import net.mamoe.mirai.event.events.GroupMessageEvent

interface CommandUnit {
    val name: List<String>
    suspend fun commandResponse(event: GroupMessageEvent): Boolean
}