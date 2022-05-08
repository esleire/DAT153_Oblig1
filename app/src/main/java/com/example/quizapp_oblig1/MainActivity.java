package com.example.quizapp_oblig1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Button;

import utils.DataConverter;
import utils.Student;
import utils.StudentDAO;
import utils.StudentDatabase;


public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    StudentDAO studentDAO;

    private static final String TAG = "Gestures";
    private GestureDetectorCompat mDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentDAO = StudentDatabase.getDBInstance(this).studentDAO();


        // Instantiate the gesture detector with the
        // application context and an implementation of
        // GestureDetector.OnGestureListener
        mDetector = new GestureDetectorCompat(this, this);

        // Set the gesture detector as the double tap
        // listener.
        mDetector.setOnDoubleTapListener(this);


        // Setting onClickListeners on every button in main-menu.
        // sending the user to the correct activity after click.
        Button addButton = findViewById(R.id.addButton);
        Button quizButton = findViewById(R.id.quizbutton);
        Button databaseButton = findViewById(R.id.databaseButton);

        // Insert to DB-code
        /*
        Student e = new Student();

        e.setName("Even");
        Bitmap even = BitmapFactory.decodeResource(getResources(), R.drawable.even);
        e.setImage(DataConverter.convertImage2Byte(even));

        studentDAO.insertUser(e);

        Student m = new Student();

        m.setName("Magnus");
        Bitmap magnus = BitmapFactory.decodeResource(getResources(), R.drawable.magnus);
        m.setImage(DataConverter.convertImage2Byte(magnus));

        studentDAO.insertUser(m);

        Student f = new Student();

        f.setName("Frede");
        Bitmap frede = BitmapFactory.decodeResource(getResources(), R.drawable.frede);
        f.setImage(DataConverter.convertImage2Byte(frede));

        studentDAO.insertUser(f);


*/
        addButton.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, AddStudentActivity.class)));
        quizButton.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, QuizActivity.class)));
        databaseButton.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, DatabaseActivity.class)));

    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        // If event passed is a valid gesture in GestureDetector
        // if true, call the corresponding callback method
        if (this.mDetector.onTouchEvent(event)) {
            return true;
        }
        return super.onTouchEvent(event);
    }


    @Override
    public boolean onDown(MotionEvent event) {
        Log.d(TAG,"onDown: " + event.toString());
        return true;
    }

    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2,
                           float velocityX, float velocityY) {
        Log.d(TAG, "onFling: " + event1.toString() + event2.toString());
        startActivity(new Intent(MainActivity.this, DatabaseActivity.class));
        return true;
    }

    @Override
    public void onLongPress(MotionEvent event) {
        Log.d(TAG, "onLongPress: " + event.toString());
        startActivity(new Intent(MainActivity.this, AddStudentActivity.class));
    }

    @Override
    public boolean onScroll(MotionEvent event1, MotionEvent event2, float distanceX,
                            float distanceY) {

        Log.d(TAG, "onScroll: " + event1.toString() + event2.toString());
        return true;
    }

    @Override
    public void onShowPress(MotionEvent event) {
        Log.d(TAG, "onShowPress: " + event.toString());
    }

    @Override
    public boolean onSingleTapUp(MotionEvent event) {
        Log.d(TAG, "onSingleTapUp: " + event.toString());
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent event) {
        Log.d(TAG, "onDoubleTap: " + event.toString());
        startActivity(new Intent(MainActivity.this, QuizActivity.class));
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent event) {
        Log.d(TAG, "onDoubleTapEvent: " + event.toString());
        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent event) {
        Log.d(TAG, "onSingleTapConfirmed: " + event.toString());
        return true;
    }
}


