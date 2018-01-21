package com.minnathon.stresskiller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

//import org.o7planning.sqlitetutorial.bean.Note;

import java.util.ArrayList;
import java.util.List;


public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "SQLite";


    // Phiên bản
    private static final int DATABASE_VERSION = 1;


    // Tên cơ sở dữ liệu.
    private static final String DATABASE_NAME = "Film_Manager";


    // Tên bảng: Note.
    private static final String TABLE_FILM = "FILM";
    private static final String COLUMN_FILM_ID ="Film_ID";
    private static final String COLUMN_FILM_TITLE ="Film_Title";
    private static final String COLUMN_FILM_LINK = "Film_Link";

    public int index = 0;

    public MyDatabaseHelper(Context context)  {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Tạo các bảng.
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG, "MyDatabaseHelper.onCreate ... ");
        // Script tạo bảng.
        String script = "CREATE TABLE " + TABLE_FILM + "("
                + COLUMN_FILM_ID + " INTEGER PRIMARY KEY," + COLUMN_FILM_TITLE + " TEXT,"
                + COLUMN_FILM_LINK + " TEXT" + ")";
        // Chạy lệnh tạo bảng.
        db.execSQL(script);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.i(TAG, "MyDatabaseHelper.onUpgrade ... ");

        // Hủy (drop) bảng cũ nếu nó đã tồn tại.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FILM);

        // Và tạo lại.
        onCreate(db);
    }

    // Nếu trong bảng Note chưa có dữ liệu,
    // Chèn vào mặc định 2 bản ghi.
    public void createDefaultMusic()  {
        int count = this.getFilmsCount();
        if(count ==0 ) {
            Film film1 = new Film("Quick Relaxation",
                    "ZVHOKq91Uh4");
            Film film2 = new Film("Water Sounds",
                    "ja8pA2B0RR4");

            this.addFilm(film1);
            this.addFilm(film2);
            this.addFilm(new Film("“Stand By You” by Rachel Platten",
                    "bwB9EMpW8eY"));
            this.addFilm(new Film("“Girl on Fire” by Alicia Keys",
                    "J91ti_MpdHA"));
            this.addFilm(new Film("“Dream Big” by Ryan Shupe & The Rubberband",
                    "3KwEuNapzt0"));
            this.addFilm(new Film("“Lean On Me” by Bill Withers",
                    "KEXQkrllGbA"));
            this.addFilm(new Film("The Mowgli's - I'm Good",
                    "3tGMVuj41SI"));
            this.addFilm(new Film("“Keep Your Head Up” by Andy Grammer","3LMVJ2xd1g8"));
            this.addFilm(new Film("“Walk On” by U2","gwKEdFoUB0o"));
            this.addFilm(new Film("“Today Is Your Day” by Shania Twain","OMciyWyugKY"));
            this.addFilm(new Film("Quick Relaxation","ZVHOKq91Uh4"));
            this.addFilm(new Film("Water Sounds","ja8pA2B0RR4"));
            this.addFilm(new Film("Bird Calls","5IjfINBPpx0"));
            this.addFilm(new Film("Guided Morning Meditation","WYP_W49o1vQ"));
            this.addFilm(new Film("SPIDER-PUG - Doug The Pug","tOXszq1-rxs"));
            this.addFilm(new Film("on gioi cau day roi","HO3pl7Wtn-w"));
            this.addFilm(new Film("Cats are the kings of animal comedy - Funny cat compilation","9e2QJ-VTeKY"));
            this.addFilm(new Film("FUNNY CATS!","zcGOoDThC1E"));
        }
    }


    public void addFilm(Film film) {
        Log.i(TAG, "MyDatabaseHelper.addFilm ... " + film.getFilmTitle());

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_FILM_ID,index++);
        values.put(COLUMN_FILM_TITLE, film.getFilmTitle());
        values.put(COLUMN_FILM_LINK, film.getFilmLink());


        // Trèn một dòng dữ liệu vào bảng.
        db.insert(TABLE_FILM, null, values);

        // Đóng kết nối database.
        db.close();
    }

    public Film getFilm(int id) {
        Log.i(TAG, "MyDatabaseHelper.getNote ... " + id);

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_FILM, new String[] { COLUMN_FILM_ID,
                        COLUMN_FILM_TITLE, COLUMN_FILM_LINK}, COLUMN_FILM_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Film film = new Film(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));
        // return note
        return film;
    }

    public ArrayList<Film> getAllFilms() {
        ArrayList<Film> noteList = new ArrayList<Film>();
        for(int i =0;i<this.getFilmsCount();i++)
            noteList.add(getFilm(i));
        return noteList;
    }

    public int getFilmsCount() {
        Log.i(TAG, "MyDatabaseHelper.getNotesCount ... " );

        String countQuery = "SELECT  * FROM " + TABLE_FILM;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();

        cursor.close();

        // return count
        return count;
    }
//
//
//    public int updateNote(Note note) {
//        Log.i(TAG, "MyDatabaseHelper.updateNote ... "  + note.getNoteTitle());
//
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_NOTE_TITLE, note.getNoteTitle());
//        values.put(COLUMN_NOTE_CONTENT, note.getNoteContent());
//
//        // updating row
//        return db.update(TABLE_NOTE, values, COLUMN_NOTE_ID + " = ?",
//                new String[]{String.valueOf(note.getNoteId())});
//    }
//
//    public void deleteNote(Note note) {
//        Log.i(TAG, "MyDatabaseHelper.updateNote ... " + note.getNoteTitle() );
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(TABLE_NOTE, COLUMN_NOTE_ID + " = ?",
//                new String[] { String.valueOf(note.getNoteId()) });
//        db.close();
//    }
}