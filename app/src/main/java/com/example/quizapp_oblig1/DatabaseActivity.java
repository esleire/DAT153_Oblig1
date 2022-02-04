package com.example.quizapp_oblig1;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import utils.Student;
import utils.StudentList;

public class DatabaseActivity extends AppCompatActivity {
    /*
       Metode som setter nytt view ved opprettelse av klassen
     */
    private StudentList studentList = new StudentList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);


        ImageView imgview = findViewById(R.id.imageView);
        TextView textView = findViewById(R.id.textView);

        for(Student s : studentList.getStudentList()){

            textView.setText(s.getName());
            imgview.setImageResource(s.getImage());

        }



    }

}
