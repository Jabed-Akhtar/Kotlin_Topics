/*
 ******************************************************************************
 * @file           : 3_Operators.kt
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
    val name: String = "Britney"
    val surname: String = "Spears"
    val fullName = name + (" ") + surname
    println(fullName)

    val num1: Int = 10
    val num2: Int = 5
    val addition = num1 + num2
    val subtraction = num1 - num2
    val multiplication = num1 * num2
    val division = num1 / num2
    val modulo = num1 % num2

    println("Addition of 10 and 5 = $addition")
    println("Subtraction of 10 and 5 = $subtraction")
    println("Multiplication of 10 and 5 = $multiplication")
    println("Division of 10 and 5 = $division")
    println("Remainder of 10 and 5 = $modulo")
}
