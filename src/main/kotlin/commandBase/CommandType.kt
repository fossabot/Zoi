package commandBase

/**
 *
 * @constructor 指令类型
 */

@Target(AnnotationTarget.CLASS)
annotation class GroupCommand

@Target(AnnotationTarget.CLASS)
annotation class PrivateCommand

@Target(AnnotationTarget.CLASS)
annotation class EverywhereCommand