package commandBase.interfaces

import commandBase.interfaces.CommandUnit

interface CommandManager {
    companion object{
        /**
         * 保存已注册的指令前缀
         */
        val commandPrefixes: HashSet<Char> = HashSet()

        /**
         * 保存已注册的指令
         */
        val commandUnits: HashMap<String, CommandUnit> = HashMap()
    }

    /**
     *
     * @param prefixes Array<out String> 指令前缀
     */
    fun regCommandPrefixes(vararg prefixes: Char)

    /**
     *
     * @param Object Array<out CommandUnit> 注册指令
     */
    fun regCommandUnit(vararg Object: CommandUnit)
}