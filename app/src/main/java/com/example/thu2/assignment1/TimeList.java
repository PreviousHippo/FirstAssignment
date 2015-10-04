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
public class TimeList extends Object {
    private final String FILENAME ="TimeDate.sav";
    private ArrayList TimeData= new ArrayList<Double>();
    private Context context;

    public TimeList(Context context){
        this.context=context;
    }

    //public void addTime(Double time){
    //time.add(time);
    //}

    public void setTime(ArrayList<Double> TimeData){
        this.TimeData = TimeData;
    }

    public ArrayList<Double> getAllTime(){
        return TimeData;
    }

    public void clearTimeData(){
        TimeData.removeAll(TimeData);
    }

    public ArrayList<Double> getLastTen(){
        if(TimeData.size() <= 10){
            return TimeData;
        }else{
         ArrayList lastTen = new ArrayList<Double>();
            for(int i =1;i<11;i++){
                lastTen.add(TimeData.get(TimeData.size() - i));
            }
            return lastTen;
        }
    }

    public ArrayList<Double> getLastHund(){
        if(TimeData.size() <= 100){
            return TimeData;
        }else{
            ArrayList lastHund = new ArrayList<Double>();
            for(int i =1;i<11;i++){
                lastHund.add(TimeData.get(TimeData.size() - i));
            }
            return lastHund;
        }
    }

    public void saveInFile(){
        try{
            FileOutputStream fos = context.openFileOutput(FILENAME,0);
            OutputStreamWriter writer = new OutputStreamWriter(fos);
            Gson gson = new Gson();
            gson.toJson(TimeData,writer);
            writer.flush();
            fos.close();
        }catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    public void loadFromFile(){
        try {
            FileInputStream fis = context.openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<Integer>>() {
            }.getType();
            TimeData = (gson.fromJson(in, listType));
        }catch (FileNotFoundException e){
            TimeData = new ArrayList<Integer>();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }


}
