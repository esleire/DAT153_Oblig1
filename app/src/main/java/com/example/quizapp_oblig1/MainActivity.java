package com.example.quizapp_oblig1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import android.widget.Button;

import utils.Student;
import utils.StudentDao;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // Setting onClickListeners on every button in main-menu.
        // sending the user to the correct activity after click.
        Button addButton = findViewById(R.id.addButton);
        Button quizButton = findViewById(R.id.quizbutton);
        Button databaseButton = findViewById(R.id.databaseButton);



        addButton.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, AddStudentActivity.class)));
        quizButton.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, QuizActivity.class)));
        databaseButton.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, DatabaseActivity.class)));



    }



    }


