/*
 ******************************************************************************
 * @file           : 6_Collections.kt
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

fun main() {
    val city1 = "Alexandria"
    val city2 = "Barcelona"
    val city3 = "Toronto"
    val city4 = "Berlin"
    val cities = mutableListOf<Any>("Alexandria","Barcelona", "Toronto", "Berlin") // mutable enables changing the list contents
    println(cities[0])
    cities.add("Rome")
    println(cities)
    cities.remove(cities[1])
    println(cities)
    cities.add(10)      // 10 can be added to list, because variable-type is set to 'Any'
    println(cities)
}
