//
// Created by naiim on 11/22/2020.
//
#include <jni.h>
#include <string>
#include "data.h"
#include "helpers.h"

using namespace std;


extern "C" JNIEXPORT void JNICALL
Java_com_e3okoss_tesGuide_Detector_init(JNIEnv *env, jclass calling_object,
                                             jobject contextApp) {
    string currentPackageName = getPackageName(env, contextApp);
    if (currentPackageName != Data::getPackageName()) {
        raise(SIGSEGV);
    }
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_e3okoss_tesGuide_Detector_getsys(JNIEnv *env, jclass clazz) {
    return (env)->  NewStringUTF("http://192.168.0.213/android/3okoskhan.json");
}

