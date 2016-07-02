package com.ticktech.qoutesworld.QuoteWorld;

import android.app.ProgressDialog;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TabHost;

import com.ticktech.qoutesworld.Adapter.AuthorsAdapter;
import com.ticktech.qoutesworld.DataSource.AuthorsDataSource;
import com.ticktech.qoutesworld.DataSource.QuotesWorldDbHelper;
import com.ticktech.qoutesworld.Model.Authors;
import com.ticktech.qoutesworld.R;

import java.util.ArrayList;

public class MainActivity extends TabActivity {

    AuthorsDataSource authorsDataSource;
    AuthorsAdapter authorsAdapter;
    ListView listViewAuthors;
    ArrayList<Authors> author_array_list;
    Context context;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        new asyncTask_httpGet().execute();
        intent = getIntent();

        TabHost host = (TabHost)findViewById(android.R.id.tabhost);
        TabHost.TabSpec spec = host.newTabSpec("all");
        spec.setContent(R.id.all);
        spec.setIndicator("All");
        host.addTab(spec);


        spec = host.newTabSpec("saidby");
        spec.setContent(R.id.saidby);
        spec.setIndicator("Said By");
        host.addTab(spec);

        spec = host.newTabSpec("favourites");
        spec.setContent(R.id.favourites);
        spec.setIndicator("Favourites");
        host.addTab(spec);

    }

    public void showAllQuoteList(View v)
    {
        Intent allQuoteListIntent = new Intent(this, AllQuoteListActivity.class);
        switch (v.getId()) {
            case (R.id.Love_button):

                allQuoteListIntent.putExtra("Category_Name", "love");
                startActivity(allQuoteListIntent);
                break;

            case (R.id.Motivation_button):

                allQuoteListIntent.putExtra("Category_Name", "motivational");
                startActivity(allQuoteListIntent);
                break;

            case (R.id.Education_button):

                allQuoteListIntent.putExtra("Category_Name", "educational");
                startActivity(allQuoteListIntent);
                break;

            case (R.id.Funny_button):

                allQuoteListIntent.putExtra("Category_Name", "funny");
                startActivity(allQuoteListIntent);
                break;

            case (R.id.Success_button):

                allQuoteListIntent.putExtra("Category_Name", "success");
                startActivity(allQuoteListIntent);
                break;

            case (R.id.Life_button):

                allQuoteListIntent.putExtra("Category_Name", "life");
                startActivity(allQuoteListIntent);
                break;

            case (R.id.Friendship_button):

                allQuoteListIntent.putExtra("Category_Name", "friendship");
                startActivity(allQuoteListIntent);
                break;

            case (R.id.Work_button):

                allQuoteListIntent.putExtra("Category_Name", "work");
                startActivity(allQuoteListIntent);
                break;

        }
    }

    public class asyncTask_httpGet extends AsyncTask<Void,Void,Void> {


        ProgressDialog dialog = new ProgressDialog(MainActivity.this);
        @Override
        protected void onPreExecute() {
            dialog.setTitle("Please wait...");
            dialog.setMessage("Let The Fun Begin! ");
            dialog.show();
            author_array_list = new ArrayList<>();
            authorsDataSource = new AuthorsDataSource(context);


            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params)
        {
            author_array_list = authorsDataSource.getList();
            return null;
        }

        @Override
        protected void onPostExecute(Void s) {

            listViewAuthors = (ListView) findViewById(R.id.main_author_listview);
            authorsAdapter = new AuthorsAdapter(context,R.layout.row_author_listview, author_array_list);
            listViewAuthors.setAdapter(authorsAdapter);
            super.onPostExecute(s);
            dialog.dismiss();


        }
    }
}
