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

public class FourPlayerMode extends Activity {
    Button FirstPlayerButton4;
    Button SecondPlayerButton4;
    Button ThirdPlayerButton4;
    Button FourthPlayerButton4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.four_player_mode_activity);
        FirstPlayerButton4 = (Button) findViewById(R.id.PlayerOneButton);
        FirstPlayerButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder2 = new AlertDialog.Builder(FourPlayerMode.this);
                builder2.setMessage("First Player Won");
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
        SecondPlayerButton4 = (Button) findViewById(R.id.PlayerTwoButton);
        SecondPlayerButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder2 = new AlertDialog.Builder(FourPlayerMode.this);
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

        ThirdPlayerButton4 = (Button) findViewById(R.id.PlayerThreeButton);
        ThirdPlayerButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder2 = new AlertDialog.Builder(FourPlayerMode.this);
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

        FourthPlayerButton4 = (Button) findViewById(R.id.PlayerFourButton);
        FourthPlayerButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder2 = new AlertDialog.Builder(FourPlayerMode.this);
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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_four_player_mode, menu);
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
