package commandBase

import commandBase.interfaces.CommandManager
import commandBase.interfaces.CommandManager.Companion.commandPrefixes
import commandBase.interfaces.CommandManager.Companion.commandUnits
import commandBase.interfaces.CommandUnit

class CommandManagerImp : CommandManager {

    override fun regCommandPrefixes(vararg prefixs: Char) {
        for (prefix in prefixs)
        {
            commandPrefixes.add(prefix)
        }
    }

    override fun regCommandUnit(vararg Object: CommandUnit) {
        for (command in Object)
        {
            commandUnits[command.name] = command
        }
    }

}