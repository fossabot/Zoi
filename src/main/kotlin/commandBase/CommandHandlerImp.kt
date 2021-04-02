package commandBase

import commandBase.interfaces.CommandUnit
import net.mamoe.mirai.event.events.GroupMessageEvent

class CommandHandler {
    suspend fun groupCommandRunner(Command: CommandUnit, event: GroupMessageEvent) {
        Command.commandResponse(event)
    }
}