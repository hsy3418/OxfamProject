package com.heaven.navdrawer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
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
public class Home extends Fragment {

    private CharSequence mTitle;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        View rootView = inflater.inflate(R.layout.homepage,container,false);

        String[] array = {"Insurance","Loan","Schemes","Address","Settings"};
        int [] images = {R.drawable.insurance_img,R.drawable.loan_img,R.drawable.schemes_img,R.drawable.address_img,
        R.drawable.settings_img};
        ListView listView = (ListView)rootView.findViewById(R.id.listHome);

        //ListAdapter listAdapter = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_list_item_1,array);

        ListAdapter listAdapter = new CustomAdapter(getActivity(),array,images);
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                        Fragment fragment = null;
                        switch (position){
                            case 0 :
                                fragment = new Insurance();
                                getActionBar().setTitle(getString(R.string.title_section2));
                                break;
                            case 1 :
                                fragment = new Loan();
                                getActionBar().setTitle(getString(R.string.title_section3));
                                break;
                            case 2 :
                                fragment = new Schemes();
                                getActionBar().setTitle(getString(R.string.title_section4));
                                break;
                            case 3 :
                                fragment = new Address();
                                getActionBar().setTitle(getString(R.string.title_section5));
                                break;
                            case 4:
                                fragment = new Settings();
                                getActionBar().setTitle(getString(R.string.title_section6));
                                break;

                        }
                        fragmentManager.beginTransaction()
                                .replace(R.id.container, fragment)
                                .commit();

                    }
                }

        );

        return rootView;
    }

    private ActionBar getActionBar() {
        return ((ActionBarActivity) getActivity()).getSupportActionBar();
    }


}
