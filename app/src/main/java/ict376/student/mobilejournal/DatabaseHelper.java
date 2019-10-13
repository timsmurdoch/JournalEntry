package ict376.student.mobilejournal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "journal.db";
    public static final String TABLE_NAME = "entry_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "AUTHOR";
    public static final String COL_3 = "ENTRY";
    public static final String COL_4 = "TIMESTAMP";
    public static final String COL_5 = "IMAGE";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, AUTHOR TEXT, ENTRY TEXT, TIMESTAMP DATE, IMAGE TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String Author, String Entry, String timeStamp, String Image)    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, Author);
        contentValues.put(COL_3, Entry);
        contentValues.put(COL_4, timeStamp);
        contentValues.put(COL_5, Image);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData()  {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return res;
    }
}
