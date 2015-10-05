package com.example.thu2.assignment1;

//import android.content.Context;
//import java.util.ArrayList;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by AndyHu on 2015-10-03.
 */
public class TimeRecord extends Object {
    private final String FILENAME ="TimeData.sav";
    private ArrayList TimeData = new ArrayList<Double>();
    private Context context;

    public TimeRecord(Context context) {
        this.context=context;
    }
    public void setTime(Double time){
        TimeData.add(time);
    }
    public ArrayList<Double> getAllTime(){
        return TimeData;
    }
    public void clearTimes(){
        TimeData.remove(TimeData);
    }
    public ArrayList<Double> getLastTen() {

        if (TimeData.size() <= 10) {
            return TimeData;
        } else {
            ArrayList lastTen = new ArrayList<Double>();
            for (int i = 1; i < 11; i++) {
                lastTen.add(TimeData.get(TimeData.size() - i));
            }
            return lastTen;
        }
    }
    public ArrayList<Double> getLastHundred() {
        if (TimeData.size() <= 100) {
            return TimeData;
        } else {
            ArrayList lastHundred = new ArrayList<Double>();
            for (int i = 1; i < 101; i++) {
                lastHundred.add(TimeData.get(TimeData.size() - i));
            }
            return lastHundred;
        }
    }

    public void saveInFile() {
        try {
            FileOutputStream fos = context.openFileOutput(FILENAME,
                    0);
            OutputStreamWriter writer = new OutputStreamWriter(fos);
            Gson gson = new Gson();
            gson.toJson(TimeData,writer);
            writer.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            throw new  RuntimeException(e);
        } catch (IOException e) {
            throw new  RuntimeException(e);
        }
    }

    public void loadFromFile() {
        try {
            FileInputStream fis = context.openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson =new Gson();
            //Taken from https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html
            Type listType = new TypeToken<ArrayList<Double>>() {}.getType();
            TimeData=(gson.fromJson(in, listType));
        } catch (FileNotFoundException e) {
            TimeData= new ArrayList<Double>();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
