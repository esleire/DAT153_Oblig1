package com.example.quizapp_oblig1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import utils.Student;
import utils.StudentList;

public class DatabaseActivity extends AppCompatActivity {
    /*
       Metode som setter nytt view ved opprettelse av klassen
     */
    private StudentList studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        studentList.getStudentList();
        setContentView(R.layout.activity_addstudent);

    }

}
