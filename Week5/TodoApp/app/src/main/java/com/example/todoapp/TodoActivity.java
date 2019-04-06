package com.example.todoapp;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class TodoActivity extends AppCompatActivity {

    private String[] ntodos;
    private  int nTodoINdex=0;
    private Button buttonDetails;
    public static final int TEXT_REQUEST = 1;
    public static final String TAG = TodoActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE ="com.example.android.todoapp.extra.REPLY";
    private static final String TODO_INDEX = "com.example.todoIndex";

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(TODO_INDEX, nTodoINdex);
        Log.d(TAG, "onSaveInstanceState(): screen-rotated - activity going to be destroyed");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        if (savedInstanceState != null){
            nTodoINdex = savedInstanceState.getInt(TODO_INDEX, 0);
            Log.d(TAG, "onCreate(): activity re-created");

        } else {
            // Activity is being created anew. No prior saved
            // instance state information available in Bundle object.
            Log.d(TAG, "onCreate(): activity created anew");
        }

        Resources res=getResources();
        ntodos=res.getStringArray(R.array.todos);

        final TextView textViewTodo;
        textViewTodo=(TextView)findViewById(R.id.textViewTodo);
        textViewTodo.setText(ntodos[nTodoINdex]);

        Button buttonNext=(Button)findViewById(R.id.buttonNext);
        Button buttonDetaits=(Button)findViewById(R.id.button_Details);
        Button buttonPrev=(Button)findViewById(R.id.buttonPrev);


        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nTodoINdex=(nTodoINdex+1)% ntodos.length;
                textViewTodo.setText(ntodos[nTodoINdex]);
            }
        });

        buttonPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nTodoINdex=(nTodoINdex-1)% ntodos.length;
                textViewTodo.setText(ntodos[nTodoINdex]);
            }
        });

        buttonDetaits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TodoActivity.this, TodoDetailActivity.class);
                startActivity(intent);

                String message = textViewTodo.getText().toString();
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivityForResult(intent, TEXT_REQUEST);
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() - the activity is about to become visible");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,
                "onResume() - the activity has become visible (it is now " +
                        "\"resumed\")");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,
                "onPause() - another activity is taking focus (this activity " +
                        "is about to be \"paused\")");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,
                "onStop() - the activity is no longer visible (it is now " +
                        "\"stopped\")");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart() - the activity is about to be restarted()");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() - the activity is about to be destroyed");
    }

}
