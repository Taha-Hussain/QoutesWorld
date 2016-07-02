package com.ticktech.qoutesworld.JsonParser;


import com.ticktech.qoutesworld.HttpService.HttpServiceClass;
import com.ticktech.qoutesworld.Model.Quotes;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Taha on 01/04/2016.
 */
public class quotesJsonParser {

    public ArrayList<Quotes> getParsedQuotes(String url) {
        HttpServiceClass MyHttpService = new HttpServiceClass();
        ArrayList<Quotes> MyArraylist = new ArrayList<>();

        String JsonQuotes = MyHttpService.httpGet(url);
        try {
            JSONArray quotesJsonArray = new JSONArray(JsonQuotes);

            for (int i = 0; i < quotesJsonArray.length(); i++) {
                Quotes quotes = new Quotes();
                JSONObject MyJsonObject = quotesJsonArray.getJSONObject(i);

                quotes.setQuote_id(MyJsonObject.getString("Id"));
                quotes.setQuote_text(MyJsonObject.getString("Quote"));
                quotes.setQuote_author(MyJsonObject.getString("Author"));
                quotes.setQuote_category(MyJsonObject.getString("Category"));
                quotes.setQuote_updatedDateTime(MyJsonObject.getString("UpdatedDateTime"));
                MyArraylist.add(quotes);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return MyArraylist;
    }
}
