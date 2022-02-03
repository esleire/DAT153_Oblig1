package com.example.quizapp_oblig1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickAddButton(View view) {
        Button button = (Button) findViewById(R.id.addButton);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_addstudent);


            }
        });

    }
    public void clickQuizButton(View view) {
        Button button = (Button) findViewById(R.id.quizbutton);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_quiz);
            }

            });
        }

    public void clickDatabaseButton(View view) {
        Button button = (Button) findViewById(R.id.quizbutton);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_database);
            }

        });
    }

    }