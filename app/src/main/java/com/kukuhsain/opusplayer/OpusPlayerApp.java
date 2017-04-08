package com.kukuhsain.opusplayer;

import android.app.Application;

/**
 * Created by kukuh on 08/04/17.
 */

public class OpusPlayerApp extends Application {

    private static OpusPlayerApp INSTANCE;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
    }

    public static OpusPlayerApp getInstance() {
        return INSTANCE;
    }
}
