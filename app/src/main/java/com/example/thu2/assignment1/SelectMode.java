package com.example.thu2.assignment1;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class SelectMode extends ActionBarActivity {

    Button SinglePlayerButton;
    Button MultiPlayerButton;
    Button StatAndUsageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectmodelayout);
        SinglePlayerButton = (Button) findViewById(R.id.SinglePressButton);
        SinglePlayerButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_select_mode, menu);
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
    public void SinglePlayerMode(View view){
        Intent GotoSinglePlayerMode = new Intent(SelectMode.this, SinglePlayerMode.class);
        startActivity(GotoSinglePlayerMode);
    }
    public void MultiPlayerMode(View view){
        Intent GotoMultiPlayerMode = new Intent(SelectMode.this, MultiPlayerMode.class);
        startActivity(GotoMultiPlayerMode);
    }
    public void StatsMode(View view){
        Intent GotoStatsMode = new Intent(SelectMode.this, StatMode.class);
        startActivity(GotoStatsMode);
    }

}
