package com.example.thu2.assignment1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Arrays;


public class StatMode extends Activity {

    private TextView Message;
    public ArrayList Buzzer;
    private ArrayList Times;
    private ArrayList LastTenNum;
    private ArrayList LastHundredNum;
    BuzzerList myBuzzerData = new BuzzerList(this);
    TimeRecord myTimeDataRecord = new TimeRecord(this);


    public void startStat() {
        myTimeDataRecord.loadFromFile();
        myBuzzerData.loadFromFile();
        Buzzer=myBuzzerData.getBuzzer();
        Message= (TextView) findViewById(R.id.StatDisplay);
        UpdateLatencyData();

        Message.setText("Reaction Time: \n"
        +"Maximum of all time: " +String.format("%.5f",Max(Times))+ "s\n"
        +"Minimum of all time: " +String.format("%.5f",Min(Times))+ "s\n"
        +"Minimum of last ten record: " +String.format("%.5f",Min(LastTenNum))+ "s\n"
        +"Minimum of last hundred record: " +String.format("%.5f",Min(LastHundredNum))+ "s\n"
        +"Maximum of last ten record: " +String.format("%.5f",Max(LastTenNum))+ "s\n"
        +"Minimum of last hundred record: " +String.format("%.5f",Max(LastHundredNum))+ "s\n"
        +"Average: " +String.format("%.5f",Average(Times))+ "s\n"
                +"Average of last ten record: " +String.format("%.5f",Average(LastTenNum))+ "s\n"
                +"Average of last hundred record: " +String.format("%.5f",Average(LastHundredNum))+ "s\n"
                +"Median: " +String.format("%.5f",Median(Times))+ "s\n"
                +"Median of last ten record: " +String.format("%.5f",Median(LastTenNum))+ "s\n"
                +"Median of last hundred record: " +String.format("%.5f",Median(LastHundredNum))+ "s\n"
        +"Buzzer Count: \n"
        +"Two Player Mode: \nPlayer 1 won " + TwoPlayerFirst(Buzzer) +" times.\nPlayer 2 won " + TwoPlayerSecond(Buzzer) +" times.\n"
        +"Three Player Mode: \nPlayer 1 won " + ThreePlayerFirst(Buzzer) +" times.\nPlayer 2 won " + ThreePlayerSecond(Buzzer) +" times. \nPlayer 3 won " + ThreePlayerThird(Buzzer) +" times\n"
        +"Four Player Mode: \nPlayer 1 won " + FourPlayerFirst(Buzzer) + " times. \nPlayer 2 won "+ FourPlayerSecond(Buzzer) +" times. \nPlayer 3 won " + FourPlayerThird(Buzzer) +" times. \nPlayer 4 won " + FourPlayerFourth(Buzzer) +" times.\n" );
    }

    public Double Max(ArrayList list){
        Double max;
        if(list.size() == 0 ){
            return 0.00;
        }else{
            max = (Double) list.get(0);
            for(int i = 0;i<list.size();i++){
                if(max<(Double) list.get(i)){
                    max = (Double) list.get(i);
                }
            }
            return  max;
        }
    }

    public Double Min(ArrayList list){
        Double min;
        if(list.size() == 0 ){
            return 0.00;
        }else{
            min = (Double) list.get(0);
            for(int i = 0;i<list.size();i++){
                if(min>(Double) list.get(i)){
                    min = (Double) list.get(i);
                }
            }
            return min;
        }
    }

    public Double Average(ArrayList list){
        Double Average;
        Double Sum = 0.00;
        int Num = list.size();
        if(list.size() == 0){
            return 0.00;
        }else{
            //need create an new array to get all the value from the old one
            Double[] AverageArray = new Double[list.size()];
            for(int i = 0;i<Num;i++){
                AverageArray[i] = ((Double) list.get(i));
            }
            for(Double i : AverageArray){
                Sum = Sum+i;
            }
            Average = Sum/Num;
            return Average;
        }
    }

    public Double Median(ArrayList list){
        Double Median;
        if(list.size() == 0){
            return 0.00;
        }else{
            //create an new array
            Double[] MedianArray = new Double[list.size()];
            for(int i =0;i<list.size();i++){
                MedianArray[i] = ((Double) list.get(i));
            }
            //sort this array
            Arrays.sort(MedianArray);
            //2 condition for find median, odd and even
            //for even, it should be 2 numbers average. odd is only one number
            if(MedianArray.length %2 == 0){
                Median = (MedianArray[MedianArray.length /2]+MedianArray[(MedianArray.length /2) -1])/2;
            }else{
                Median = (MedianArray[MedianArray.length /2]);
            }
            return Median;
        }
    }
    public void ClearData(View view){
        myTimeDataRecord.clearTimes();
        myTimeDataRecord.saveInFile();
        myBuzzerData.clearBuzzer();
        myBuzzerData.saveInFile();
        startStat();
    }

    public void UpdateLatencyData(){
        Times = myTimeDataRecord.getTime();
        LastTenNum = myTimeDataRecord.getLastTen();
        LastHundredNum = myTimeDataRecord.getLastHundred();
    }


    //basically, i set a PlayerSin for each MultiPlayerMode each player, all i need to
    //do is count how many times the PlayerSin appears in the BuzzerList, each class just simply
    //repeat this action until all PlayerSin checked
    public int TwoPlayerFirst(ArrayList list){
        if(list.size() == 0 ) {
            return 0;
        }else{
            //used 21 represent 2 player mode and the first player
            int Count = 0;
            Integer PlayerSin = 21;
            for(int i =0;i<list.size();i++){
                if(list.get(i) == PlayerSin){
                    Count = Count +1;
                }
            }
            return Count;
        }
    }

    public int TwoPlayerSecond(ArrayList list){
        if(list.size() == 0 ) {
            return 0;
        }else{
            //used 22 represent 2 player mode and the Second player
            int Count = 0;
            Integer PlayerSin = 22;
            for(int i =0;i<list.size();i++){
                if(list.get(i) == PlayerSin){
                    Count = Count +1;
                }
            }
            return Count;
        }
    }

    public int ThreePlayerFirst(ArrayList list){
        if(list.size() == 0 ) {
            return 0;
        }else{
            //used 31 represent 3 player mode and the first player
            int Count = 0;
            Integer PlayerSin = 31;
            for(int i =0;i<list.size();i++){
                if(list.get(i) == PlayerSin){
                    Count = Count +1;
                }
            }
            return Count;
        }
    }

    public int ThreePlayerSecond(ArrayList list){
        if(list.size() == 0 ) {
            return 0;
        }else{
            //used 32 represent 3 player mode and the Second player
            int Count = 0;
            Integer PlayerSin = 32;
            for(int i =0;i<list.size();i++){
                if(list.get(i) == PlayerSin){
                    Count = Count +1;
                }
            }
            return Count;
        }
    }

    public int ThreePlayerThird(ArrayList list){
        if(list.size() == 0 ) {
            return 0;
        }else{
            //used 33 represent 3 player mode and the Third player
            int Count = 0;
            Integer PlayerSin = 33;
            for(int i =0;i<list.size();i++){
                if(list.get(i) == PlayerSin){
                    Count = Count +1;
                }
            }
            return Count;
        }
    }

    public int FourPlayerFirst(ArrayList list){
        if(list.size() == 0 ) {
            return 0;
        }else{
            //used 41 represent 4 player mode and the first player
            int Count = 0;
            Integer PlayerSin = 41;
            for(int i =0;i<list.size();i++){
                if(list.get(i) == PlayerSin){
                    Count = Count +1;
                }
            }
            return Count;
        }
    }


    public int FourPlayerSecond(ArrayList list){
        if(list.size() == 0 ) {
            return 0;
        }else{
            //used 42 represent 4 player mode and the Second player
            int Count = 0;
            Integer PlayerSin = 42;
            for(int i =0;i<list.size();i++){
                if(list.get(i) == PlayerSin){
                    Count = Count +1;
                }
            }
            return Count;
        }
    }

    public int FourPlayerThird(ArrayList list){
        if(list.size() == 0 ) {
            return 0;
        }else{
            //used 43 represent 4 player mode and the Third player
            int Count = 0;
            Integer PlayerSin = 43;
            for(int i =0;i<list.size();i++){
                if(list.get(i) == PlayerSin){
                    Count = Count +1;
                }
            }
            return Count;
        }
    }

    public int FourPlayerFourth(ArrayList list){
        if(list.size() == 0 ) {
            return 0;
        }else{
            //used 44 represent 4 player mode and the Fourth player
            int Count = 0;
            Integer PlayerSin = 44;
            for(int i =0;i<list.size();i++){
                if(list.get(i) == PlayerSin){
                    Count = Count +1;
                }
            }
            return Count;
        }
    }



    //http://stackoverflow.com/questions/28546703/how-to-code-using-android-studio-to-send-an-email
    public void SendEmail(View view){
        String[] TO = {""};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mail to:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, Message.getText());
        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
        }catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(StatMode.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stat_mode_activity);
        myTimeDataRecord.loadFromFile();
        startStat();
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
