package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.util.ToastUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtn;
    private EditText mEditUser;
    private EditText mEditCode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtn = findViewById(R.id.btn1);
        mEditUser = findViewById(R.id.et_1);
        mEditCode = findViewById(R.id.et_2);

//        mBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = null;
//                intent = new Intent(MainActivity.this, funActivity.class);
//                startActivity(intent);
//            }
//        });
        mBtn.setOnClickListener(this);


    }

    public void onClick(View v){
        String username = mEditUser.getText().toString();
        String code = mEditCode.getText().toString();
        String ok = "Success";
        String fail = "Fail";

        Intent intent = null;
        if(username.equals("pxc") && code.equals("123")){
//            Toast.makeText(getApplicationContext(), ok, Toast.LENGTH_SHORT).show();
            ToastUtil.showMsg(getApplicationContext(), ok);
            intent = new Intent(MainActivity.this, SlideActivity.class);
            startActivity(intent);
        }
        else{
//            Toast toastCenter = Toast.makeText(getApplicationContext(), fail, Toast.LENGTH_SHORT);
//            toastCenter.setGravity(Gravity.CENTER, 0, 0);
//            toastCenter.show();
            ToastUtil.showMsg(getApplicationContext(), fail);
        }

    }
}