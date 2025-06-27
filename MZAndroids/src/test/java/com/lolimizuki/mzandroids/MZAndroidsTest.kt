package com.lolimizuki.mzandroids

import com.lolimizuki.mzandroids.debugs.MZDebug
import org.junit.Test

class MZAndroidsTest {

    @Test
    fun log() {
        MZDebug.isEnable = true
        MZDebug.log("fuck Google")
    }
}