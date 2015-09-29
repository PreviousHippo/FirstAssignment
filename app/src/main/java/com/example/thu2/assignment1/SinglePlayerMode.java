package com.example.thu2.assignment1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;

public class SinglePlayerMode extends Activity {

    Button SinglePlayerButton;
    String Message;
    TextView SinglePlayerMessage;
    Random rand;
    int maxNum = 2000;
    int minNum = 10;
    int randomNum;
   //Timer timer;
    //double timerNum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_player_mode_activity);
        SinglePlayerMessage = (TextView) findViewById(R.id.SinglePlayerModeText);
        rand = new Random();
        randomNum = rand.nextInt((maxNum - minNum) +1) + minNum;
        AlertDialog.Builder builder1 = new AlertDialog.Builder(SinglePlayerMode.this);
        builder1.setMessage("are you ready?");
        builder1.setCancelable(true);
        builder1.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int readyId) {
                //start timer 1 for random the time to start the game
                //when u press the button in SinglePlayerMode, the timer2 start, then
                //count the time in timer2

                dialog.cancel();
            }
        });
        builder1.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int readyId) {
                dialog.cancel();
            }
        });
        AlertDialog alert11 = builder1.create();
        alert11.show();

        SinglePlayerButton = (Button) findViewById(R.id.SinglePressButton);
        //SinglePlayerMessage = (TextView) findViewById(R.id.SinglePlayerModeText);
        //rand = new Random();
        //randomNum = rand.nextInt((maxNum - minNum) +1) + minNum;
        //Message = Integer.toString(randomNum);
        SinglePlayerButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //timer = new Timer();
                //timerNum = timer
                //if {
                 //   timer1 < randomNum
                //}

                //SinglePlayerMessage.setText(Message);


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
