package com.example.hellotoast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
 private int ncount;
 private TextView textcount;
    public static final int TEXT_REQUEST = 1;
    public static final String EXTRA_MESSAGE = "com.example.android.hellotoast.extra.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textcount=(TextView) findViewById(R.id.show_count);
    }

    public void countUp(View view) {
        ncount++;
        textcount.setText(""+ncount);
    }

    public void showtoast(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        String message = textcount.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, TEXT_REQUEST);
    }
}
