package com.example.helloconstriant;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
 private int ncount;
 private TextView textcount;
 private Button btncount;
 private Button btnzero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textcount=(TextView) findViewById(R.id.show_count);
        btncount=(Button)findViewById(R.id.button_count);
        btnzero=(Button)findViewById(R.id.button_zero);
    }

    public void countUp(View view) {
        ncount++;
        textcount.setText(""+ncount);
        btnzero.setBackgroundColor(Color.BLACK);
        if (ncount%2==0)
        {
           view.setBackgroundColor(0xFF00FF00);
        }
        else
        {
            view.setBackgroundColor(0xffff0000);
        }
    }

    public void showtoast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void reset(View view) {
        if (textcount.equals("0"))
        {

        }
        else
        {
            ncount=0;
            textcount.setText(""+ncount);
            view.setBackgroundColor(Color.GRAY);
            btncount.setBackgroundColor(Color.BLUE);
        }


    }
}
