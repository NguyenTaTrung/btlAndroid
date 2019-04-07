package com.example.btl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import info.hoang8f.widget.FButton;

public class HuongDan extends AppCompatActivity{
    FButton btnBack;
    TextView nd, nd1, nd2;

    @Override
    protected void onCreate(Bundle s){
        super.onCreate(s);
        setContentView(R.layout.activity_gioi_thieu);

        btnBack = (FButton)findViewById(R.id.btnBack);
        nd = (TextView)findViewById(R.id.txtNoiDung);
        nd1 = (TextView)findViewById(R.id.txtNoiDung1);
        nd2 = (TextView)findViewById(R.id.txtNoiDung2);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HuongDan.this,Home.class);
                startActivity(i);
                finish();
            }
        });
    }
}
