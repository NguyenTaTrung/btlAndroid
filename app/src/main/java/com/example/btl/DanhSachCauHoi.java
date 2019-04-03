package com.example.btl;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class DanhSachCauHoi extends SQLiteOpenHelper {

    private Context context;
    private static final String DB = "DoVui.db";

    private static final int DB_VERSION = 3;
    private static final String TABLE = "CauHoi";
    private static final String ID = "ID";
    private static final String CAU_HOI = "CauHoi";
    private static final String DAP_AN_A = "DapAnA";
    private static final String DAP_AN_B = "DapAnB";
    private static final String DAP_AN_C = "DapAnC";
    private static final String DAP_AN_D = "DapAnD";
    private static final String TRA_LOI = "TraLoi";

    private static final String CREATE_TABLE = " CREATE TABLE " + TABLE + " ( " + ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + CAU_HOI + " varchar(255), " +  DAP_AN_A + " varchar(255), " + DAP_AN_B + " varchar(255), " + DAP_AN_C + " varchar(255), " + DAP_AN_D + " varchar(255), " + TRA_LOI + " varchar(255));";
    private static final String DROP_TABLE = " DROP TABLE IF EXISTS " + TABLE;

    DanhSachCauHoi(Context c){
        super(c,DB,null,DB_VERSION);
        this.context = c;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int a, int b){
        sqLiteDatabase.execSQL(DROP_TABLE);
        onCreate(sqLiteDatabase);
    }

    void danhSachCauHoi(){
        ArrayList<CauHoi> arrayList = new ArrayList<>();

        arrayList.add(new CauHoi("Anh?","1","2","3","4","3"));
        arrayList.add(new CauHoi("Unh?","1","2","3","4","4"));
        arrayList.add(new CauHoi("Onh?","1","2","3","4","2"));

        this.addDanhSachCauHoi(arrayList);
    }

    private void addDanhSachCauHoi(ArrayList<CauHoi> danhSachCauHoi){
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        try{
            ContentValues values = new ContentValues();
            for (CauHoi c : danhSachCauHoi){
                values.put(CAU_HOI, c.getCauHoi());
                values.put(DAP_AN_A, c.getDapAnA());
                values.put(DAP_AN_B, c.getDapAnB());
                values.put(DAP_AN_C, c.getDapAnC());
                values.put(DAP_AN_D, c.getDapAnD());
                values.put(TRA_LOI, c.getTraloi());
                db.insert(TABLE, null, values);
            }
            db.setTransactionSuccessful();
        }finally {
            db.endTransaction();
            db.close();
        }
    }

    List<CauHoi> getDanhSachCauHoi(){

        List<CauHoi> ch = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        String cot[] = {ID, CAU_HOI, DAP_AN_A, DAP_AN_B, DAP_AN_C, DAP_AN_D, TRA_LOI};
        Cursor cursor = db.query(TABLE, cot, null, null, null, null, null);

        while (cursor.moveToNext()){
            CauHoi c = new CauHoi();
            c.setId(cursor.getInt(0));
            c.setCauHoi(cursor.getString(1));
            c.setDaA(cursor.getString(2));
            c.setDaB(cursor.getString(3));
            c.setDaC(cursor.getString(4));
            c.setDaD(cursor.getString(5));
            c.setTraloi(cursor.getString(6));
            ch.add(c);
        }

        db.setTransactionSuccessful();
        db.endTransaction();
        cursor.close();
        db.close();
        return ch;
    }
}
