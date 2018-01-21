package com.minnathon.stresskiller;

/**
 * Created by Binh on 1/20/2018.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

//import org.o7planning.sqlitetutorial.bean.Note;

import java.util.ArrayList;
import java.util.List;

public class QuoteDBHelper extends SQLiteOpenHelper{
    private static final String TAG = "SQLite";


    // Phiên bản
    private static final int DATABASE_VERSION = 1;


    // Tên cơ sở dữ liệu.
    private static final String DATABASE_NAME = "Quote_Manager";


    // Tên bảng: Note.
    private static final String TABLE = "Quote";
    private static final String COLUMN_ID ="Quote_ID";
    private static final String COLUMN_TYPE ="Quote_Type";
    private static final String COLUMN_LINK = "Quote_Link";

    public int index = 0;

    public QuoteDBHelper(Context context)  {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Tạo các bảng.
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG, "QuoteDBHelper.onCreate ... ");
        // Script tạo bảng.
        String script = "CREATE TABLE " + TABLE + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_TYPE + " TEXT,"
                + COLUMN_LINK + " TEXT" + ")";
        // Chạy lệnh tạo bảng.
        db.execSQL(script);

    }

    public void createDefaultDB()  {
        int count = this.getQuotesCount();
        if(count == 0 ) {
            this.addQuote(new Quote("friend","https://i.pinimg.com/564x/1e/2f/6a/1e2f6abcd30240f24b4cf5356b19b72e.jpg"));
            this.addQuote(new Quote("friend","https://i.pinimg.com/564x/45/65/8a/45658a9bce828b96f4887a3520bfbc2b.jpg"));
            this.addQuote(new Quote("friend","https://i.pinimg.com/564x/cb/67/68/cb67687c6a3515b9fbffc6a6b107bcc4.jpg"));

            this.addQuote(new Quote("family","https://i.pinimg.com/564x/af/f3/e3/aff3e35f2644672d29fe6406a4d88b8e.jpg"));
            this.addQuote(new Quote("family","https://i.pinimg.com/564x/d9/03/30/d90330fcdc219fdfd1a2dd6a760c9b76.jpg"));
            this.addQuote(new Quote("family","https://i.pinimg.com/564x/e5/63/a8/e563a8116c25a3eb4cf54b993bcd0eea.jpg"));

            this.addQuote(new Quote("work","https://i.pinimg.com/564x/9d/dc/43/9ddc437724143b9edf31799f035f9180.jpg"));
            this.addQuote(new Quote("work","https://i.pinimg.com/564x/27/74/ae/2774ae9f257e2f00f9e6d0e4af70c5dd.jpg"));
            this.addQuote(new Quote("work","https://i.pinimg.com/564x/e1/60/75/e1607536d7b86ef30acf6d74ef0e5be6.jpg"));

            this.addQuote(new Quote("love","https://i.pinimg.com/564x/fc/36/7e/fc367eb4cb30c5178f43a7cde7b05159.jpg"));
            this.addQuote(new Quote("love","https://i.pinimg.com/564x/00/43/02/004302b5b9d23490fb2ad81c1e9d4cab.jpg"));
            this.addQuote(new Quote("love","https://i.pinimg.com/564x/43/fc/e8/43fce89e8061279857c19a8f721417b4.jpg"));

            this.addQuote(new Quote("money","https://i.pinimg.com/564x/64/f2/f4/64f2f45de39be72a0462b34c76d1d81a.jpg"));
            this.addQuote(new Quote("money","https://i.pinimg.com/564x/5f/01/de/5f01de8329e6fa29872395eb967fa0f9.jpg"));
            this.addQuote(new Quote("money","https://i.pinimg.com/564x/5b/fe/fa/5bfefa84eb941eb3a3cc84d6068f3061.jpg"));

            this.addQuote(new Quote("other","https://i.pinimg.com/564x/0b/9b/e5/0b9be59962a871a676c68e12943362fc.jpg"));
            this.addQuote(new Quote("other","https://i.pinimg.com/564x/f2/50/d7/f250d71f51b525bb7e6562d5fa49ed31.jpg"));
            this.addQuote(new Quote("other","https://i.pinimg.com/236x/4e/44/17/4e4417febc89d8998f53d3878a51e638.jpg"));
        }
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.i(TAG, "QuoteDBHelper.onUpgrade ... ");

        // Hủy (drop) bảng cũ nếu nó đã tồn tại.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);

        // Và tạo lại.
        onCreate(db);
    }
    public void addQuote(Quote quote) {
        Log.i(TAG, "QuoteDBHelper.addQuote ... " + quote.getType());

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, index++);
        values.put(COLUMN_TYPE, quote.getType());
        values.put(COLUMN_LINK, quote.getLink());


        // Trèn một dòng dữ liệu vào bảng.
        db.insert(TABLE, null, values);

        // Đóng kết nối database.
        db.close();
    }

    public Quote getQuote(int id) {
        Log.i(TAG, "QuoteDBHelper.getNote ... " + id);

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE, new String[] { COLUMN_ID,
                        COLUMN_TYPE, COLUMN_LINK}, COLUMN_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Quote quote = new Quote(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));
        // return note
        return quote;
    }

    public ArrayList<Quote> getAllQuotes() {
        ArrayList<Quote> noteList = new ArrayList<Quote>();
        for(int i =0;i<this.getQuotesCount();i++)
            noteList.add(getQuote(i));
        return noteList;
    }

    public int getQuotesCount() {
        Log.i(TAG, "QuoteDBHelper.getQuoteCount ... " );

        String countQuery = "SELECT  * FROM " + TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();

        cursor.close();

        // return count
        return count;
    }
}
