package com.heaven.navdrawer;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by Heaven on 8/1/16.
 */
public class Settings extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        View rootView = inflater.inflate(R.layout.setting,container,false);
        String[] array = {"Language","About","Help&Feedback"};
        int [] images = {R.drawable.ic_language_black_24dp,R.drawable.loan_img,R.drawable.schemes_img};
        ListView listView = (ListView)rootView.findViewById(R.id.settings_listview);
        ListAdapter listAdapter = new CustomAdapter(getActivity(),array,images);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                        Fragment fragment = null;
                        Intent intent = null;
                        switch (position){
                            case 0 :
                                intent = new Intent(getActivity(),Language.class);
                                //getActionBar().setTitle(getString(R.string.title_section7));
                                break;
                            case 1 :
                                intent = new Intent(getActivity(),About.class);
                                //getActionBar().setTitle(getString(R.string.title_section8));
                                break;
                            case 2 :
                                intent = new Intent(getActivity(),Help.class);
                                //getActionBar().setTitle(getString(R.string.title_section9));
                                break;

                        }
//                        fragmentManager.beginTransaction()
//                                .replace(R.id.container, fragment)
//                                .commit();
                        startActivity(intent);

                    }
                }

        );






        return rootView;
    }

    private ActionBar getActionBar() {
        return ((ActionBarActivity) getActivity()).getSupportActionBar();
    }

}
