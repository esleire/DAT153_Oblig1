package com.example.quizapp_oblig1;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class QuizViewModel extends ViewModel {

    private MutableLiveData<String> currentScore;


    public MutableLiveData<String> getCurrentScore() {
        if (currentScore == null) {
            currentScore = new MutableLiveData<String>();
        }
        return currentScore;
    }

}
