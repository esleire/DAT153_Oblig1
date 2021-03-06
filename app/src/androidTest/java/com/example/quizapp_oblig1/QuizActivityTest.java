package com.example.quizapp_oblig1;



import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewAction;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class QuizActivityTest {

    @Rule
    public ActivityScenarioRule<QuizActivity> mActivityRule =
            new ActivityScenarioRule<QuizActivity>(QuizActivity.class);

    @Test
    public void checkCorrectScore1(){
        onView(withId(R.id.text1)).perform(click());
        onView(withId(R.id.text2)).perform(click());
        onView(withId(R.id.text3)).perform(click());

        onView(withId(R.id.result)).check(matches(withText("1/3")));

    }

    @Test
    public void checkCorrectScore2(){
        onView(withId(R.id.text1)).perform(click());
        onView(withId(R.id.text2)).perform(click());
        onView(withId(R.id.text3)).perform(click());

        onView(withId(R.id.nextbutton)).perform(click());
        onView(withId(R.id.text1)).perform(click());
        onView(withId(R.id.text2)).perform(click());
        onView(withId(R.id.text3)).perform(click());

        onView(withId(R.id.result)).check(matches(withText("2/6")));

    }


}