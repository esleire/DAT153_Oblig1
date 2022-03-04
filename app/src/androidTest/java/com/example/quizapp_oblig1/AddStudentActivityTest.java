package com.example.quizapp_oblig1;
import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;



import android.provider.ContactsContract;
import android.provider.Telephony;


import androidx.test.espresso.action.TypeTextAction;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class AddStudentActivityTest {

    @Rule
    public ActivityScenarioRule<AddStudentActivity> mActivityRule =
            new ActivityScenarioRule<AddStudentActivity>(AddStudentActivity.class);

    @Test
    public void checkAddStudent() {


        onView(withId(R.id.nameInput)).perform(typeText("Frede"));
        closeSoftKeyboard();
        onView(withId(R.id.imageView)).perform()


    }
}

