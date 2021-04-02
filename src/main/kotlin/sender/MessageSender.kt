package sender

import exceptions.NullGroupException
import net.mamoe.mirai.message.data.Message

class MessageSender {
    suspend fun sendGroupMessage(groupId: Long, message: Message)
    {
        val group = BotInit.bot.getGroup(groupId)
        if (group != null)
        {
            group.sendMessage(message)
        }
        else
        {
            throw NullGroupException()
        }
    }

    suspend fun sendFriendMessage(userId: Long,message: Message)
    {
        val user = BotInit.bot.getFriendOrFail(userId)
        user.sendMessage(message)
    }

    suspend fun sendStrangerMessage(userId: Long,message: Message)
    {
        val user = BotInit.bot.getStrangerOrFail(userId)
        user.sendMessage(message)
    }

    suspend fun sendGroupMemberMessage(groupId: Long,userId: Long,message: Message)
    {
        val group = BotInit.bot.getGroup(groupId)
        if (group != null)
        {
            group[userId]?.sendMessage(message)
        }
        else
        {
            throw NullGroupException()
        }
    }
}