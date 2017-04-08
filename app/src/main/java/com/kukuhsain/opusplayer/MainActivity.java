package com.kukuhsain.opusplayer;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kukuhsain.opusplayer.util.FileUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pub.devrel.easypermissions.EasyPermissions;
import top.oply.opuslib.OpusPlayer;

public class MainActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks {

    @BindView(R.id.tv_file_name) TextView tvFileName;
    @BindView(R.id.iv_play) ImageView ivPlay;
    @BindView(R.id.iv_pause) ImageView ivPause;

    private final int PICK_OPUS_FILE_REQUEST = 1000;
    private String filePath;
    private OpusPlayer opusPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        opusPlayer = OpusPlayer.getInstance();
    }

    @OnClick(R.id.btn_pick)
    public void checkForPermission() {
        EasyPermissions.requestPermissions(this,
                "Opus Player need a permission to be able to get opus file from your storage",
                PICK_OPUS_FILE_REQUEST,
                Manifest.permission.READ_EXTERNAL_STORAGE);
    }

    public void pickOpusFile() {
        Intent intent = new Intent();
        intent.setType("*/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_OPUS_FILE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_OPUS_FILE_REQUEST && resultCode == RESULT_OK && data != null) {
            Uri fileUri = data.getData();
            filePath = FileUtil.getRealPathFromUri(fileUri);
            tvFileName.setText(filePath);
            tvFileName.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
        pickOpusFile();
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        Toast.makeText(this, "You are not permitted!", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.iv_play)
    public void playOpusFile() {
        if (filePath == null) {
            Toast.makeText(this, "No opus file picked!", Toast.LENGTH_SHORT).show();
            return;
        }
        ivPlay.setVisibility(View.GONE);
        ivPause.setVisibility(View.VISIBLE);
        opusPlayer.play(filePath);
    }

    @OnClick(R.id.iv_pause)
    public void pauseOpusFile() {
        ivPlay.setVisibility(View.VISIBLE);
        ivPause.setVisibility(View.GONE);
        opusPlayer.stop();
    }
}
