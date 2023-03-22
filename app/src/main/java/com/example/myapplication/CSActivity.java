package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CSActivity extends AppCompatActivity {

    public String age;
    public  String gender;
    public String weight;
    public String height;
    public  String sleepTime;
    public  String food;
    public  String alcohol;
    public  String exercise;
    public  String nervous;
    public double score;
    public TextView ageText;
    public TextView genderText;
    public TextView weightText;
    public TextView heightText;
    public TextView sleepText;
    public TextView foodText;
    public TextView alcoholText;
    public TextView exerciseText;
    public TextView nervousText;
    public TextView scoreText;
    public String showTextAge;
    public String showTextGender;
    public String showTextWeight;
    public String showTextHeight;
    public String showTextSleep;
    public String showTextFood;
    public String showTextAlcohol;
    public String showTextExercise;
    public String showTextNervous;
    public double showTextScore;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_csactivity);

//        if(editText.getText().toString() != ""){
        ageText = findViewById(R.id.age);
        genderText = findViewById(R.id.gender);
        weightText = findViewById(R.id.weight);
        heightText = findViewById(R.id.height);
        sleepText = findViewById(R.id.sleep);
        foodText = findViewById(R.id.food);
        scoreText = findViewById(R.id.score);
        alcoholText =findViewById(R.id.alcohol);
        exerciseText = findViewById(R.id.exercise);
        nervousText = findViewById(R.id.nervous);
        Bundle bundle = getIntent().getExtras();
        showTextAge = bundle.getString("age");
        showTextGender = bundle.getString("gender");
        showTextWeight = bundle.getString("weight");
        showTextHeight = bundle.getString("height");
        showTextSleep = bundle.getString("sleepTime");
        showTextFood = bundle.getString("food");
        showTextAlcohol = bundle.getString("alcohol");
        showTextExercise = bundle.getString("exercise");
        showTextNervous = bundle.getString("nervous");
        showTextScore = bundle.getDouble("score");
        ageText.setText(showTextAge);
        genderText.setText(showTextGender);
        weightText.setText(showTextWeight);
        heightText.setText(showTextHeight);
        sleepText.setText(showTextSleep);
        foodText.setText(showTextFood);
        alcoholText.setText(showTextAlcohol);
        exerciseText.setText(showTextExercise);
        nervousText.setText(showTextNervous);
        scoreText.setText("" + showTextScore);
//        } else {
//            editText = findViewById(R.id.eet1);
//            editText.setText("14");
//        }
    }
}