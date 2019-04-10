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

        //csdl
        dsCauHoi = new DanhSachCauHoi(this);
        //đọc ghi csdl
        dsCauHoi.getWritableDatabase();
        //kiểm tra xem các câu hỏi, đáp án và câu trả lời đã được thêm vào trong bảng hay chưa
        //nếu chưa thì trả về ds có kích thước = 0
        if(dsCauHoi.getDanhSachCauHoi().size() == 0){
            dsCauHoi.danhSachCauHoi();
        }
        //tạo 1 list là các dsch
        list = dsCauHoi.getDanhSachCauHoi();
        //random câu hỏi
        Collections.shuffle(list);
        //lấy câu hỏi, các đáp án lời cho id tương ứng
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

    public void btnA(View view){
        if(cauHoi.getDapAnA().equals(cauHoi.getTraloi())){
            btnA.setButtonColor(ContextCompat.getColor(getApplicationContext(),R.color.lightGreen));
            //nếu còn list các câu hỏi
            if(id < list.size() - 1){
                disableButton();
                DungDapAn();
            }
            else {
                Win();
            }
        }
        else{
            ConLai();
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
            ConLai();
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
            ConLai();
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
            ConLai();
        }
    }

    public void ConLai(){
        sai -= 1;
        if(sai == -1){
            Lose();
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

    public void DungDapAn(){
        final Dialog d = new Dialog(MainActivity.this);
        //thông báo k có tiêu đề
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
                //bỏ thông báo
                d.dismiss();
                id++;
                //lấy câu hỏi, câu trả lời có trong list tương ứng với id đó
                cauHoi = list.get(id);
                //setText cho các button
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

    @Override
    protected void onStop() {
        super.onStop();
        countDownTimer.cancel();
    }
}
