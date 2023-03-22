package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;


public class AlarmActivity extends AppCompatActivity {
    Timer timer;
    private TextView exercise;
    private TextView eat;
    private TextView sleep;
    private TextView wake;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        exercise = findViewById(R.id.alarm1);
        eat = findViewById(R.id.alarm2);
        sleep = findViewById(R.id.alarm3);
        wake = findViewById(R.id.alarm4);

        TimerTask task1 = new TimerTask() {
            public void run() {
                exercise.setText("Do some exercise");
            }
        };
        timer = new Timer();
        timer.schedule(task1, 1000);

        TimerTask task2 = new TimerTask() {
            public void run() {
                eat.setText("Eat Breakfast");
            }
        };
        timer = new Timer();
        timer.schedule(task2, 1500);

        TimerTask task3 = new TimerTask() {
            public void run() {
                sleep.setText("Sleep now");
            }
        };
        timer = new Timer();
        timer.schedule(task3, 2000);

        TimerTask task4 = new TimerTask() {
            public void run() {
                wake.setText("Wake up now");
            }
        };
        timer = new Timer();
        timer.schedule(task4, 3000);
    }
}