import kotlinx.coroutines.CompletableJob
import messageFilter.Filter
import net.mamoe.mirai.Bot
import net.mamoe.mirai.event.GlobalEventChannel
import net.mamoe.mirai.event.events.GroupMessageEvent

class BotInit {
    companion object{
        lateinit var bot: Bot
        lateinit var workDir: String
    }

    /**
     *
     * @param passBot Bot 传入机器人对象实例
     * @param passWorkDir String 传入工作目录路径
     */
    suspend fun init(passBot: Bot,passWorkDir: String)
    {
        bot = passBot
        workDir = passWorkDir
        val filter = Filter()

        val listener: CompletableJob = GlobalEventChannel.subscribeAlways<GroupMessageEvent> { event ->
            filter.groupMessageFilter(event.message,event)
        }

        bot.join()
    }
}