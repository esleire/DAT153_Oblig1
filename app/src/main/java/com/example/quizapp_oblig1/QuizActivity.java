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
    private final RandomGenerator randomGenerator = new RandomGenerator(listOfStudents);

    private Student correctStudent;
    private int currentScore = 0, questionsAttempted = 0;
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
        TextView text1 = findViewById(R.id.text1);
        TextView text2 = findViewById(R.id.text2);
        TextView text3 = findViewById(R.id.text3);

        View option1 = findViewById(R.id.option1);
        View option2 = findViewById(R.id.option2);
        View option3 = findViewById(R.id.option3);

        TextView result = findViewById(R.id.result);


        //  Resetting backgroundcolor on next question


        option1.setBackgroundColor(getResources().getColor(R.color.white));
        option2.setBackgroundColor(getResources().getColor(R.color.white));
        option3.setBackgroundColor(getResources().getColor(R.color.white));

        /**
         * Henter en tilfeldig student og setter bilde i quiz
         */

        correctStudent = randomGenerator.generateCorrectStudent();
        imgview.setImageResource(correctStudent.getImage());

        /**
         * Shuffler listen for å gjøre rekkefølgen av alternativer tilfeldig
         */
        Collections.shuffle(listOfStudents);

        text1.setText(listOfStudents.get(0).getName());
        text2.setText(listOfStudents.get(1).getName());
        text3.setText(listOfStudents.get(2).getName());

        onAnswer(v, text1, text2, text3, option1, option2, option3, result);



    }

    public void onAnswer(View v, TextView text1, TextView text2, TextView text3, View option1, View option2, View option3, TextView result){

        /**
         * onClickListeneres for å sjekke hvilket alternativ som brukeren har valgt
         * endrer bakgrunnsfarger ettersom svaret er riktig eller galt
         */

        text1.setOnClickListener(view -> {
            if(correctStudent.getName().toLowerCase().equals(text1.getText().toString().toLowerCase())){
                currentScore++;
                option1.setBackgroundColor(getResources().getColor(R.color.green));
            } else {
                option1.setBackgroundColor(getResources().getColor(R.color.red));
            }
            questionsAttempted++;
            result.setText(currentScore + "/" + questionsAttempted);

        });

        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(correctStudent.getName().equalsIgnoreCase(text2.getText().toString())){
                    currentScore++;
                    option2.setBackgroundColor(getResources().getColor(R.color.green));
                } else {
                    option2.setBackgroundColor(getResources().getColor(R.color.red));
                }
                questionsAttempted++;
                result.setText(currentScore + "/" + questionsAttempted);
            }
        });

        text3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(correctStudent.getName().toLowerCase().equals(text3.getText().toString().toLowerCase())){
                    currentScore++;
                    option3.setBackgroundColor(getResources().getColor(R.color.green));
                } else {
                    option3.setBackgroundColor(getResources().getColor(R.color.red));
                }
                questionsAttempted++;
                result.setText(currentScore + "/" + questionsAttempted);
            }
        });




    }


}
