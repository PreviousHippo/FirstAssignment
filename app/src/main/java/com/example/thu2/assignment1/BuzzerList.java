package com.example.thu2.assignment1;

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
public class BuzzerList  {

    private final String FILENAME="BuzzerData.sav";

    private ArrayList Buzzer=new ArrayList<Integer>();
    private Context context;
    public BuzzerList(Context context) {
        this.context=context;
    }
    public void setBuzzer(ArrayList Buzzer) {
        this.Buzzer = Buzzer;
    }
    public void clearBuzzer(){
        Buzzer.remove(Buzzer);
    }
    public ArrayList<Integer>getBuzzer(){
        return Buzzer;
    }
    public void saveInFile() {
        try {
            FileOutputStream fos = context.openFileOutput(FILENAME,
                    0);
            OutputStreamWriter writer = new OutputStreamWriter(fos);
            Gson gson = new Gson();
            gson.toJson(Buzzer,writer);
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
            Type listType = new TypeToken<ArrayList<Integer>>() {}.getType();
            Buzzer=(gson.fromJson(in, listType));
        } catch (FileNotFoundException e) {
            Buzzer= new ArrayList<Integer>();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
