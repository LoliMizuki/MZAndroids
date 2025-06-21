package com.lolimizuki.mzandroids

import android.text.Editable

fun String.ediable(): Editable {
    return Editable.Factory.getInstance().newEditable(this)
}

object StringsHelp {

    @JvmStatic
    fun ediable(string: String): Editable {
        return string.ediable()
    }
}