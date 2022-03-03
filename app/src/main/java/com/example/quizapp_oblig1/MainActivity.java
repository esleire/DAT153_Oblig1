package com.example.quizapp_oblig1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import android.widget.Button;

import utils.DataConverter;
import utils.Student;
import utils.StudentDAO;
import utils.StudentDatabase;


public class MainActivity extends AppCompatActivity {

    StudentDAO studentDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


/*
        studentDAO = StudentDatabase.getDBInstance(this).studentDAO();

        Student e = new Student();

        e.setName("Even");
        Bitmap even = BitmapFactory.decodeResource(getBaseContext().getResources(), R.drawable.even);
        e.setImage(DataConverter.convertImage2Byte(even));

        studentDAO.insertUser(e);

        Student m = new Student();

        m.setName("Magnus");
        Bitmap magnus = BitmapFactory.decodeResource(getBaseContext().getResources(), R.drawable.magnus);
        m.setImage(DataConverter.convertImage2Byte(magnus));

        studentDAO.insertUser(m);

        Student f = new Student();

        f.setName("Frede");
        Bitmap frede = BitmapFactory.decodeResource(getBaseContext().getResources(), R.drawable.frede);
        f.setImage(DataConverter.convertImage2Byte(frede));

        studentDAO.insertUser(f);

*/


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


