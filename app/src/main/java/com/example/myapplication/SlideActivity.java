package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.myapplication.util.SlideMenu;

public class SlideActivity extends AppCompatActivity {
    private ImageView mHead;
    private SlideMenu slideMenu;
    private Button mBtn1;
    private Button mBtn2;
    private Button mBtn3;
    private Button mBtn4;
    private Button mBtn5;
    private Button mBtn9;
    private Button mBtn10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide);

        mHead = findViewById(R.id.image1);
        slideMenu = findViewById(R.id.slideMenu);
        mBtn1 = findViewById(R.id.btn_main1);
        mBtn2 = findViewById(R.id.btn_main2);
        mBtn3 = findViewById(R.id.btn_main3);
        mBtn4 = findViewById(R.id.btn_main4);
        mBtn5 = findViewById(R.id.btn_main5);
        mBtn9 = findViewById(R.id.btn_main9);
        mBtn10 = findViewById(R.id.alarm);

        mHead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                slideMenu.switchMenu();
            }
        });

        setListener();
    }

    private void setListener(){
        OnClick onClick = new OnClick();
        mBtn1.setOnClickListener(onClick);
        mBtn2.setOnClickListener(onClick);
        mBtn3.setOnClickListener(onClick);
        mBtn4.setOnClickListener(onClick);
        mBtn5.setOnClickListener(onClick);
        mBtn9.setOnClickListener(onClick);
        mBtn10.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            Intent intent = null;
            switch (view.getId()){
                case R.id.btn_main1:
                    intent = new Intent(SlideActivity.this, PIActivity.class);
                    break;
                case R.id.btn_main2:
                    intent = new Intent(SlideActivity.this, SAActivity.class);
                    break;
                case R.id.btn_main3:
                    intent = new Intent(SlideActivity.this, FAActivity.class);
                    break;
                case R.id.btn_main4:
                    intent = new Intent(SlideActivity.this, MAActivity.class);
                    break;
                case R.id.btn_main5:
                    intent = new Intent(SlideActivity.this, SportsActivity.class);
                    break;
                case R.id.btn_main9:
                    intent = new Intent(SlideActivity.this, HAActivity.class);
                    break;
                case R.id.alarm:
                    intent = new Intent(SlideActivity.this, AlarmActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}