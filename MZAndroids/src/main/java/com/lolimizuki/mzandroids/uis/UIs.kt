package com.lolimizuki.mzandroids.uis

import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.EditText

fun EditText.setPasswordStyle(enable: Boolean) {
    transformationMethod = if (enable) {
        PasswordTransformationMethod.getInstance()
    } else {
        HideReturnsTransformationMethod.getInstance()
    }
}

fun EditText.isPasswordStyle(): Boolean {
    return transformationMethod == PasswordTransformationMethod.getInstance()
}