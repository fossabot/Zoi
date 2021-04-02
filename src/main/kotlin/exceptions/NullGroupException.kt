package exceptions

import java.lang.Exception

class NullGroupException : Exception() {
    override fun printStackTrace() {
        println("未找到该群组，是不是打错了?")
    }
}