//
// Created by kukuh on 13/04/17.
//

#include <jni.h>
#include <string>

extern "C"

JNIEXPORT jstring JNICALL
Java_com_kukuhsain_opusplayer_nativelib_HelloJni_helloFromJni(
    JNIEnv *env, jobject) {
        std::string hello = "Hello World, from C++";
        return env -> NewStringUTF(hello.c_str());
    }