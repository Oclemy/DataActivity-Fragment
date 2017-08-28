package com.tutorials.hp.dataactivity_fragment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
/*
- Our MainActivity class.
- Derives from AppCompatActivity which resides in the support library.
- Methods: onCreate(),sendData(),fillData().
- Inflated From content_main.xml using the setContentView() method.
- The views we use are EditText and Spinner.
- Reference EditText and Spinner from our layout specification using findViewById().
- We instantiate a Bundle object and put an int and string inside it.
- Bundle is a class that extends BaseBundle and implements both Cloneable and Parcelable
- It maps String values to various Parcelable types.
 */
public class MainActivity extends AppCompatActivity {
    private EditText nameTxt;
    private Spinner launchYearSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //INITIALIZE VIEWS
        nameTxt = (EditText) findViewById(R.id.nameEditTxt);
        launchYearSpinner = (Spinner) findViewById(R.id.sp);

        fillYears();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendData();
            }
        });
    }
    /*
    SEND DATA TO FRAGMENT
     */
    private void sendData() {
        //PACK DATA IN A BUNDLE
        Bundle bundle = new Bundle();
        bundle.putString("NAME_KEY", nameTxt.getText().toString());
        bundle.putInt("YEAR_KEY", Integer.valueOf(launchYearSpinner.getSelectedItem().toString()));

        //PASS OVER THE BUNDLE TO OUR FRAGMENT
        MyFragment myFragment = new MyFragment();
        myFragment.setArguments(bundle);

        nameTxt.setText("");
        launchYearSpinner.setSelection(0);

        //THEN NOW SHOW OUR FRAGMENT
        getSupportFragmentManager().beginTransaction().replace(R.id.container,myFragment).commit();
    }
    /*
    FILL YEARS IN OUR SPINNER
     */
    private void fillYears() {
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1);
        adapter.add("2017");
        adapter.add("2018");
        adapter.add("2019");
        adapter.add("2020");
        adapter.add("2021");
        adapter.add("2022");

        //SET ADAPTER INSTANCE TO OUR SPINNER
        launchYearSpinner.setAdapter(adapter);
    }
}
