/*
 ******************************************************************************
 * @file           : 9_NullSafety.kt
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
    val data: String? = "Students Data Completed!"
    if (data != null) {
        println(data.lowercase())
    }
    println(data?.uppercase())          // Does the operation, only when data variable is not null
}
