package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class PIActivity extends AppCompatActivity implements View.OnClickListener {

    private RadioGroup mRG1;
    private  RadioGroup mRG2;
    private  RadioGroup mRG3;
    private  RadioGroup mRGAlcohol;
    private  RadioGroup mRGExercise;
    private  RadioGroup mRGNervous;
    private  RadioButton mRB1 ,mRB2, mRB3,mRB4,mRB5,mRB6;
    public EditText mAge;
    public String age;
//    private EditText mGender;
    public  String gender;
    public EditText mWeight;
    public String weight;
    public EditText mHeight;
    public String height;
    public  String sleepTime;
    public  String alcohol;
    public  String exercise;
    public  String nervous;
    public  String food;
    public EditText mSystolicPressure;

    public String systolicPressure;
    public EditText mDiastolicPressure;

    public String diastolicPressure;
    public Button mBtn;
    public String subAge, subGender, subWeight, subHeight, subSleep, subFood;
    // we can get this from Android health life API. Pulse may equal to 80,100,120
    public  int pulse = 70;

    public double score = 0;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piactivity);

        mRG1 = findViewById(R.id.rg_1);
        mRG2 = findViewById(R.id.rg_2);
        mRG3 = findViewById(R.id.rg_3);
        mRGAlcohol = findViewById(R.id.rg_alcohol);
        mRGExercise = findViewById(R.id.ex_3);
        mRGNervous = findViewById(R.id.n_3);
        mAge = findViewById(R.id.et_1);
        mWeight = findViewById(R.id.et_2);
        mHeight = findViewById(R.id.et_3);
        mSystolicPressure = findViewById(R.id.systolic);
        mDiastolicPressure = findViewById(R.id.diastolic);
        mBtn = findViewById(R.id.pIAbtn1);


        mRG1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                mRB1 = radioGroup.findViewById(i);
                Toast.makeText(PIActivity.this, mRB1.getText(), Toast.LENGTH_SHORT).show();
                gender = mRB1.getText().toString();
            }
        });

        mRG2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                mRB2 = radioGroup.findViewById(i);
                Toast.makeText(PIActivity.this, mRB2.getText(), Toast.LENGTH_SHORT).show();
                sleepTime = mRB2.getText().toString();
            }
        });

        mRG3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                mRB3 = radioGroup.findViewById(i);
                Toast.makeText(PIActivity.this, mRB3.getText(), Toast.LENGTH_SHORT).show();
                food = mRB3.getText().toString();
            }
        });

        mRGAlcohol.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                mRB4 = radioGroup.findViewById(i);
                Toast.makeText(PIActivity.this, mRB4.getText(), Toast.LENGTH_SHORT).show();
                alcohol = mRB4.getText().toString();
            }
        });

        mRGExercise.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                mRB5 = radioGroup.findViewById(i);
                Toast.makeText(PIActivity.this, mRB5.getText(), Toast.LENGTH_SHORT).show();
                exercise = mRB5.getText().toString();
            }
        });

        mRGNervous.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                mRB6 = radioGroup.findViewById(i);
                Toast.makeText(PIActivity.this, mRB6.getText(), Toast.LENGTH_SHORT).show();
                nervous = mRB6.getText().toString();
            }
        });


        preferences = getSharedPreferences("config", Context.MODE_PRIVATE);
        reload();
        mBtn.setOnClickListener(this);

    }

    private void reload(){
        String reloadAge = preferences.getString("age", null);
        String reloadWeight = preferences.getString("weight", null);
        String reloadHeight = preferences.getString("height", null);
        String reloadSystolicPressure = preferences.getString("systolicPressure", null);
        String reloadDiastolicPressure = preferences.getString("diastolicPressure", null);


        if(reloadAge != null){
            mAge.setText(reloadAge);
        }

        if(reloadWeight != null){
            mWeight.setText(reloadWeight);
        }
        if(reloadHeight != null){
            mHeight.setText(reloadHeight);
        }
        if(reloadSystolicPressure != null){
            mSystolicPressure.setText(reloadSystolicPressure);
        }
        if(reloadDiastolicPressure != null){
            mDiastolicPressure.setText(reloadDiastolicPressure);
        }
    }

    @Override
    public void onClick(View view) {
        age = mAge.getText().toString();
        weight = mWeight.getText().toString();
        height = mHeight.getText().toString();
        systolicPressure = mSystolicPressure.getText().toString();
        diastolicPressure = mDiastolicPressure.getText().toString();

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("age", age).commit();
        editor.putString("weight", weight).commit();
        editor.putString("height", height).commit();
//        editor.putString("pulse", pulse).commit();
        editor.putString("alcohol", alcohol);
        editor.putString("nervous", nervous);
        editor.putString("exercise", exercise);
        editor.putString("systolicPressure", systolicPressure).commit();
        editor.putString("diastolicPressure",diastolicPressure).commit();
        editor.putBoolean("gender", mRB1.isChecked()).commit();
        editor.putString("sleepTime", sleepTime).commit();
        editor.putString("food", food).commit();

//        editor.commit();

        int weightNum = 0;
        int heightNum = 0;
        int sysNum = 0;
        int diaNum = 0;
        weightNum = Integer.parseInt(weight);
        heightNum = Integer.parseInt(height);
        sysNum = Integer.parseInt(systolicPressure);
        diaNum = Integer.parseInt(diastolicPressure);

        if(gender.substring(0,1).equals("m")){
            if((float)weightNum / (heightNum / 100) * (heightNum / 100) < 20 || (float)weightNum / (heightNum / 100) * (heightNum / 100) > 24){
                score += 12.5;
            }
        }else {
            if((float)weightNum / (heightNum / 100) * (heightNum / 100) < 18 || (float)weightNum / (heightNum / 100) * (heightNum / 100) > 23){
                score += 12.5;
            }
        }


//        if((float)weightNum / (heightNum / 100) * (heightNum / 100) < 18.5 || (float)weightNum / (heightNum / 100) * (heightNum / 100) > 24){
//        } else{
//            score += 20;
//        }
        if(90 < sysNum && sysNum < 140)
            score += 10;
        if(60 < diaNum && diaNum < 90)
            score += 10;
        if(60 < pulse && pulse < 100)
            score += 15;
//
        subSleep = sleepTime.substring(0, 1);
        if(subSleep.equals("7"))
            score += 12.5;
//
        subFood = food.substring(0, 1);
        if(subFood.equals("N"))
            score += 12.5;
        if(subFood.equals("O"))
            score += 10;
        String subAlcohol = alcohol.substring(0, 1);
        String subExercise = exercise.substring(0, 1);
        String subNervous = nervous.substring(0, 1);
        if(subAlcohol.equals("N"))
            score += 12.5;
        if(subAlcohol.equals("O"))
            score += 10;
        if(subExercise.equals("O"))
            score += 10;
        if(subExercise.equals("U"))
            score += 12.5;
        if(subNervous.equals("N"))
            score += 12.5;
        if(subNervous.equals("O"))
            score += 5;

        Intent intent = null;
        intent = new Intent(PIActivity.this, CSActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("age", age);
        bundle.putString("gender", gender);
        bundle.putString("weight", weight);
        bundle.putString("height", height);
        bundle.putString("sleepTime", sleepTime);
        bundle.putString("food", food);
        bundle.putString("alcohol", alcohol);
        bundle.putString("exercise", exercise);
        bundle.putString("nervous", nervous);
        bundle.putDouble("score", score);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}