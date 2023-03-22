package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class HAActivity extends AppCompatActivity {

    public String age;
    public String weight;
    public String height;
    public String food;
    public String alcohol;
    public String exercise;
    public String sleep;
    public String nervous;
    public TextView textWh;
    public TextView textFood;
    public TextView textAlcohol;
    public TextView textSleep;
    public TextView textNervous;
    public TextView textExercise;
    public TextView textSystolicPressure;
    public TextView textDiastolicPressure;
    public String systolicPressure;
    public String diastolicPressure;

    private SharedPreferences preferences;

    private void reload(){
        age = preferences.getString("age", null);
        weight = preferences.getString("weight", null);
        height = preferences.getString("height", null);
        systolicPressure = preferences.getString("systolicPressure", null);
        diastolicPressure = preferences.getString("diastolicPressure", null);
        alcohol = preferences.getString("alcohol", null);
        exercise = preferences.getString("exercise", null);
        nervous = preferences.getString("nervous", null);
        food = preferences.getString("food", null);
        sleep = preferences.getString("sleepTime", null);

        textWh = findViewById(R.id.t1);
        textSleep = findViewById(R.id.t2);
        textFood = findViewById(R.id.t3);
        textAlcohol = findViewById(R.id.t4);
        textExercise = findViewById(R.id.t5);
        textNervous = findViewById(R.id.t6);
        textSystolicPressure = findViewById(R.id.t7);
        textDiastolicPressure = findViewById(R.id.t8);

        int weightNum = 0;
        int heightNum = 0;
        int sysNum = 0;
        int diaNum = 0;
        weightNum = Integer.parseInt(weight);
        heightNum = Integer.parseInt(height);
        sysNum = Integer.parseInt(systolicPressure);
        diaNum = Integer.parseInt(diastolicPressure);

        if((float)weightNum / (heightNum / 100) * (heightNum / 100) < 20){
            textWh.setText("Your BMI is too low, and you need to increase your food intake moderately");
        } else if((float)weightNum / (heightNum / 100) * (heightNum / 100) > 24){
            textWh.setText("Your BMI is too high, so you need to reduce food intake and exercise more");
        } else{
            textWh.setText("Your BMI is normal, please continue to maintain it");
        }

        if(sleep.substring(0, 1).equals("7")){
            textSleep.setText("Your sleep duration is normal, please continue to maintain it");
        } else if(sleep.substring(0, 1).equals("l")){
            textSleep.setText("Your sleep duration is relatively short, please do not stay up late");
        } else{
            textSleep.setText("Your sleep duration is longer, please go to bed early and get up early");
        }
//
        if(food.substring(0, 1).equals("N")){
            textFood.setText("Your eating habits are good, please continue to maintain them");
        } else if(sleep.substring(0, 1).equals("O")){
            textFood.setText("Your eating habits are good, please continue to maintain them");
        } else{
            textFood.setText("Please reduce your intake of spicy food, which is not good for your health");
        }

        if(alcohol.substring(0, 1).equals("N")){
            textAlcohol.setText("Your drinking habits are good, please continue to maintain them");
        } else if(sleep.substring(0, 1).equals("O")){
            textAlcohol.setText("Your drinking habits are good, please continue to maintain them");
        } else{
            textAlcohol.setText("Please reduce your intake of alcohol, which is not good for your health");
        }

        if(exercise.substring(0, 1).equals("N")){
            textExercise.setText("Your exercise is not up to standard, please increase your exercise intensity");
        } else if(sleep.substring(0, 1).equals("O")){
            textExercise.setText("Please increase your exercise time if possible");
        } else{
            textExercise.setText("Please continue to maintain your exercise plan");
        }

        if(nervous.substring(0, 1).equals("N")){
            textNervous.setText("Your mood is good, please keep it up");
        } else if(sleep.substring(0, 1).equals("O")){
            textNervous.setText("Please try to overcome your anxiety");
        } else{
            textNervous.setText("Please seek help from a family member or psychologist as soon as possible");
        }

        if(90 < sysNum && sysNum < 140){
            textSystolicPressure.setText("Your systolic blood pressure is normal");
        } else {
            textSystolicPressure.setText("Your systolic blood pressure is abnormal. Please seek medical attention as soon as possible");
        }

        if(60 < diaNum && diaNum < 90){
            textDiastolicPressure.setText("Your diastolic blood pressure is normal");
        } else{
            textDiastolicPressure.setText("Your systolic blood pressure is abnormal. Please seek medical attention as soon as possible");
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_haactivity);

        preferences = getSharedPreferences("config", Context.MODE_PRIVATE);
        reload();
    }
}