package commandBase

import commandBase.interfaces.CommandUnit
import net.mamoe.mirai.event.events.GroupMessageEvent
import commandBase.interfaces.CommandHandler

class CommandHandlerImp : CommandHandler {
    override suspend fun groupCommandRunner(Command: CommandUnit, event: GroupMessageEvent) {
        Command.commandResponse(event)
    }
}