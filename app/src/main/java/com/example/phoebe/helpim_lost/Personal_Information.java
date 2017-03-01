package com.example.phoebe.helpim_lost;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;


public class Personal_Information extends ActionBarActivity {

    private EditText fullname_new;
    private EditText age_new;
    private EditText address_new;
    private EditText emergencycontact_new;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal__information);

        //get references to the editexts
        fullname_new = (EditText)findViewById(R.id.fullnametxt);
        age_new = (EditText)findViewById(R.id.agetxt);
        address_new = (EditText)findViewById(R.id.addresstxt);
        emergencycontact_new = (EditText)findViewById(R.id.emergencycontacttxt);

        //To capture user input and display it until he types something new
        SharedPreferences mydetails = getSharedPreferences("Mydets", 0);

        //Put in default value the first time
        fullname_new.setText(mydetails.getString("FullnameValue",""));
        age_new.setText(mydetails.getString("AgeValue",""));
        address_new.setText(mydetails.getString("AddressValue",""));
        emergencycontact_new.setText(mydetails.getString("EmergencyContactValue",""));




        //Go to the main activity with a button click
        Button c = (Button) findViewById(R.id.goback);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myfourthintent = new Intent(Personal_Information.this, MainActivity.class);
                Personal_Information.this.startActivity(myfourthintent);
            }
        });
    }

    @Override
    protected void onStop(){
        //method called when the app is about to exit or close unexpectedly
        super.onStop();
        SharedPreferences mydetails = getSharedPreferences("Mydets", 0);

        //this editor is used in order to make changes
        SharedPreferences.Editor editor = mydetails.edit();
        editor.putString("FullnameValue",fullname_new.getText().toString());
        editor.putString("AgeValue",age_new.getText().toString());
        editor.putString("AddressValue",address_new.getText().toString());
        editor.putString("EmergencyContactValue",emergencycontact_new.getText().toString());
        editor.commit();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_personal__information, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
