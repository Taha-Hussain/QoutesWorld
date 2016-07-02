package com.ticktech.qoutesworld.Contract;

import android.provider.BaseColumns;

/**
 * Created by Taha on 18/06/2016.
 */
public class QuotesContract {

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";

    private QuotesContract() {

    }

    public static abstract class QuotesEntry implements BaseColumns {
        public static final String TABLE_NAME = "quotations";
        public static final String COLUMN_NAME_QUOTE_ID = "Id";
        public static final String COLUMN_NAME_QUOTE_TEXT = "Quote";
        public static final String COLUMN_NAME_QUOTE_AUTHOR = "Author";
        public static final String COLUMN_NAME_QUOTE_CATEGORY = "Category";
        public static final String COLUMN_NAME_QUOTE_FAVOURITE = "Favourite";
        public static final String COLUMN_NAME_QUOTE_UPDATEDATETIME = "UpdatedDateTime";
    }

    public static final String SQL_CREATE_QUOTES_TABLE =
            "CREATE TABLE " + QuotesEntry.TABLE_NAME + " (" +
                                       QuotesEntry._ID
            + " INTEGER PRIMARY KEY,"+ QuotesEntry.COLUMN_NAME_QUOTE_ID
            + TEXT_TYPE + COMMA_SEP + QuotesEntry.COLUMN_NAME_QUOTE_TEXT
            + TEXT_TYPE + COMMA_SEP + QuotesEntry.COLUMN_NAME_QUOTE_AUTHOR
            + TEXT_TYPE + COMMA_SEP + QuotesEntry.COLUMN_NAME_QUOTE_CATEGORY
            + TEXT_TYPE + COMMA_SEP + QuotesEntry.COLUMN_NAME_QUOTE_FAVOURITE
            + TEXT_TYPE + COMMA_SEP + QuotesEntry.COLUMN_NAME_QUOTE_UPDATEDATETIME
            + TEXT_TYPE  + " )";


    public static final String SQL_DROP = "DROP TABLE IF EXISTS " + QuotesEntry.TABLE_NAME;
    public static final String SQL_SELECT_ALL_QUOTES = "SELECT * FROM " + QuotesEntry.TABLE_NAME +" where Category = ";

//    public static final String SQL_SELECT_FAVOURITE = "SELECT * FROM " + QuotesEntry.TABLE_NAME;
    public static final String SQL_DELETE_ALL = "DELETE FROM " + QuotesEntry.TABLE_NAME;
}
