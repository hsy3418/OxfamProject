package com.heaven.navdrawer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Heaven on 13/1/16.
 */
public class DrawerCustomAdapter extends ArrayAdapter<String>{
    Context context;
    String[] items;


    public DrawerCustomAdapter(Context context, String[] items) {
        super(context,R.layout.custom_list,items);
        this.context = context;
        this.items = items;


    }

    @Override
    public View getView(int position,View convertView,ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.custom_drawer_list,parent,false);

        String item = getItem(position);
        TextView itemText = (TextView)customView.findViewById(R.id.custom_listview_text);
        //ImageView imageView = (ImageView)customView.findViewById(R.id.custom_list_Image);

        itemText.setText(items[position]);

        return customView;


    }
}


