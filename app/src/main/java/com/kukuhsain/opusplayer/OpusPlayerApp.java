package com.kukuhsain.opusplayer;

import android.app.Application;

import timber.log.Timber;

/**
 * Created by kukuh on 08/04/17.
 */

public class OpusPlayerApp extends Application {

    private static OpusPlayerApp INSTANCE;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    public static OpusPlayerApp getInstance() {
        return INSTANCE;
    }
}
