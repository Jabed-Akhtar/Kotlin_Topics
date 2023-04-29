/*
 ******************************************************************************
 * @file        : MainActivity.kt
 * @brief       : ...
 *****************************************************************************
 * @author      : Jabed-Akhtar (Github)
 * @date        : 28.04.2023
 *****************************************************************************
 * Description:
 * 	- a source within this script: https://youtu.be/FjrKMcnKahY
 ******************************************************************************
 */

package com.rovmos.tipcalculator

// Imports ====================================================================
import android.animation.ArgbEvaluator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import java.time.temporal.TemporalAmount


// Variables ==================================================================
private const val TAG = "MainActivity"
private const val INITIAL_TIP_PERCENT = 15


// Class - MainActivity =======================================================
class MainActivity : AppCompatActivity() {

    /* *************** Variables *************** */
    private lateinit var etBaseAmount: EditText
    private lateinit var sbTip: SeekBar
    private lateinit var tvTipPercentLabel: TextView
    private lateinit var tvTipAmount: TextView
    private lateinit var tvTotalAmount: TextView
    private lateinit var tvTipDescription: TextView

    /* *************** onCreate function *************** */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etBaseAmount = findViewById(R.id.etBaseAmount)
        sbTip = findViewById(R.id.sbTip)
        tvTipPercentLabel = findViewById(R.id.tvTipPercentLabel)
        tvTipAmount = findViewById(R.id.tvTipAmount)
        tvTotalAmount = findViewById(R.id.tvTotalAmount)
        tvTipDescription = findViewById(R.id.tvTipDescription)

        sbTip.progress = INITIAL_TIP_PERCENT
        tvTipPercentLabel.text = "$INITIAL_TIP_PERCENT%"
        updateTipDescription(INITIAL_TIP_PERCENT)

        sbTip.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean)
            {
                Log.i(TAG, "onProgressChanged $p1")
                tvTipPercentLabel.text = "$p1%"
                computeTipAndTotal()
                updateTipDescription(p1)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) { }

            override fun onStopTrackingTouch(p0: SeekBar?) { }
        })

        etBaseAmount.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) { }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) { }

            override fun afterTextChanged(p0: Editable?)
            {
                Log.i(TAG, "afterTextChanged $p0")
                computeTipAndTotal()
            }

        })
    }

    /* *************** Function to calculate tip and total amount *************** */
    private fun computeTipAndTotal()
    {
        // When there is nothing in the Baseamount, do early return -> Avoid error at "etBaseAmount.text.toString().toDouble()"
        if (etBaseAmount.text.isEmpty())
        {
            tvTotalAmount.text = ""
            tvTotalAmount.text = ""
            return
        }

        // 1. Get the value of the base and tip percent
        val baseAmount = etBaseAmount.text.toString().toDouble()
        val tipPercent =  sbTip.progress

        // 2. Compute the tip and total
        val tipAmount = baseAmount * tipPercent / 100
        val totalAmount = baseAmount + tipAmount

        // 3. Update the UI
        tvTipAmount.text = "%.2f".format(tipAmount)         // Currency has only 2 numbers after decimal point
        tvTotalAmount.text = "%.2f".format(totalAmount)     // Currency has only 2 numbers after decimal point
    }

    /* *************** Function to update tip-description on text-view under SeekBar *************** */
    private fun updateTipDescription(tipPercent: Int)
    {
        val tipDescription = when(tipPercent)
        {
            in 0..9 -> "Poor"
            in 10..14 -> "Acceptable"
            in 15..19 -> "Good"
            in 20..24 -> "Great"
            else -> "Amazing"
        }
        tvTipDescription.text = tipDescription

        // Update color based on the tipPercent
        val color = ArgbEvaluator().evaluate(
            tipPercent.toFloat() / sbTip.max,
            ContextCompat.getColor(this, R.color.color_worst_tip),
            ContextCompat.getColor(this, R.color.color_best_tip)
        ) as Int
        tvTipDescription.setTextColor(color)
    }
}

/* ##### END OF FILE ####################################################### */
