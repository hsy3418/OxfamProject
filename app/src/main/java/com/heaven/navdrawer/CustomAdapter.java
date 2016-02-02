package com.heaven.navdrawer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Heaven on 12/1/16.
 */
public class CustomAdapter extends ArrayAdapter<String> {
    Context context;
    String[] items;
    int[] images;


    public CustomAdapter(Context context, String[] items, int[] images) {
        super(context,R.layout.custom_list,items);
        this.context = context;
        this.items = items;
        this.images = images;

    }

    @Override
    public View getView(int position,View convertView,ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.custom_list,parent,false);

        String item = getItem(position);
        TextView itemText = (TextView)customView.findViewById(R.id.listview_text);
        ImageView imageView = (ImageView)customView.findViewById(R.id.list_Image);

        itemText.setText(items[position]);
        imageView.setImageResource(images[position]);
        return customView;


    }
}
