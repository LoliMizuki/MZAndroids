package com.lolimizuki.mzandroids.typs

import android.text.Editable
import java.math.BigInteger
import java.security.MessageDigest

fun String.ediable(): Editable {
    return Editable.Factory.getInstance().newEditable(this)
}

fun String.md5(): String {
    val md = MessageDigest.getInstance("MD5")
    return BigInteger(1, md.digest(toByteArray()))
        .toString(16)
        .padStart(32, '0')
}