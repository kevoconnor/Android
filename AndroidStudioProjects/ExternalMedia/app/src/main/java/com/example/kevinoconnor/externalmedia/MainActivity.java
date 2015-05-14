package com.example.kevinoconnor.externalmedia;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import java.io.IOException;

public class MainActivity extends Activity implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener{

    Button play1 = null;
    Button pause1 = null;
    Button play2 = null;
    Button pause2 = null;
    Button play3 = null;
    Button pause3 = null;
    Button play4 = null;
    Button pause4 = null;
    Button stopAll = null;
    MediaPlayer mp1;
    MediaPlayer mp2;
    MediaPlayer mp3;
    MediaPlayer mp4;
    private String path;
    private String path2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play1 = (Button) findViewById(R.id.play1);
        pause1 = (Button) findViewById(R.id.pause1);
        play2 = (Button) findViewById(R.id.play2);
        pause2 = (Button) findViewById(R.id.pause2);
        play3 = (Button) findViewById(R.id.play3);
        pause3 = (Button) findViewById(R.id.pause3);
        play4 = (Button) findViewById(R.id.play4);
        pause4 = (Button) findViewById(R.id.pause4);
        stopAll = (Button) findViewById(R.id.stopButton);

        mp1 = MediaPlayer.create(getApplicationContext(), R.raw.fork);
        mp1.setOnCompletionListener(this);
        pause1.setEnabled(false);

        path = Environment.getExternalStorageDirectory().getPath() + "/birthday.mp3";
        Log.d("MainActivity", path);

        mp2 = new MediaPlayer();
        play2.setEnabled(false);

        try {
            mp2.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mp2.setDataSource(path);
            mp2.setOnPreparedListener(this);
            mp2.setOnCompletionListener(this);
            mp2.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }

        mp3 = new MediaPlayer();
        play3.setEnabled(false);

        try {
            mp3.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mp3.setDataSource("http://stream49.livemixtapes.com/content/artists/spinatik/street_runnaz_67/A7B0E2BA.mp3");
            mp3.setOnPreparedListener(this);
            mp3.setOnCompletionListener(this);
            mp3.prepareAsync();
        } catch (IOException e) {
            e.printStackTrace();
        }

        path2 = Environment.getExternalStorageDirectory().getPath() + "/wilhelm.mp3";
        Log.d("MainActivity", path2);

        mp4 = new MediaPlayer();
        play4.setEnabled(false);

        try {
            mp4.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mp4.setDataSource(path2);
            mp4.setOnPreparedListener(this);
            mp4.setOnCompletionListener(this);
            mp4.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void playResource(View v){
        mp1.start();
        pause1.setEnabled(true);
        play1.setEnabled(false);
    }

    public void pauseResource(View v){
        mp1.pause();
        pause1.setEnabled(false);
        play1.setEnabled(true);
    }

    public void playInternal(View v){
        mp2.start();
        pause2.setEnabled(true);
        play2.setEnabled(false);
    }

    public void pauseInternal(View v){
        mp2.pause();
        pause2.setEnabled(false);
        play2.setEnabled(true);
    }

    public void playNetwork(View v){
        mp3.start();
        pause3.setEnabled(true);
        play3.setEnabled(false);
    }

    public void pauseNetwork(View v){
        mp3.pause();
        pause3.setEnabled(false);
        play3.setEnabled(true);
    }

    public void playWilhelm(View v){
        mp4.start();
        pause4.setEnabled(true);
        play4.setEnabled(false);
    }

    public void pauseWilhelm(View v){
        mp4.pause();
        pause4.setEnabled(false);
        play4.setEnabled(true);
    }

    public void stop2Chainz(View v){
        if (mp1.isPlaying())
            mp1.stop();
        if (mp2.isPlaying())
            mp2.stop();
        if (mp3.isPlaying())
            mp3.stop();
        if (mp4.isPlaying())
            mp4.stop();

        play1.setEnabled(true);
        pause1.setEnabled(false);
        play2.setEnabled(true);
        pause2.setEnabled(false);
        play3.setEnabled(true);
        pause3.setEnabled(false);
        play4.setEnabled(true);
        pause4.setEnabled(false);
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        play1.setEnabled(true);
        pause1.setEnabled(false);
        play2.setEnabled(true);
        pause2.setEnabled(false);
        play3.setEnabled(true);
        pause3.setEnabled(false);
        play4.setEnabled(true);
        pause4.setEnabled(false);
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        play1.setEnabled(true);
        pause1.setEnabled(false);
        play2.setEnabled(true);
        pause2.setEnabled(false);
        play3.setEnabled(true);
        pause3.setEnabled(false);
        play4.setEnabled(true);
        pause4.setEnabled(false);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mp1.release();
        mp2.release();
        mp3.release();
        mp4.release();
    }
}
