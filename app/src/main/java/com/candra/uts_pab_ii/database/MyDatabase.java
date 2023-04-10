package com.candra.uts_pab_ii.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDatabase extends SQLiteOpenHelper
{
    private Context context;
    private static final String DB_NAME = "db_bandara_0012";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "tbl_bandra_0012";
    private static final String FIELD_ID = "id";
    private static final String FIELD_NAMA = "nama";
    private static final String FIELD_KOTA = "kota";
    private static final String FIELD_ALAMAT = "alamat";

    public MyDatabase(@Nullable Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" + FIELD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + FIELD_NAMA + " VARCHAR(150), " + FIELD_KOTA + " VARCHAR(150), " + FIELD_ALAMAT + " TEXT);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        onCreate(db);
    }

    // Retrieve Data
    public Cursor bacaData()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME + " ;";
        Cursor c = null;

        if(db != null)
        {
            c = db.rawQuery(query, null);
        }

        return c;
    }

    // Tambah Data
    public long tambahData(String nama, String kota, String alamat)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(FIELD_NAMA, nama);
        cv.put(FIELD_KOTA, kota);
        cv.put(FIELD_ALAMAT, alamat);

        long execute = db.insert(TABLE_NAME, null, cv);

        return execute;
    }

}
