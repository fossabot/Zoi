package commandBase

import commandBase.interfaces.CommandUnit
import net.mamoe.mirai.event.events.GroupMessageEvent

class CommandHandler {
    suspend fun groupCommandRunner(Command: CommandUnit, event: GroupMessageEvent) {
        val message = Command.commandResponse(event)
        event.subject.sendMessage(message)
    }
}