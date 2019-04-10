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
    private static final String DB = "DoVui1.db";

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

    //Tạo danh sách các câu hỏi
    void danhSachCauHoi(){
        ArrayList<CauHoi> arrayList = new ArrayList<>();

        arrayList.add(new CauHoi("Lịch nào dài nhất ?","Lịch sử","Lịch vạn niên","Sông Tô Lịch","Lý lịch","Lịch sử"));
        arrayList.add(new CauHoi("Con đường dài nhất là đường nào ?","Đường đến đích","Học đường","Đường đời","Đường tình yêu","Đường đời"));
        arrayList.add(new CauHoi("Con gì đập thì sống, không đập thì chết ?","Con mèo","Con chuột","Con người","Con tim","Con tim"));
        arrayList.add(new CauHoi("Quần rộng nhất là quần gì ?","Quần chúng","Quần đảo","Quần bò","Quần kaki","Quần đảo"));
        arrayList.add(new CauHoi("Xã đông nhất là xã nào ?","Xã hội","Làng xã","Xã xã","Không có","Xã hội"));
        arrayList.add(new CauHoi("Con gì đầu dê mình ốc ?","Con ốc","Con dốc","Con bò","Con đường","Con dốc"));
        arrayList.add(new CauHoi("Môn gì càng thắng càng thua ?","Môn đấu súng","Môn đấu kiếm","Môn bơi","Môn đua xe đạp","Môn đua xe đạp"));
        arrayList.add(new CauHoi("Cái gì mà đi thì nằm, đứng cũng nằm, nhưng nằm lại đứng ?","Bàn tay","Bàn chân","Cẳng tay","Đùi","Bàn chân"));
        arrayList.add(new CauHoi("Chuột nào đi bằng hai chân ?","Chuột Mickey","Chuột cống","Chuột đồng","Chuột trù","Chuột Mickey"));
        arrayList.add(new CauHoi("Vịt nào đi bằng hai chân ?","Vịt Donal","Vịt què","Vịt con","Tất cả con vịt","Tất cả con vịt"));
        arrayList.add(new CauHoi("Cái gì của chồng mà vợ thích cầm nhất ?","Cái đó","Tiền","Tay","Chân","Tiền"));
        arrayList.add(new CauHoi("Bạn làm việc gì đầu tiên mỗi buổi sáng ?","Đánh răng","Đi vs","Ăn sáng","Mở mắt","Mở mắt"));
        arrayList.add(new CauHoi("Từ gì mà 100% nguời dân Việt Nam đều phát âm sai ?","Từ đúng","Từ sai","Từ xoong","Từ boong","Từ sai"));
        arrayList.add(new CauHoi("Khi Beckham thực hiện quả đá phạt đền, anh ta sẽ sút vào đâu ?","Thủ môn","Lưới","Quả bóng","Sút ra ngoài","Quả bóng"));
        arrayList.add(new CauHoi("Con trai có gì quý nhất ?","Cái đó","Ngọc trai","Tính cách","Khỏe","Ngọc trai"));
        arrayList.add(new CauHoi("Sở thú bị cháy, con gì chạy ra đầu tiên ?","Con người","Con hổ","Con voi","Con chim","Con người"));
        arrayList.add(new CauHoi("Trong 1 cuộc thi chạy, nếu bạn vượt qua người thứ 2 bạn sẽ đứng thứ mấy ?","Thứ nhất","Thứ nhì","Thứ ba","Thứ tư","Thứ nhì"));
        arrayList.add(new CauHoi("Nắng ba năm ta chưa hề bỏ bạn. Là cái gì ?","Cái bóng","Gia đình","Bạn bè","Quần áo","Cái bóng"));
        arrayList.add(new CauHoi("Càng chơi càng ra nuớc ?","Chơi nhau","Chơi bóng","Chơi cờ","Chơi bài","Chơi cờ"));
        arrayList.add(new CauHoi("Cái gì Adam có 2 mà Eva chỉ có 1 ?","Mái tóc","Bàn tay","Cái đó","Chữ a","Chữ a"));
        arrayList.add(new CauHoi("Bệnh gì bác sĩ bó tay ?","Bệnh gãy tay","Bệnh gãy chân","Bệnh khó chữa","Bệnh chảy máu","Bệnh gãy tay"));

        this.addDanhSachCauHoi(arrayList);
    }

    //Thêm 1 câu hỏi vào trong csdl
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

    //Lấy danh sách các câu hỏi
    List<CauHoi> getDanhSachCauHoi(){

        List<CauHoi> ch = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        String cot[] = {ID, CAU_HOI, DAP_AN_A, DAP_AN_B, DAP_AN_C, DAP_AN_D, TRA_LOI};
        //Lấy ra danh sách câu hỏi trong bảng
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
