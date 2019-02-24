package com.example.hellotoastlandscapandtablet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
 private int ncount;
 private TextView textcount;
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
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);
        toast.show();
    }
}
