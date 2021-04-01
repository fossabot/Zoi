package commandBase.interfaces

import commandBase.interfaces.CommandUnit
import net.mamoe.mirai.event.events.GroupMessageEvent

/**
 * 指令处理
 */
interface CommandHandler {
    suspend fun groupCommandRunner(Command: CommandUnit, event: GroupMessageEvent)
}