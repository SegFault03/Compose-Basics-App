package com.example.composeapp

import org.junit.Test

import org.junit.Assert.*
import java.text.NumberFormat

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class TipCalculatorUnitTests {
    @Test
    fun tipCalculatorNoRoundOff() {
        val tip = 20.00
        val amount = 10.00
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        val actualTip = calculateTip(roundUp = false, amount = amount, tipPercent = tip)
        assertEquals(actualTip, expectedTip)
    }
}