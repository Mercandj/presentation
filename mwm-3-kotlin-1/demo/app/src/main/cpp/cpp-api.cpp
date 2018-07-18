// The goal of this class is to hide domain / code (stronger than only proguard)

#include <jni.h>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_mwm_demo_1kotlin_jni_BridgeJni_getString(
        JNIEnv *env,
        jclass /* this */) {
    return env->NewStringUTF("Hello");
}