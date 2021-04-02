import kotlinx.coroutines.CompletableJob
import messageFilter.Filter
import net.mamoe.mirai.Bot
import net.mamoe.mirai.event.GlobalEventChannel
import net.mamoe.mirai.event.events.GroupMessageEvent

class BotInit {
    companion object{
        lateinit var bot: Bot
    }
    suspend fun init(passBot: Bot)
    {
        bot = passBot
        val filter = Filter()

        val listener: CompletableJob = GlobalEventChannel.subscribeAlways<GroupMessageEvent> { event ->
            filter.groupMessageFilter(event.message,event)
        }

        bot.join()
    }
}