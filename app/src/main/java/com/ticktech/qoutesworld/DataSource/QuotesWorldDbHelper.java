package com.ticktech.qoutesworld.DataSource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.ticktech.qoutesworld.Contract.AuthorsContract;
import com.ticktech.qoutesworld.Contract.QuotesContract;
import com.ticktech.qoutesworld.Model.Authors;

import java.util.ArrayList;

/**
 * Created by Taha on 21/06/2016.
 */
public class QuotesWorldDbHelper extends SQLiteOpenHelper {


    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "qw.db";
    SQLiteDatabase sqLiteDatabase;


    public QuotesWorldDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        sqLiteDatabase = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(QuotesContract.SQL_CREATE_QUOTES_TABLE);
//        db.execSQL(AuthorsContract.SQL_CREATE_AUTHORS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(QuotesContract.SQL_DROP);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
