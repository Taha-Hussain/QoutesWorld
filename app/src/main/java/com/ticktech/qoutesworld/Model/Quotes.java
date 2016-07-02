package com.ticktech.qoutesworld.Model;

import android.widget.ImageButton;

/**
 * Created by Taha on 08/06/2016.
 */
public class Quotes {

    private String quote_id;
    private String quote_text;
    private String quote_author;
    private String quote_category;
    private String quote_Image;
    private String quote_updatedDateTime;

    public String getQuote_updatedDateTime() {
        return quote_updatedDateTime;
    }

    public void setQuote_updatedDateTime(String quote_updatedDateTime) {
        this.quote_updatedDateTime = quote_updatedDateTime;
    }

//    public ImageButton quote_share_button;




    public String getQuote_id() {
        return quote_id;
    }

    public void setQuote_id(String quote_id) {
        this.quote_id = quote_id;
    }

    public String getQuote_text() {
        return quote_text;
    }

    public void setQuote_text(String quote_text) {
        this.quote_text = quote_text;
    }

    public String getQuote_author() {
        return quote_author;
    }

    public void setQuote_author(String quote_author) {
        this.quote_author = quote_author;
    }

    public String getQuote_category() {
        return quote_category;
    }

    public void setQuote_category(String quote_category) {
        this.quote_category = quote_category;
    }

    public String getQuote_Image() {
        return quote_Image;
    }

    public void setQuote_Image(String quote_Image) {
        this.quote_Image = quote_Image;
    }
}
