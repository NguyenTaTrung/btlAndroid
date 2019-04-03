package com.example.btl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Lose extends Activity {

    Button btnChoiLai;
    TextView txtSaiDapAn;

    @Override
    protected void onCreate(Bundle s){
        super.onCreate(s);
        setContentView(R.layout.activity_sai_dap_an);

        btnChoiLai = (Button)findViewById(R.id.btnChoiLai);
        txtSaiDapAn = (TextView)findViewById(R.id.txtSaiDapAn);

        btnChoiLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Lose.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}
