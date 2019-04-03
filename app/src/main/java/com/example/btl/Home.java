package com.example.btl;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import info.hoang8f.widget.FButton;

public class Home extends AppCompatActivity {
    FButton btnBatDau,btnThoat;
    TextView txtDoVui;

    @Override
    protected  void onCreate(Bundle save) {
        super.onCreate(save);
        setContentView(R.layout.activity_home);

        btnBatDau = (FButton)findViewById(R.id.btnBatDau);
        btnThoat = (FButton)findViewById(R.id.btnThoat);
        txtDoVui = (TextView)findViewById(R.id.txtDoVui);

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
    }

}
