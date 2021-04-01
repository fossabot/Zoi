package messageFilter

import commandBase.interfaces.CommandManager
import commandBase.interfaces.CommandUnit
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.MessageChain
import net.mamoe.mirai.message.data.content
import commandBase.CommandHandlerImp
import commandBase.GroupCommand
import messageFilter.interfaces.Filter

class FilterImp : Filter {

    override val commandPrefix: HashSet<Char>
        get() = CommandManager.commandPrefixes
    override val commandUnits: Map<String, CommandUnit>
        get() = CommandManager.commandUnits

    override suspend fun groupMessageFilter(message: MessageChain, event: GroupMessageEvent) {
        /**
         * 判断是否为指令
         */
        if (commandPrefix.contains(message.content[0]))
        {
            val rowName = message.content.split(" ")[0]
            println(rowName)
            val name = rowName.substring(1 until rowName.length)
            println(name)
            if (commandUnits.containsKey(name) && commandUnits[name] != null && commandUnits[name]!!.javaClass.getAnnotation(
                    GroupCommand::class.java) != null)
            {
                CommandHandlerImp().groupCommandRunner(commandUnits[name]!!,event)
            }
        }
        else
        {
            //不是指令
        }
    }
}