/*
 ******************************************************************************
 * @file           : 8_Functions.kt
 * @brief          : ...
 ******************************************************************************
 * @author         : Jabed-Akhtar (Github)
 * @date           : 27.04.2023
 ******************************************************************************
 * Description:
 * 	- a source within this script: https://github.com/BekBrace/Kotlin-Sandbox
 * 	- Related doc/file can be found at location: '<project-dir>/zz_docs/...'
 *
 ******************************************************************************
*/

fun sayHello() {
    println("Hello!")
}

private fun sayHelloToSomeone(name: String) {
    println("Hello, $name !")
}

fun add() : Int = 20 + 30

fun divide(x:Int, y:Int): Int = x / y

fun myFun(a: Int, y:Int): Int{
    return (a+y) / 2
}

fun main() {
    sayHello()
    sayHelloToSomeone("John")
    println(add())
    println(divide(x=100, y=50))

    println(myFun(5, 5))
}
