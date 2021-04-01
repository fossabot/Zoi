package messageFilter.interfaces

import commandBase.interfaces.CommandUnit
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.MessageChain

/**
 * 消息过滤
 */
interface Filter {
    val commandPrefix: HashSet<Char>
    val commandUnits: Map<String, CommandUnit>
    /**
     *
     * @param message MessageChain 消息链
     */
    suspend fun groupMessageFilter(message: MessageChain,event: GroupMessageEvent)
}