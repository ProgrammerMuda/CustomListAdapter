package com.example.raga.belajarlist2;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by RAGA on 13/10/2017.
 */

public class CustomListAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] namapemain;
    private final String[] subtitlepemain;
    private final Integer[] gambarpemain;

    public CustomListAdapter(Activity context, String[] namapemain, String[] subtitlepemain, Integer[] gambarpemain) {
        super(context, R.layout.list_item, namapemain);
        this.context = context;
        this.namapemain = namapemain;
        this.subtitlepemain = subtitlepemain;
        this.gambarpemain = gambarpemain;

    }

    public View getView (int posisi , View view, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_item, null, true);
        TextView title = (TextView)rowView.findViewById(R.id.textview);
        TextView subtitle = (TextView)rowView.findViewById(R.id.textview2);
        ImageView picture = (ImageView)rowView.findViewById(R.id.imageview);

        title.setText(namapemain[posisi]);
        subtitle.setText(subtitlepemain[posisi]);
        picture.setImageResource(gambarpemain[posisi]);
        return rowView;

    }
}
