package com.kukuhsain.opusplayer.nativelib;

/**
 * Created by kukuh on 13/04/17.
 */

public class HelloJni {

    static {
        System.loadLibrary("native-lib");
    }

    public static native String helloFromJni();
}
