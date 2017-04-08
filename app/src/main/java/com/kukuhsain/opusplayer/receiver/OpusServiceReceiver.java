package com.kukuhsain.opusplayer.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import timber.log.Timber;
import top.oply.opuslib.OpusEvent;

/**
 * Created by kukuh on 08/04/17.
 */

public class OpusServiceReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        int type = bundle.getInt(OpusEvent.EVENT_TYPE, 0);
        Timber.d("Event received...");
        switch (type) {
            case OpusEvent.PLAY_GET_AUDIO_TRACK_INFO:
                Timber.d("PLAY_GET_AUDIO_TRACK_INFO");
                break;
            case OpusEvent.PLAY_PROGRESS_UPDATE:
                Timber.d("PLAY_PROGRESS_UPDATE");
                break;
            case OpusEvent.PLAYING_FAILED:
                Timber.d("PLAYING_FAILED");
                break;
            case OpusEvent.PLAYING_FINISHED:
                Timber.d("PLAYING_FINISHED");
                break;
            case OpusEvent.PLAYING_PAUSED:
                Timber.d("PLAYING_PAUSED");
                break;
            case OpusEvent.PLAYING_STARTED:
                Timber.d("PLAYING_STARTED");
                break;
            default:
                Timber.d("Unavailable feature...");
        }
    }
}
