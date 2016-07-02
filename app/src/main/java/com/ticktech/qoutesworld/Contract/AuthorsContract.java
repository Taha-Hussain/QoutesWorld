package com.ticktech.qoutesworld.Contract;

import android.provider.BaseColumns;

/**
 * Created by Taha on 18/06/2016.
 */
public class AuthorsContract {

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";

    private AuthorsContract()
    {

    }

    public static abstract class AuthorEntry implements BaseColumns {
        public static final String TABLE_NAME = "quotations";
        public static final String COLUMN_NAME_AUTHOR_NAME = "Author";
        public static final String COLUMN_NAME_AUTHOR_QUOTES_COUNT = "QuotesCount";
    }

//    public static final String SQL_CREATE_AUTHORS_TABLE = "CREATE TABLE " + AuthorEntry.TABLE_NAME + " (" + AuthorEntry._ID
//            + TEXT_TYPE + COMMA_SEP + AuthorEntry.COLUMN_NAME_AUTHOR_NAME
//            + TEXT_TYPE + COMMA_SEP + AuthorEntry.COLUMN_NAME_AUTHOR_QUOTES_COUNT
//            + " )";


//    public static final String SQL_DROP = "DROP TABLE IF EXISTS " + AuthorEntry.TABLE_NAME;
//    public static final String SQL_SELECT = "SELECT * FROM " + AuthorEntry.TABLE_NAME;
    public static final String SQL_SELECT_ALL_AUTHORS ="SELECT count(id) as 'QuotesCount',Author FROM "+ AuthorEntry.TABLE_NAME+" group by Author";
//    public static final String SQL_DELETE_ALL = "DELETE FROM " + AuthorEntry.TABLE_NAME;
}
