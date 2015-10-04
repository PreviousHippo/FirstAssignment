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

import java.util.ArrayList;

public class ThreePlayerMode extends Activity {
    Button FirstPlayerButton3;
    Button SecondPlayerButton3;
    Button ThirdPlayerButton3;
    private ArrayList BuzzerData;
    BuzzerList myBuzzer = new BuzzerList(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.three_player_mode_activity);
        myBuzzer.loadFromFile();
        BuzzerData = myBuzzer.getBuzzer();
        FirstPlayerButton3 = (Button) findViewById(R.id.PlayerFirstButton);
        FirstPlayerButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer Num = 31;
                BuzzerData.add(Num);
                myBuzzer.setBuzzer(BuzzerData);
                myBuzzer.saveInFile();
                AlertDialog.Builder builder1 = new AlertDialog.Builder(ThreePlayerMode.this);
                builder1.setMessage("First Player Won!!");
                builder1.setCancelable(true);
                builder1.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int readyId) {
                        dialog.cancel();
                    }
                });
                AlertDialog alert11 = builder1.create();
                alert11.show();
            }
        });
        SecondPlayerButton3 = (Button) findViewById(R.id.PlayerTwoButton);
        SecondPlayerButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer Num = 32;
                BuzzerData.add(Num);
                myBuzzer.setBuzzer(BuzzerData);
                myBuzzer.saveInFile();
                AlertDialog.Builder builder2 = new AlertDialog.Builder(ThreePlayerMode.this);
                builder2.setMessage("Second Player Won");
                builder2.setCancelable(true);
                builder2.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int readyId) {
                        dialog.cancel();
                    }
                });
                AlertDialog alert11 = builder2.create();
                alert11.show();
            }
        });

        ThirdPlayerButton3 = (Button) findViewById(R.id.PlayerThreeButton);
        ThirdPlayerButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer Num = 33;
                BuzzerData.add(Num);
                myBuzzer.setBuzzer(BuzzerData);
                myBuzzer.saveInFile();
                AlertDialog.Builder builder2 = new AlertDialog.Builder(ThreePlayerMode.this);
                builder2.setMessage("Third Player Won");
                builder2.setCancelable(true);
                builder2.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int readyId) {
                        dialog.cancel();
                    }
                });
                AlertDialog alert11 = builder2.create();
                alert11.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_three_player_mode, menu);
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
