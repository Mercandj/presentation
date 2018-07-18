package com.mwm.demo_kotlin.java;

import android.util.Log;

import com.mwm.demo_kotlin.java_interoperability.Interoperability;
import com.mwm.demo_kotlin.java_interoperability.ThrowException;

import java.io.IOException;

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

//    This method doesn't compile because myMethodThrowException doesn't throw an exception in the prototype
//    public void catchExceptionFromKotlin(){
//        ThrowException e = new ThrowException();
//        try {
//            e.myMethodThrowException();
//        }catch(IOException exception){
//            Log.e("JavaClass", "Exception catched in catchExceptionFromKotlin");
//        }
//    }

    public void catchExceptionWithSuccessFromKotlin(){
        ThrowException e = new ThrowException();
        try {
            e.myMethodThrowExceptionCatchableFromJava();
        }catch(IOException exception){
            Log.e("JavaClass", "Exception catched in catchExceptionWithSuccessFromKotlin");
        }
    }

}
