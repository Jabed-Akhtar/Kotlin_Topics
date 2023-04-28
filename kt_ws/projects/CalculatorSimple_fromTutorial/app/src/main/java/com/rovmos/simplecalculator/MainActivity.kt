/*
 ******************************************************************************
 * @file        : MainActivity.kt
 * @brief       : ...
 *****************************************************************************
 * @author      : Jabed-Akhtar (Github)
 * @date        : 28.04.2023
 *****************************************************************************
 * Description:
 * 	- a source within this script: https://youtu.be/2hSHgungOKI
 *
 ******************************************************************************
 */

package com.rovmos.simplecalculator

// Imports ====================================================================
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView


// Class - MainActivity =======================================================
class MainActivity : AppCompatActivity() {

    /* *************** Variables *************** */
    private var canAddOperation = false
    private var canAddDecimal = true

    /* *************** onCreate function *************** */
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /* *************** on clicking Number *************** */
    fun numberAction(view: View)
    {
        if(view is Button)
        {
            if(view.text == ".")
            {
                if(canAddDecimal)
                    findViewById<TextView>(R.id.tvWorking).append(view.text)

                canAddOperation = false
            }
            else
                findViewById<TextView>(R.id.tvWorking).append(view.text)

            canAddOperation = true
        }
    }

    /* *************** on clicking Operation *************** */
    fun operationAction(view: View)
    {
        if(view is Button && canAddOperation)
        {
            findViewById<TextView>(R.id.tvWorking).append(view.text)
            canAddOperation = false
            canAddDecimal = true
        }
    }

    /* *************** on clicking Clear-Button *************** */
    fun allClearAction(view: View)
    {
        findViewById<TextView>(R.id.tvWorking).text = ""
        findViewById<TextView>(R.id.tvResult).text = ""
    }

    /* *************** on clicking Back-Space-Button *************** */
    fun backSpaceAction(view: View)
    {
        val length = findViewById<TextView>(R.id.tvWorking).length()
        if(length > 0)
            findViewById<TextView>(R.id.tvWorking).text = findViewById<TextView>(R.id.tvWorking).text.subSequence(0, length-1)
    }

    /* *************** on clicking Equal-Button *************** */
    fun equalsAction(view: View)
    {
        if(calculateResults().endsWith(".0"))
        {
            findViewById<TextView>(R.id.tvResult).text = calculateResults().subSequence(0, calculateResults().length-2)
        } else {
            findViewById<TextView>(R.id.tvResult).text = calculateResults()
        }
    }

    /* *************** Function to calculate Result *************** */
    private fun calculateResults(): String
    {
        val digitsOperators = digitsOperators()
        if(digitsOperators.isEmpty()) return ""

        val timesDivision = timesDivisionCalculate(digitsOperators)
        if(timesDivision.isEmpty()) return ""

        val result = addSubtractCalculate(timesDivision)
        return result.toString()
    }

    /* *************** Function to calculate Add-Subtract *************** */
    private fun addSubtractCalculate(passedList: MutableList<Any>): Float
    {
        var result = passedList[0] as Float

        for(i in passedList.indices)
        {
            if(passedList[i] is Char && i != passedList.lastIndex)
            {
                val operator = passedList[i]
                val nextDigit = passedList[i + 1] as Float
                if (operator == '+')
                    result += nextDigit
                if (operator == '-')
                    result -= nextDigit
            }
        }

        return result
    }

    /* *************** Function to calculate Division *************** */
    private fun timesDivisionCalculate(passedList: MutableList<Any>): MutableList<Any>
    {
        var list = passedList
        while (list.contains('x') || list.contains('/'))
        {
            list = calcTimesDiv(list)
        }
        return list
    }

    private fun calcTimesDiv(passedList: MutableList<Any>): MutableList<Any>
    {
        val newList = mutableListOf<Any>()
        var restartIndex = passedList.size

        for(i in passedList.indices)
        {
            if(passedList[i] is Char && i != passedList.lastIndex && i < restartIndex)
            {
                val operator = passedList[i]
                val prevDigit = passedList[i - 1] as Float
                val nextDigit = passedList[i + 1] as Float
                when(operator)
                {
                    'x' ->
                    {
                        newList.add(prevDigit * nextDigit)
                        restartIndex = i + 1
                    }
                    '/' ->
                    {
                        newList.add(prevDigit / nextDigit)
                        restartIndex = i + 1
                    }
                    else ->
                    {
                        newList.add(prevDigit)
                        newList.add(operator)
                    }
                }
            }

            if(i > restartIndex)
                newList.add(passedList[i])
        }

        return newList
    }

    /* *************** Function to work on Digit-Operation *************** */
    private fun digitsOperators(): MutableList<Any>
    {
        val list = mutableListOf<Any>()
        var currentDigit = ""
        for(character in findViewById<TextView>(R.id.tvWorking).text)
        {
            if(character.isDigit() || character == '.')
                currentDigit += character
            else
            {
                list.add(currentDigit.toFloat())
                currentDigit = ""
                list.add(character)
            }
        }

        if(currentDigit != "")
            list.add(currentDigit.toFloat())

        return list
    }
}

/* ##### END OF FILE ####################################################### */
