package com.lolimizuki.mzandroids.typs

object NumbersHelp {

    @JvmStatic
    fun doubleFromString(string: String): Double? {
        return Double.from(string)
    }

    @JvmStatic
    fun doubleFromString(string: String, defaule: Double): Double {
        return Double.from(string, defaule)
    }

    @JvmStatic
    fun decimalSeparator(): String {
        return Double.decimalSeparator()
    }

    @JvmStatic
    fun notAllowDecimalSeparator(): String {
        return Double.notAllowDecimalSeparator()
    }
}