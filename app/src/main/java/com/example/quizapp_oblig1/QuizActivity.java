package com.example.quizapp_oblig1;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import java.util.List;

import utils.Student;
import utils.StudentList;

public class QuizActivity extends AppCompatActivity {
    private StudentList studentList = new StudentList();
    private List<Student> listOfStudents = studentList.getStudentList();
    /*
    Metode som setter nytt view ved opprettelse av klassen
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        ImageView imgview = findViewById(R.id.imageView);
        TextView option1 = findViewById(R.id.text1);
        TextView option2 = findViewById(R.id.text2);
        TextView option3 = findViewById(R.id.text3);

        /**
         * Hardkoder midlertidig et bilde og navn inn i quiz
         */
            imgview.setImageResource(listOfStudents.get(0).getImage());
            option1.setText(listOfStudents.get(0).getName());
            option2.setText(listOfStudents.get(1).getName());
            option3.setText(listOfStudents.get(2).getName());


    }


}
