package com.example.btl;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;

import info.hoang8f.widget.FButton;

public class Win extends Activity {

    @Override
    protected void onCreate(Bundle s){
        super.onCreate(s);
        setContentView(R.layout.activity_win);

        FButton btnWin = (FButton)findViewById(R.id.btnWin);
        btnWin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Win.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

//    public void Win(View view){
//        Intent i = new Intent(Win.this,MainActivity.class);
//        startActivity(i);
//        finish();
//    }
}
