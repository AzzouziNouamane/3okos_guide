package com.e3okoss.tesGuide;

import android.content.Context;

public class Detector {

    static {
        System.loadLibrary("detect_lib");
    }

    public static native void init(Context context);
    public static native String getsys();
}
