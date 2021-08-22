package com.example.additionallabsheet;

import static android.app.Service.START_STICKY;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.Settings;

public class MainActivity extends AppCompatActivity {

    private Thread player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MediaPlayer player =
                MediaPlayer.create(this, Settings.System.DEFAULT_NOTIFICATION_URI);
        player.setLooping(true);
        player.start();
    }
    public int onStartCommand(Intent intent, int flags, int startId) {
        MediaPlayer player = MediaPlayer.create(this,
                Settings.System.DEFAULT_NOTIFICATION_URI);
        player.setLooping(true);
        player.start();
        return START_STICKY;
        //return super.onStartCommand(intent, flags, startId);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        player.stop();
    }




}






