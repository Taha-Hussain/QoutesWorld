package com.ticktech.qoutesworld.QuoteWorld;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.ticktech.qoutesworld.Adapter.QuotesAdapter;
import com.ticktech.qoutesworld.DataSource.QuotesDataSource;
import com.ticktech.qoutesworld.Model.Quotes;
import com.ticktech.qoutesworld.R;

import java.util.ArrayList;

public class AllQuoteListActivity extends AppCompatActivity {

    QuotesDataSource quoteDatasource;
    QuotesAdapter quotesAdapter;
    ListView listViewQuotes;
    ArrayList<Quotes> array_list;
    Context context;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote_list);
        context = this;
        new asyncTask_httpGet().execute();
        intent = getIntent();

    }

    public class asyncTask_httpGet extends AsyncTask<Void,Void,Void>{

        ProgressDialog dialog = new ProgressDialog(AllQuoteListActivity.this);
        @Override
        protected void onPreExecute() {
            dialog.setTitle("Please wait...");
            dialog.setMessage("Let The Fun Begin! ");
            dialog.show();
            array_list = new ArrayList<>();
            quoteDatasource = new QuotesDataSource(context);
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
//            "http://friendsfashion.net/android/Quotes-World/Custom/Json/QuotesJson.php?category=";
            String Category_Name = intent.getStringExtra("Category_Name");
            String url = Constants.rootUrl+"view_quotes_json/"+Category_Name+"/0";
            array_list = quoteDatasource.getList(url,Category_Name);
            return null;
             }

        @Override
        protected void onPostExecute(Void s) {

            listViewQuotes = (ListView) findViewById(R.id.quoteList_ListView);
            quotesAdapter = new QuotesAdapter(context,R.layout.row_quote_list, array_list);
            listViewQuotes.setAdapter(quotesAdapter);
            super.onPostExecute(s);
            dialog.dismiss();
        }
    }
}
