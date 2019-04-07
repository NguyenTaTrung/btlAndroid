package com.example.btl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.media.MediaPlayer;
import android.widget.ImageButton;

import info.hoang8f.widget.FButton;

public class Home extends AppCompatActivity {
    FButton btnBatDau,btnThoat,btnHD;
    TextView txtDoVui;
//    private MediaPlayer sound;

    @Override
    protected  void onCreate(Bundle save) {
        super.onCreate(save);
        setContentView(R.layout.activity_home);

        btnBatDau = (FButton) findViewById(R.id.btnBatDau);
        btnThoat = (FButton) findViewById(R.id.btnThoat);
        btnHD = (FButton) findViewById(R.id.btnHD);
        txtDoVui = (TextView) findViewById(R.id.txtDoVui);
//        sound = MediaPlayer.create(Home.this, R.raw.boom_online);
//        ImageButton s = (ImageButton) findViewById(R.id.btnSound);
//        ImageButton o = (ImageButton) findViewById(R.id.btnOutSound);

        btnBatDau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnHD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this, HuongDan.class);
                startActivity(i);
                finish();
            }
        });

//        s.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sound.start();
//            }
//        });
//
//        o.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sound.stop();
//            }
//        });
//
//        sound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//            @Override
//            public void onCompletion(MediaPlayer mp) {
//                if (sound.isLooping()) {
//                }else {
//                    sound.start();
//                }
//            }
//        });

    }

//    @Override
//    protected void onPause(){
//        super.onPause();
//        sound.pause();
//    }

//        @Override
//        protected void onRestart () {
//            super.onRestart();
//            sound.start();
//        }
    public void playSong(View view)  {
        Intent intent = new Intent(Home.this, PlaySong.class);
        startService(intent);
    }

    public void stopSong(View view)  {
        Intent intent = new Intent(Home.this, PlaySong.class);
        stopService(intent);
    }
}
