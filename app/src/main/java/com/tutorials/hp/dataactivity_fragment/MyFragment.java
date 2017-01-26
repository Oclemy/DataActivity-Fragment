package com.tutorials.hp.dataactivity_fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends Fragment {

    private TextView nameFragTxt,yearFragTxt;


    public MyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView=inflater.inflate(R.layout.fragment_my, container, false);

        nameFragTxt= (TextView) rootView.findViewById(R.id.nameTxt);
        yearFragTxt= (TextView) rootView.findViewById(R.id.yearTxt);

        //UNPACK OUR DATA FROM OUR BUNDLE
        String name=this.getArguments().getString("NAME_KEY").toString();
        int year=this.getArguments().getInt("YEAR_KEY");

       nameFragTxt.setText("NAME : "+name);
       yearFragTxt.setText("YEAR : "+String.valueOf(year));


        return rootView;
    }

}
