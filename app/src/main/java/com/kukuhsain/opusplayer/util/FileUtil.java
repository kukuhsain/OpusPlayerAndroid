package com.kukuhsain.opusplayer.util;

import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import com.kukuhsain.opusplayer.OpusPlayerApp;

/**
 * Created by kukuh on 08/04/17.
 */

public class FileUtil {

    public static String getRealPathFromUri(Uri uri) {
        Cursor cursor = OpusPlayerApp.getInstance().getContentResolver()
                .query(uri, null, null, null, null);
        if (cursor == null) {
            return uri.getPath();
        }
        cursor.moveToFirst();
        int index = cursor.getColumnIndex(MediaStore.Files.FileColumns.DATA);
        String realPath = cursor.getString(index);
        cursor.close();
        return realPath;
    }
}
