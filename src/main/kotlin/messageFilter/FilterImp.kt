package messageFilter

import commandBase.CommandHandler
import commandBase.interfaces.CommandManager
import commandBase.interfaces.CommandUnit
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.MessageChain
import net.mamoe.mirai.message.data.content
import commandBase.GroupCommand

/**
 * 消息过滤
 */

class Filter {

    private val commandPrefix: HashSet<Char>
        get() = CommandManager.commandPrefixes
    private val commandUnits: Map<String, CommandUnit>
        get() = CommandManager.commandUnits

    /**
     *
     * @param message MessageChain 消息链
     */

    suspend fun groupMessageFilter(message: MessageChain, event: GroupMessageEvent) {
        /**
         * 判断是否为指令
         */
        if (commandPrefix.contains(message.content[0]))
        {
            val rowName = message.content.split(" ")[0]
            println(rowName)
            val name = rowName.substring(1 until rowName.length)
            println(name)
            if (commandUnits.containsKey(name) && commandUnits[name] != null
                && (commandUnits[name]!!.javaClass.getAnnotation(GroupCommand::class.java) != null)
            )
            {
                CommandHandler().groupCommandRunner(commandUnits[name]!!,event)
            }
        }
        else
        {
            //不是指令
        }
    }
}