package com.example.tabexpirementhomework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showFirstActivity(View view) {
        Intent intent=new Intent(this,FirstActivity.class);
        startActivity(intent);
    }

    public void showSecondActivity(View view) {
        Intent intent=new Intent(this,SecondActivity.class);
        startActivity(intent);
    }

    public void showThirdActivity(View view) {
        Intent intent=new Intent(this,ThirdActivity.class);
        startActivity(intent);
    }
}