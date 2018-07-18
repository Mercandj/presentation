package com.mwm.demo_kotlin.val_var

object ValVarTester {

    private lateinit var lateField: String

    fun init() {
        if (!::lateField.isInitialized) {
            lateField = "42"
        }
    }

    fun get(): String {
        return lateField
    }

    /**
     * Will throw
     */
    fun valVar(): Int {
        val immutableInt1 = 1
        val immutableInt2: Int = 2
        var mutableInt1 = 3
        mutableInt1 = 4
        var mutableInt2: Int = 5
        var mutableInt3: Int? = null
        return immutableInt1 + immutableInt2 + mutableInt1 +
                mutableInt2 + mutableInt3!!
    }

}