package com.example.thu2.assignment1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;


public class StatMode extends Activity {

    private static final String FILENAME = "file.sav";

    private TextView Message;
    private ArrayList Buzzers;
    private ArrayList Times;
    private ArrayList lastTenNum;
    private ArrayList LastHund;
    BuzzerList Buzzer = new BuzzerList(this);
    TimeList TimeData = new TimeList(this);


    /*public void startStat(){
        //TimeList.loadFromFile();
        Buzzer.loadFromFile();
        //fillUpLatency();
        //buzzerdata=BuzzerList.getBuzzers();
       // bodyText= (TextView) findViewById(R.id.screen_text);*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stat_mode_activity);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_stat_mode, menu);
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
