package com.mwm.demo_kotlin.java;

import android.util.Log;

import com.mwm.demo_kotlin.java_interoperability.Interoperability;

public class JavaClass {

    public void callStaticKotlinCode() {
        Interoperability.myStaticFunctionInJava();
        //Interroperability.myNotStaticFunctionInJava(); // doesn't accessible in Java
    }

    public void callStaticKotlinCodeFromCompanion() {
        Interoperability.Companion.myNotStaticFunctionInJava();
    }

    public void displayKotlinTAG(){
        Log.i(Interoperability.TAG,"Message with kotlin TAG and myVar : " + Interoperability.myVar);
    }

}
