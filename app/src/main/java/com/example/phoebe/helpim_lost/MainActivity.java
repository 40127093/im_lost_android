package com.example.phoebe.helpim_lost;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class MainActivity extends ActionBarActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //To send an sms to the default number with the click of the help imagebutton
            ImageButton help = (ImageButton) findViewById(R.id.help);
            help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse( "sms:" + "07583227002" ) );
                intent.putExtra("sms_body", "I need help, please call me back!");
                startActivity(intent);
            }

        });

        //To make a call with the click of the phonebutton imagebutton

        ImageButton phonebutton = (ImageButton) findViewById(R.id.phone);
        phonebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:999"));
                startActivity(intent);
            }
        });

        //The MapsActivity activity is called with the click of the map imagebutton
        ImageButton map = (ImageButton) findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(MainActivity.this, MapsActivity.class);
                MainActivity.this.startActivity(myintent);
            }

        });

        //The Personal_Information activity is called with the click of the info imagebutton
        ImageButton info = (ImageButton) findViewById(R.id.questionmark);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mythirdintent = new Intent(MainActivity.this, Personal_Information.class);
                MainActivity.this.startActivity(mythirdintent);
            }
        });


        //The method called by the button b exits all activities
        Button b = (Button) findViewById(R.id.exit);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j=new Intent(Intent.ACTION_MAIN);
                j.addCategory(Intent.CATEGORY_HOME);
                j.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(j);
                finish();
                System.exit(0);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
