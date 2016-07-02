package com.ticktech.qoutesworld.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.support.annotation.ColorInt;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.ticktech.qoutesworld.Model.Quotes;
import com.ticktech.qoutesworld.R;

import java.text.ParsePosition;
import java.util.ArrayList;


/**
 * Created by Taha on 31/03/2016.
 */
public class QuotesAdapter extends ArrayAdapter<Quotes> {
    Context context;
    private int layout;

    public QuotesAdapter(Context context, int resource, ArrayList<Quotes> objects) {
        super(context, resource, objects);
        this.context = context;
        layout = resource;

    }

    public class ViewHolder
    {
        RelativeLayout background_color;
        TextView QuoteText;
        TextView QuoteAuthorText;
        TextView quote_Category_TextView;
        ImageButton quote_share_button;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final Quotes quotes = getItem(position);
        ViewHolder mainViewHolder = null;
//        if(convertView == null)
//        {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(layout,parent,false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.background_color = (RelativeLayout) convertView.findViewById(R.id.background_color);
            viewHolder.quote_share_button = (ImageButton)convertView.findViewById(R.id.quote_share_button);
            viewHolder.QuoteText = (TextView) convertView.findViewById(R.id.quote_TextView);
            viewHolder.QuoteAuthorText = (TextView) convertView.findViewById(R.id.quote_authorName_TextView);
            viewHolder.quote_Category_TextView = (TextView) convertView.findViewById(R.id.quote_Category_TextView);
            viewHolder.quote_share_button = (ImageButton) convertView.findViewById(R.id.quote_share_button);

            viewHolder.quote_share_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Toast.makeText(getContext(), quotes.getQuote_text() +"\n\n '"+ quotes.getQuote_author()+"'" , Toast.LENGTH_SHORT).show();

                    String ShareQuoteContent = String.format(quotes.getQuote_text() +"\n\n '"+ quotes.getQuote_author()+"'");

                    Intent mIntent = new Intent();
                    mIntent.setAction(Intent.ACTION_SEND);
                    mIntent.putExtra(Intent.EXTRA_TEXT, ShareQuoteContent);
                    mIntent.setType("text/plain");
                    //startActivity(mIntent);
                    context.startActivity(Intent.createChooser(mIntent,"Share Quote"));
                }
            });
            convertView.setTag(viewHolder);
//        }
//        else
//        {
            mainViewHolder = (ViewHolder) convertView.getTag();
            mainViewHolder.QuoteText.setText(quotes.getQuote_text());
            mainViewHolder.QuoteAuthorText.setText("'" + quotes.getQuote_author() + "'");
            mainViewHolder.quote_Category_TextView.setText(quotes.getQuote_category());
            String category = quotes.getQuote_category();

            int bgColor;
            switch (category) {
                case "Love":
                    bgColor = (int) context.getResources().getColor(R.color.colorRed);
                    mainViewHolder.background_color.setBackgroundColor(bgColor);
                    break;
                case "Motivational":
                    bgColor = (int) context.getResources().getColor(R.color.colorOrangeYellow);
                    mainViewHolder.background_color.setBackgroundColor(bgColor);
                    break;
                case "Educational":
                    bgColor = (int) context.getResources().getColor(R.color.colorGreen);
                    mainViewHolder.background_color.setBackgroundColor(bgColor);
                    break;
                case "Funny":
                    bgColor = (int) context.getResources().getColor(R.color.colorAccent);
                    mainViewHolder.background_color.setBackgroundColor(bgColor);
                    break;
                case "Success":
                    bgColor = (int) context.getResources().getColor(R.color.colorBlue);
                    mainViewHolder.background_color.setBackgroundColor(bgColor);
                    break;
                case "Life":
                    bgColor = (int) context.getResources().getColor(R.color.colorPurple);
                    mainViewHolder.background_color.setBackgroundColor(bgColor);
                    break;
                case "Friendship":
                    bgColor = (int) context.getResources().getColor(R.color.colorLightPurple);
                    mainViewHolder.background_color.setBackgroundColor(bgColor);
                    break;
                case "Work":
                    bgColor = (int) context.getResources().getColor(R.color.colorLightBlue);
                    mainViewHolder.background_color.setBackgroundColor(bgColor);
                    break;

            }
//        }

//        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View rowView = inflater.inflate(R.layout.row_quote_list, parent, false);


//        ImageButton quote_share_button = (ImageButton)rowView.findViewById(R.id.quote_share_button);

//        RelativeLayout background_color = (RelativeLayout) rowView.findViewById(R.id.background_color);

//        TextView QuoteText = (TextView) rowView.findViewById(R.id.quote_TextView);
//        QuoteText.setText(quotes.getQuote_text());


//        TextView QuoteAuthorText = (TextView) rowView.findViewById(R.id.quote_authorName_TextView);
//        QuoteAuthorText.setText("'" + quotes.getQuote_author() + "'");

//        TextView quote_Category_TextView = (TextView) rowView.findViewById(R.id.quote_Category_TextView);
//        String category = quotes.getQuote_category();
//        quote_Category_TextView.setText(category);


//        int bgColor;
//        switch (category) {
//            case "Love":
//                bgColor = (int) context.getResources().getColor(R.color.colorRed);
//                background_color.setBackgroundColor(bgColor);
//                break;
//            case "Motivational":
//                bgColor = (int) context.getResources().getColor(R.color.colorOrangeYellow);
//                background_color.setBackgroundColor(bgColor);
//                break;
//            case "Educational":
//                bgColor = (int) context.getResources().getColor(R.color.colorGreen);
//                background_color.setBackgroundColor(bgColor);
//                break;
//            case "Funny":
//                bgColor = (int) context.getResources().getColor(R.color.colorAccent);
//                background_color.setBackgroundColor(bgColor);
//                break;
//            case "Success":
//                bgColor = (int) context.getResources().getColor(R.color.colorBlue);
//                background_color.setBackgroundColor(bgColor);
//                break;
//            case "Life":
//                bgColor = (int) context.getResources().getColor(R.color.colorPurple);
//                background_color.setBackgroundColor(bgColor);
//                break;
//            case "Friendship":
//                bgColor = (int) context.getResources().getColor(R.color.colorLightPurple);
//                background_color.setBackgroundColor(bgColor);
//                break;
//            case "Work":
//                bgColor = (int) context.getResources().getColor(R.color.colorLightBlue);
//                background_color.setBackgroundColor(bgColor);
//                break;
//
//        }



        return convertView;
    }
}
