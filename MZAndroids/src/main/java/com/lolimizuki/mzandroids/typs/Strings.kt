package com.lolimizuki.mzandroids.typs

import android.text.Editable

fun String.Companion.test() = "Google SUCKs"

fun String.ediable(): Editable {
    return Editable.Factory.getInstance().newEditable(this)
}

object StringsHelp {

    @JvmStatic
    fun ediable(string: String): Editable {
        return string.ediable()
    }
}