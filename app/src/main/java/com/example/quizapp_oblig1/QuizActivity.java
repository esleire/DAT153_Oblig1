package com.example.quizapp_oblig1;


import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;


import utils.DataConverter;
import utils.RandomGenerator;
import utils.Result;
import utils.Student;
import utils.StudentDAO;
import utils.StudentDatabase;

public class QuizActivity extends AppCompatActivity {


    private Student correctStudent;
    private QuizViewModel model;
    StudentDAO studentDAO;
    Result result;
    TextView resultView;
    Button onNext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_quiz);
        onNext = findViewById(R.id.nextbutton);
        resultView = findViewById(R.id.result);
        result = new Result();

        model = new ViewModelProvider(this).get(QuizViewModel.class);

        final Observer<String> scoreObserver = new Observer<String>() {

            @Override
            public void onChanged(@Nullable final String score) {

                resultView.setText(score);
            }
        };
        model.getCurrentScore().observe(this, scoreObserver);

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

        onAnswer(onNext, text1, text2, text3, option1, option2, option3, correctStudent, result, model);



        // onNext will be called everytime "NEXT-button" is clicked
        onNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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
                onAnswer(view, text1, text2, text3, option1, option2, option3, correctStudent, result, model);

            }
        });

    }

    /*

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_quiz);
        } else {

            setContentView(R.layout.activity_quiz);
        }

    }

    
     */





    private boolean updateScore(Student s, TextView answer, Result result, QuizViewModel model) {

        boolean correct = false;
        if(s.getName().toLowerCase().equals(answer.getText().toString().toLowerCase())) {
            correct = true;
            result.setCurrentScore();
        }
            result.setAttempts();
        model.getCurrentScore().setValue(result.toString());
        return correct;
    }


    public void onAnswer(View v, TextView text1, TextView text2, TextView text3, View option1, View option2, View option3, Student s, Result result, QuizViewModel model){


        // onClickListeneres for every option and changes background color if
        // answer is right or wrong. Also setting score.

        text1.setOnClickListener(view -> {
            if(updateScore(s, text1, result, model)){
                option1.setBackgroundColor(getResources().getColor(R.color.green));
            } else {
                option1.setBackgroundColor(getResources().getColor(R.color.red));
            }
        });

        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(updateScore(s, text2, result, model)){
                    option2.setBackgroundColor(getResources().getColor(R.color.green));
                } else {
                    option2.setBackgroundColor(getResources().getColor(R.color.red));
                }
            }
        });

        text3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(updateScore(s, text3, result, model)){
                    option3.setBackgroundColor(getResources().getColor(R.color.green));
                } else {
                    option3.setBackgroundColor(getResources().getColor(R.color.red));
                }
            }

        });


    }

}
