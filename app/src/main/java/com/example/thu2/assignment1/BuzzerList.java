package com.example.thu2.assignment1;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by AndyHu on 2015-10-03.
 */
public class BuzzerList extends Object {

    private final String FILENAME = "BuzzerData.sav";
    private ArrayList Buzzer = new ArrayList<Integer>();
    private Context context;

    public void setBuzzer(ArrayList Buzzer){
        this.Buzzer = Buzzer;
    }

    public void BuzzerTimes(Context context){
        this.context = context;
    }

    public void addBuzzer(Integer Buzzer){
        Buzzer.add(Buzzer);
    }

    public void DeleteBuzzer(){
        Buzzer.remove(Buzzer);
    }

    public ArrayList<Integer>getBuzzer(){
        return Buzzer;
    }
}
