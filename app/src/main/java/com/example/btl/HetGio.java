package com.example.btl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import info.hoang8f.widget.FButton;

public class HetGio extends AppCompatActivity {
    FButton btnChoiLai;
    TextView txtHetGio;

    @Override
    protected void onCreate(Bundle s){
        super.onCreate(s);
        setContentView(R.layout.activity_het_gio);

        btnChoiLai = (FButton)findViewById(R.id.btnChoiLai);
        txtHetGio = (TextView)findViewById(R.id.txtHetGio);

        btnChoiLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HetGio.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

}
