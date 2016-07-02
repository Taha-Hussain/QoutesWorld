package com.ticktech.qoutesworld.DataSource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ticktech.qoutesworld.Contract.AuthorsContract;
import com.ticktech.qoutesworld.JsonParser.authorsJsonParser;
import com.ticktech.qoutesworld.Model.Authors;
import com.ticktech.qoutesworld.QuoteWorld.Constants;

import android.database.SQLException;
import java.util.ArrayList;

/**
 * Created by Taha on 06/06/2016.
 */
public class AuthorsDataSource {


//    public QuotesWorldDbHelper quotesWorldDbHelper;
    SQLiteDatabase sqLiteDatabase;
    QuotesWorldDbHelper quotesWorldDbHelper;


    public AuthorsDataSource(Context context) {
        quotesWorldDbHelper = new QuotesWorldDbHelper(context);
        sqLiteDatabase = quotesWorldDbHelper.getWritableDatabase();
    }

    public ArrayList<Authors> getList() {
//        authorsJsonParser authorsJsonParser = new authorsJsonParser();
//        ArrayList<Authors> arrayListLiveData;
//
//        try {
//
//            ArrayList<Authors> arrayListSqlite = getListFromSQLite();
//            if (arrayListSqlite != null && arrayListSqlite.size() > 0) {
//                return getListFromSQLite();
//
//            } else {
//                arrayListLiveData = authorsJsonParser.getParsedAuthors(Constants.AuthorsJsonUrl);
//                deleteAll();
//                bulkInsert(arrayListLiveData);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }

        return getListFromSQLite();
    }

    public ArrayList<Authors> getListFromSQLite() {
        ArrayList<Authors> arrayList = new ArrayList<>();
        try {
            Cursor mcursor = sqLiteDatabase.rawQuery(AuthorsContract.SQL_SELECT_ALL_AUTHORS, null);
            while (mcursor.moveToNext()) {
                Authors authors = new Authors();
                authors.setAuthor_quotesCount(mcursor.getString(mcursor.getColumnIndex(AuthorsContract.AuthorEntry.COLUMN_NAME_AUTHOR_QUOTES_COUNT)));
                authors.setAuthor_name(mcursor.getString(mcursor.getColumnIndex(AuthorsContract.AuthorEntry.COLUMN_NAME_AUTHOR_NAME)));
                arrayList.add(authors);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

//    public void bulkInsert(ArrayList<Authors> arrayList) {
//        for (Authors item : arrayList) {
//            insert(item);
//        }
//    }

//    public long insert(Authors author) {
//        long result = 0;
//        try {
//            ContentValues contentValues = new ContentValues();
//            contentValues.put(AuthorsContract.AuthorEntry.COLUMN_NAME_AUTHOR_NAME, author.getAuthor_name());
//            contentValues.put(AuthorsContract.AuthorEntry.COLUMN_NAME_AUTHOR_QUOTES_COUNT, author.getAuthor_quotesCount());
//            result = sqLiteDatabase.insert(AuthorsContract.AuthorEntry.TABLE_NAME, null, contentValues);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//
//    }

//    public long deleteAll() {
//        try {
//            sqLiteDatabase.execSQL(AuthorsContract.SQL_DELETE_ALL);
//            }
//        catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return 0;

//    }

}
