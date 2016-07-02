package com.ticktech.qoutesworld.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ticktech.qoutesworld.Model.Authors;
import com.ticktech.qoutesworld.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Taha on 06/06/2016.
 */
public class AuthorsAdapter extends ArrayAdapter<Authors> {
    Context context;
    public AuthorsAdapter(Context context, int resource, ArrayList<Authors> objects) {
        super(context, resource, objects);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Authors authors = getItem(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row_author_listview,parent,false);

        TextView AuthorQuotesCount = (TextView) rowView.findViewById(R.id.row_AuthorQuotesCount_TextView);
        TextView AuthorName = (TextView) rowView.findViewById(R.id.row_AuthorName_TextView);
        AuthorQuotesCount.setText(authors.getAuthor_quotesCount());
        AuthorName.setText(authors.getAuthor_name());
        return rowView;
    }
}
