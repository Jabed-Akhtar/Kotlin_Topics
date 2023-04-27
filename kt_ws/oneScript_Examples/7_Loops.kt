/*
 ******************************************************************************
 * @file           : 7_Loops.kt
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

fun main(){
    val cities = listOf("Alexandria","Barcelona", "Toronto", "Berlin")
    //For Loop
    for (city in cities) {
        println(city)
    }

    for (i in 1 .. 4)
        println(i)

    for (i in 1 until 5)
        println(i)

    //While Loop
    var index = 0
    while (index < cities.size){
        println("City at $index index is ${cities[index]}")
        index ++
    }
}
