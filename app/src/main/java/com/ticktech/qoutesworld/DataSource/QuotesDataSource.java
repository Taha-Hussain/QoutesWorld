package com.ticktech.qoutesworld.DataSource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.ticktech.qoutesworld.Contract.AuthorsContract;
import com.ticktech.qoutesworld.Contract.QuotesContract;
import com.ticktech.qoutesworld.JsonParser.quotesJsonParser;
import com.ticktech.qoutesworld.Model.Authors;
import com.ticktech.qoutesworld.Model.Quotes;
import com.ticktech.qoutesworld.QuoteWorld.Constants;

import java.util.ArrayList;

/**
 * Created by Taha on 08/06/2016.
 */
public class QuotesDataSource {

    QuotesWorldDbHelper quotesWorldDbHelper;
    SQLiteDatabase sqLiteDatabase;


    public QuotesDataSource(Context context) {
        quotesWorldDbHelper = new QuotesWorldDbHelper(context);
        sqLiteDatabase = quotesWorldDbHelper.getWritableDatabase();
    }

    public ArrayList<Quotes> getList(String url,String category) {
        quotesJsonParser quotesParser = new quotesJsonParser();
        ArrayList<Quotes> arrayListLiveData;


        try {

//            ArrayList<Quotes> arrayListSqlite = getListFromSQLite(category);
//            if (arrayListSqlite != null && arrayListSqlite.size() > 0)
//            {
//                return getListFromSQLite(category);
//            }
//            else
//            {
                arrayListLiveData = quotesParser.getParsedQuotes(url);
                deleteAll();
                bulkInsert(arrayListLiveData);
//            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return getListFromSQLite(category);

//        quotesJsonParser quotesParser = new quotesJsonParser();
//        return quotesParser.getParsedQuotes(url);
    }

    public ArrayList<Quotes> getListFromSQLite(String category) {
        ArrayList<Quotes> arrayList = new ArrayList<>();
        try {
            String query = QuotesContract.SQL_SELECT_ALL_QUOTES + "'"+category+"'";
            Cursor mcursor = sqLiteDatabase.rawQuery(query, null);
            while (mcursor.moveToNext()) {
                Quotes quotes = new Quotes();
                quotes.setQuote_id(mcursor.getString(mcursor.getColumnIndex(QuotesContract.QuotesEntry.COLUMN_NAME_QUOTE_ID)));
                quotes.setQuote_text(mcursor.getString(mcursor.getColumnIndex(QuotesContract.QuotesEntry.COLUMN_NAME_QUOTE_TEXT)));
                quotes.setQuote_author(mcursor.getString(mcursor.getColumnIndex(QuotesContract.QuotesEntry.COLUMN_NAME_QUOTE_AUTHOR)));
                quotes.setQuote_category(mcursor.getString(mcursor.getColumnIndex(QuotesContract.QuotesEntry.COLUMN_NAME_QUOTE_CATEGORY)));
//                quotes.setQuote_updatedDateTime(mcursor.getString(mcursor.getColumnIndex(QuotesContract.QuotesEntry.COLUMN_NAME_QUOTE_UPDATEDATETIME)));
                arrayList.add(quotes);
            }
        } catch (Exception e) {
            Log.i("SQL", "getListFromSQLite: " + e);
//            e.printStackTrace();
        }
        return arrayList;
    }

    public void bulkInsert(ArrayList<Quotes> arrayList) {
        for (Quotes item : arrayList) {
            insert(item);
        }
    }

    public long insert(Quotes quotes) {
        long result = 0;
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(QuotesContract.QuotesEntry.COLUMN_NAME_QUOTE_ID, quotes.getQuote_id());
            contentValues.put(QuotesContract.QuotesEntry.COLUMN_NAME_QUOTE_TEXT, quotes.getQuote_text());
            contentValues.put(QuotesContract.QuotesEntry.COLUMN_NAME_QUOTE_AUTHOR, quotes.getQuote_author());
            contentValues.put(QuotesContract.QuotesEntry.COLUMN_NAME_QUOTE_CATEGORY, quotes.getQuote_category());
            contentValues.put(QuotesContract.QuotesEntry.COLUMN_NAME_QUOTE_UPDATEDATETIME, quotes.getQuote_updatedDateTime());
            result = sqLiteDatabase.insert(QuotesContract.QuotesEntry.TABLE_NAME, null, contentValues);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }

    public long deleteAll() {
        try {
            sqLiteDatabase.execSQL(QuotesContract.SQL_DELETE_ALL);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;

    }


}
