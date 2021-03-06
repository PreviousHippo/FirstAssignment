package com.example.thu2.assignment1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class SinglePlayerMode extends Activity {

    TextView SinglePlayerMessage;
    Random rand;
    int maxNum = 2000;
    int minNum = 10;
    Double randomNum;
    Timer timer;
    long startTime;
    long TimeDiff;
    Double latency;
    TimeRecord myTimeRecord;
    private Boolean ClickStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_player_mode_activity);
        myTimeRecord = new TimeRecord(this);
        SinglePlayerMessage = (TextView) findViewById(R.id.SinglePlayerModeText);
        ClickStart = Boolean.FALSE;
    }

    public void ClickSingleMode(View view){
        if(ClickStart == Boolean.FALSE){
            rand = new Random();
            randomNum = new Double(rand.nextInt(maxNum - minNum+1)+ minNum);
            timer = new Timer();
            startTime = System.currentTimeMillis();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            TimeDiff = System.currentTimeMillis() - startTime;
                            if (TimeDiff >= randomNum){
                                SinglePlayerMessage.setText("click");
                                ClickStart = Boolean.TRUE;
                            }
                        }
                    });
                }
            },0,100);
            }else{
            TimeDiff = System.currentTimeMillis() - startTime;
            timer.cancel();
            if(TimeDiff < randomNum){
                SinglePlayerMessage.setText("Too early");
                Button PressButton = (Button) findViewById(R.id.SinglePressButton);
                PressButton.setText("Start");
                ClickStart = Boolean.FALSE;
            }else {
                latency = TimeDiff - randomNum;
                latency = latency / 1000.0;
                myTimeRecord.setTime(latency);
                myTimeRecord.saveInFile();
                SinglePlayerMessage.setText("Your latency is " + Double.toString(latency) + "s");
                AlertDialog.Builder builder1 = new AlertDialog.Builder(SinglePlayerMode.this);
                builder1.setMessage("want to restart?");
                builder1.setCancelable(true);
                builder1.setPositiveButton("Start", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int readyId) {
                        dialog.cancel();
                    }
                });
                AlertDialog alert11 = builder1.create();
                alert11.show();
                Button PressButton = (Button) findViewById(R.id.SinglePressButton);
                PressButton.setText("Restart");
                ClickStart = Boolean.FALSE;
            }
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_single_player_mode, menu);
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
