package com.example.thu2.assignment1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
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
    int randomNum;
    Timer timer;
    long startTime;
    long TimeDiff;
    Double latency;
    TimeList myTimeList = new TimeList(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_player_mode_activity);
        SinglePlayerMessage = (TextView) findViewById(R.id.SinglePlayerModeText);
        rand = new Random();
        randomNum = rand.nextInt(maxNum - minNum+1)+ minNum;
        timer = new Timer();
        startTime = System.currentTimeMillis();
        myTimeList = new TimeList(this);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        TimeDiff = System.currentTimeMillis() - startTime;
                        if (TimeDiff >= randomNum){
                            SinglePlayerMessage.setText("click");
                        }
                    }
                });
            }
        },0,100);
        final Button SinglePlayerButton = (Button) findViewById(R.id.SinglePressButton);
        SinglePlayerButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                TimeDiff = System.currentTimeMillis() - startTime;
                timer.cancel();
                if(TimeDiff < randomNum){
                    SinglePlayerMessage.setText("early");
                    Button SinglePlayerButton = (Button) findViewById(R.id.SinglePressButton);
                    SinglePlayerButton.setText("start");
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(SinglePlayerMode.this);
                    builder1.setMessage("Don't click too fast");
                    builder1.setCancelable(true);
                    builder1.setPositiveButton("restart", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int readyId) {
                            Intent intent = getIntent();
                            finish();
                            startActivity(intent);
                            dialog.cancel();
                        }
                    });
                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                }else {
                    latency = TimeDiff - (double) randomNum;
                    latency = latency /1000.0;
                    myTimeList.setTime(latency);
                    myTimeList.saveInFile();
                    SinglePlayerMessage.setText("Your latency is " + Double.toString(latency) + "s");
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(SinglePlayerMode.this);
                    builder1.setMessage("Do you want to play again?");
                    builder1.setCancelable(true);
                    builder1.setPositiveButton("restart", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int readyId) {
                            Intent intent = getIntent();
                            finish();
                            startActivity(intent);
                            dialog.cancel();
                        }
                    });
                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                }
            }
        });
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
