package com.example.quizapp_oblig1;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;


import utils.DataConverter;
import utils.RandomGenerator;
import utils.Student;
import utils.StudentDAO;
import utils.StudentDatabase;

public class QuizActivity extends AppCompatActivity {


    private Student correctStudent;
    private int currentScore = 0, questionsAttempted = 0;
    StudentDAO studentDAO;
    private QuizViewModel model;
    TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        View button = findViewById(R.id.nextbutton);
        result = findViewById(R.id.result);

        model = new ViewModelProvider(this).get(QuizViewModel.class);

        final Observer<String> scoreObserver = new Observer<String>() {

            @Override
            public void onChanged(@Nullable final String score) {

               // Hent hjelpemetode
            }
        };

        final Observer<String> attemptObserver = new Observer<String>() {

            @Override
            public void onChanged(@Nullable final String attempt) {

                // Hent hjelpemetode
            }
        };



        // onNext will be called everytime "NEXT-button" is clicked
        onNext(button, result);

    }

    private void updateScore(Student s, TextView answer) {

        if(s.getName().toLowerCase().equals(answer.getText().toString().toLowerCase())) {
            currentScore++;
        }
        questionsAttempted++;
    }

    public void onNext(View v, TextView result){

        studentDAO = StudentDatabase.getDBInstance(this).studentDAO();

        List<Student> listOfStudents = studentDAO.getAllUsers();

        // RandomGenerator will generate new student in the quiz and options
        RandomGenerator randomGenerator = new RandomGenerator(listOfStudents);

        ImageView imgview = findViewById(R.id.imageView);
        TextView text1 = findViewById(R.id.text1);
        TextView text2 = findViewById(R.id.text2);
        TextView text3 = findViewById(R.id.text3);

        View option1 = findViewById(R.id.option1);
        View option2 = findViewById(R.id.option2);
        View option3 = findViewById(R.id.option3);




        //  Resetting backgroundcolor on next question

        option1.setBackgroundColor(getResources().getColor(R.color.white));
        option2.setBackgroundColor(getResources().getColor(R.color.white));
        option3.setBackgroundColor(getResources().getColor(R.color.white));


        correctStudent = randomGenerator.generateCorrectStudent();
        List<Student> optionList = randomGenerator.generateOptions();
        imgview.setImageBitmap(DataConverter.convertByteArray2Image(correctStudent.getImage()));


        // setting options
        text1.setText(optionList.get(0).getName());
        text2.setText(optionList.get(1).getName());
        text3.setText(optionList.get(2).getName());


        // calling onAnswer when the user clicks a option
        onAnswer(v, text1, text2, text3, option1, option2, option3, result);



    }

    public void onAnswer(View v, TextView text1, TextView text2, TextView text3, View option1, View option2, View option3, TextView result){


        // onClickListeneres for every option and changes background color if
        // answer is right or wrong. Also setting score.

        text1.setOnClickListener(view -> {
            if(correctStudent.getName().toLowerCase().equals(text1.getText().toString().toLowerCase())){
                currentScore++;
                option1.setBackgroundColor(getResources().getColor(R.color.green));
            } else {
                option1.setBackgroundColor(getResources().getColor(R.color.red));
            }
            questionsAttempted++;
            String score = Integer.toString(currentScore);
            String attempt = Integer.toString(questionsAttempted);
            model.getCurrentScore().setValue(score);
            model.getQuestionsAttempted().setValue(attempt);
            result.setText(model.getCurrentScore().toString() + "/" + model.getQuestionsAttempted().toString());

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
                String score = Integer.toString(currentScore);
                String attempt = Integer.toString(questionsAttempted);
                model.getCurrentScore().setValue(score);
                model.getQuestionsAttempted().setValue(attempt);
                result.setText(model.getCurrentScore().toString() + "/" + model.getQuestionsAttempted().toString());

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
                String score = Integer.toString(currentScore);
                String attempt = Integer.toString(questionsAttempted);
                model.getCurrentScore().setValue(score);
                model.getQuestionsAttempted().setValue(attempt);
                result.setText(model.getCurrentScore().toString() + "/" + model.getQuestionsAttempted().toString());

            }
        });


    }

}
