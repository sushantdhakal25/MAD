package com.example.counterhomework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mnum;
    public  int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mnum=findViewById(R.id.textView);
        if (savedInstanceState != null)
        {
            mnum.setText(savedInstanceState
                    .getString("saved_text"));

        }
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("saved_text",mnum.getText().toString());

    }


    public void count(View view) {
          count++;
          mnum.setText(""+count++);

    }
}
