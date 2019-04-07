package com.example.btl;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class PlaySong extends Service {

    private MediaPlayer sound;
    public PlaySong() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    @Override
    public void onCreate(){
        super.onCreate();
        sound = MediaPlayer.create(getApplicationContext(), R.raw.boom_online);

        sound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if (sound.isLooping()) {
                }else {
                    sound.start();
                }
            }
        });
    }

    public int onStartCommand(Intent intent, int flags, int startId){
        sound.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        sound.stop();
        super.onDestroy();
    }
}
