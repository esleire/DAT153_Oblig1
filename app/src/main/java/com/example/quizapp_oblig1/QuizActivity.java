package com.example.quizapp_oblig1;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Collections;
import java.util.List;

import utils.RandomGenerator;
import utils.Student;
import utils.StudentList;

public class QuizActivity extends AppCompatActivity {
    private StudentList studentList = new StudentList();
    private List<Student> listOfStudents = studentList.getStudentList();
    private RandomGenerator randomGenerator = new RandomGenerator();
    private Student correctStudent;
    /*
    Metode som setter nytt view ved opprettelse av klassen
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        View button = findViewById(R.id.nextbutton);
        onNext(button);




    }

    public void onNext(View v){

        ImageView imgview = findViewById(R.id.imageView);
        TextView option1 = findViewById(R.id.text1);
        TextView option2 = findViewById(R.id.text2);
        TextView option3 = findViewById(R.id.text3);

        /**
         * Hardkoder midlertidig et bilde og navn inn i quiz
         */

        correctStudent = randomGenerator.generateCorrectStudent();
        imgview.setImageResource(correctStudent.getImage());

        Collections.shuffle(listOfStudents);

        option1.setText(listOfStudents.get(0).getName());
        option2.setText(listOfStudents.get(1).getName());
        option3.setText(listOfStudents.get(2).getName());


        /**
         * Må sette correct til false på student når neste spørsmål laster
         */


    }


}
