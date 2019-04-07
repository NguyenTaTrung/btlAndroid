package com.example.btl;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.CountDownTimer;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;


import java.util.Collections;
import java.util.List;

import info.hoang8f.widget.FButton;


public class MainActivity extends AppCompatActivity {

    FButton btnA, btnB, btnC, btnD;
    TextView txtGameDoVui, timeText, txtCauHoi, txtSai, txtDung1;
    DanhSachCauHoi dsCauHoi;
    CauHoi cauHoi;
    List<CauHoi> list;
    int id = 0;
    int time = 20;
    int sai = 3;
    int diem = 0;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCauHoi = (TextView)findViewById(R.id.txtCauHoi);
        btnA = (FButton)findViewById(R.id.btnA);
        btnB = (FButton)findViewById(R.id.btnB);
        btnC = (FButton)findViewById(R.id.btnC);
        btnD = (FButton)findViewById(R.id.btnD);
        txtGameDoVui = (TextView)findViewById(R.id.txtGameDoVui);
        timeText = (TextView)findViewById(R.id.timeText);
//        txtKQ = (TextView)findViewById(R.id.txtKQ);
        txtSai = (TextView)findViewById(R.id.txtSai);
        txtDung1 = (TextView)findViewById(R.id.txtDung1);

        dsCauHoi = new DanhSachCauHoi(this);

        dsCauHoi.getWritableDatabase();

        if(dsCauHoi.getDanhSachCauHoi().size() == 0){
            dsCauHoi.danhSachCauHoi();
        }

        list = dsCauHoi.getDanhSachCauHoi();

        Collections.shuffle(list);

        cauHoi = list.get(id);

        countDownTimer = new CountDownTimer(22000, 1000) {
            public void onTick(long millisUntilFinished) {

                timeText.setText(String.valueOf(time) + "s");
                txtSai.setText(String.valueOf(sai));

                time -= 1;

                if(time == 0){
//                    txtKQ.setText(getString(R.string.timeup));
                    disableButton();
                }
            }

            @Override
            public void onFinish() {
                HetGio();
            }
        }.start();

        update();
    }

    public void update(){
        txtCauHoi.setText(cauHoi.getCauHoi());
        btnA.setText(cauHoi.getDapAnA());
        btnB.setText(cauHoi.getDapAnB());
        btnC.setText(cauHoi.getDapAnC());
        btnD.setText(cauHoi.getDapAnD());

        time = 20;

        countDownTimer.cancel();
        countDownTimer.start();

        txtDung1.setText(String.valueOf(diem));
        diem++;
    }

    public void Y(){
        sai -= 1;
        if(sai==-1){
            Lose();
        }
    }

    public void btnA(View view){
        if(cauHoi.getDapAnA().equals(cauHoi.getTraloi())){
            btnA.setButtonColor(ContextCompat.getColor(getApplicationContext(),R.color.lightGreen));
            if(id < list.size() - 1){
                disableButton();
                DungDapAn();
            }
            else {
                Win();
            }
        }
        else{
            Y();
        }
    }

    public void btnB(View view){
        if(cauHoi.getDapAnB().equals(cauHoi.getTraloi())){
            btnB.setButtonColor(ContextCompat.getColor(getApplicationContext(),R.color.lightGreen));
            if(id < list.size() - 1){
                disableButton();
                DungDapAn();
            }
            else {
                Win();
            }
        }
        else {
            Y();
        }
    }

    public void btnC(View view){
        if(cauHoi.getDapAnC().equals(cauHoi.getTraloi())){
            btnC.setButtonColor(ContextCompat.getColor(getApplicationContext(),R.color.lightGreen));
            if(id < list.size() - 1){
                disableButton();
                DungDapAn();
            }
            else {
                Win();
            }
        }
        else {
            Y();
        }
    }

    public void btnD(View view){
        if(cauHoi.getDapAnD().equals(cauHoi.getTraloi())){
            btnD.setButtonColor(ContextCompat.getColor(getApplicationContext(),R.color.lightGreen));
            if(id < list.size() - 1){
                disableButton();
                DungDapAn();
            }
            else {
                Win();
            }
        }
        else {
            Y();
        }
    }

    public void Win(){
        Intent i = new Intent(this,Win.class);
        startActivity(i);
        finish();
    }

    public void Lose(){
        Intent i = new Intent(this,Lose.class);
        startActivity(i);
        finish();
    }

    public void HetGio(){
        Intent i = new Intent(this,HetGio.class);
        startActivity(i);
        finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        countDownTimer.cancel();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        countDownTimer.start();
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, Home.class);
        startActivity(i);
        finish();
    }

    public void DungDapAn(){
        final Dialog d = new Dialog(MainActivity.this);
//        hộp thoại k có tiêu đề
        d.requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (d.getWindow() != null){
            ColorDrawable cd = new ColorDrawable(Color.TRANSPARENT);
            d.getWindow().setBackgroundDrawable(cd);
        }
        d.setContentView(R.layout.activity_dung_dap_an);
        d.setCancelable(false);
        d.show();

        onPause();

//        TextView txtDung = (TextView)d.findViewById(R.id.txtDung);
        FButton btnCauTiep = (FButton)d.findViewById(R.id.btnCauTiep);

        btnCauTiep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //bỏ hộp thoại
                d.dismiss();
                id++;
                //lấy tùy chọn câu hỏi được lưu trong list
                cauHoi = list.get(id);
                //câu hỏi mới
                update();
                ResetColor();
                enableButton();
            }
        });
    }

    public void ResetColor(){
        btnA.setButtonColor(ContextCompat.getColor(getApplicationContext(),R.color.fbutton_color_peter_river));
        btnB.setButtonColor(ContextCompat.getColor(getApplicationContext(),R.color.fbutton_color_peter_river));
        btnC.setButtonColor(ContextCompat.getColor(getApplicationContext(),R.color.fbutton_color_peter_river));
        btnD.setButtonColor(ContextCompat.getColor(getApplicationContext(),R.color.fbutton_color_peter_river));
    }

    public void disableButton(){
        btnA.setEnabled(false);
        btnB.setEnabled(false);
        btnC.setEnabled(false);
        btnD.setEnabled(false);
    }

    public void enableButton(){
        btnA.setEnabled(true);
        btnB.setEnabled(true);
        btnC.setEnabled(true);
        btnD.setEnabled(true);
    }
}
