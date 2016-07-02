package com.ticktech.qoutesworld.JsonParser;

import com.ticktech.qoutesworld.Model.Authors;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.ticktech.qoutesworld.HttpService.HttpServiceClass;
import java.util.ArrayList;

/**
 * Created by Taha on 06/06/2016.
 */
public class authorsJsonParser {

    public ArrayList<Authors> getParsedAuthors(String url) {
        HttpServiceClass MyHttpService = new HttpServiceClass();
        ArrayList<Authors> AuthorsArraylist = new ArrayList<>();
        String JsonAuthors = MyHttpService.httpGet(url);
        try {

            JSONArray authorsJsonArray = new JSONArray(JsonAuthors);
            for (int i = 0; i < authorsJsonArray.length(); i++) {
                Authors authors = new Authors();
                JSONObject MyJsonObject = authorsJsonArray.getJSONObject(i);
                    authors.setAuthor_quotesCount(MyJsonObject.getString("QuotesCount"));
                    authors.setAuthor_name(MyJsonObject.getString("Author"));
                AuthorsArraylist.add(authors);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return AuthorsArraylist;
    }
}
