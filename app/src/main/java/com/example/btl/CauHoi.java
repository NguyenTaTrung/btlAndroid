package com.example.btl;

import android.app.Activity;

public class CauHoi extends Activity {
    private int id;
    private String cauhoi;
    private String daA;
    private String daB;
    private String daC;
    private String daD;
    private String traloi;

    public CauHoi(String ch, String a, String b, String c, String d, String tl) {

        cauhoi = ch;
        daA = a;
        daB = b;
        daC = c;
        daD = d;
        traloi = tl;
    }

    public CauHoi() {

        id = 0;
        cauhoi = "";
        daA = "";
        daB = "";
        daC = "";
        daD = "";
        traloi = "";
    }

    public String getCauHoi() {
        return cauhoi;
    }

    public String getDapAnA() {
        return daA;
    }

    public String getDapAnB() {
        return daB;
    }

    public String getDapAnC() {
        return daC;
    }

    public String getDapAnD() {
        return daD;
    }

    public String getTraloi() {
        return traloi;
    }

    public void setId(int i) {
        id = i;
    }

    public void setCauHoi(String ch) {
        cauhoi = ch;
    }

    public void setDaA(String a){
        daA = a;
    }

    public void setDaB(String b){
        daB = b;
    }

    public  void setDaC(String c){
        daC = c;
    }

    public void setDaD(String d){
        daD = d;
    }

    public void setTraloi(String tl){
        traloi = tl;
    }
}
