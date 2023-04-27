/*
 ******************************************************************************
 * @file           : 2_Variables.kt
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
    val myName: String = "Jabed"    // constant value
    var myAge = 40                  // Values can be changed | is same as val myAge: Int = 40
    println(myName)
    println(myAge)

    var hugeInt: Int = Int.MAX_VALUE
    var tinyInt: Int = Int.MIN_VALUE

    println("The Biggest Integer: " + hugeInt)
    println("The Smallest Integer: $tinyInt") // string interpolation

    //LONG
    var hugeLong: Long = Long.MAX_VALUE
    var tinyLong: Long = Long.MIN_VALUE

    println("The Biggest long: " + hugeLong)
    println("The Smallest long: $tinyLong")

    //Double
    var hugeDouble: Double = Double.MAX_VALUE
    var tinyDouble: Double = Double.MIN_VALUE

    println("The Biggest double: " + hugeDouble)
    println("The Smallest double: $tinyDouble")

    //Float
    var hugeFloat: Float = Float.MAX_VALUE
    var tinyFloat: Float = Float.MIN_VALUE

    println("The Biggest float: " + hugeFloat)
    println("The Smallest float: $tinyFloat")
}
