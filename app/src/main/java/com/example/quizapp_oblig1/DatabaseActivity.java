package com.example.quizapp_oblig1;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import utils.SortingUtils;
import utils.Student;
import utils.StudentDao;

public class DatabaseActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);


        // Getting student-list from DB
        StudentDao databaseHelper = new StudentDao(DatabaseActivity.this);
        List<Student> studentList = databaseHelper.getAllStudents();

        setUpdatedView(studentList);

        // Setting onClickListeners on the sorting buttons in database-view.
        Button sortAlpha = findViewById(R.id.sortAlphabetically);
        sortAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // SortingUtils will take in the student list and have
                // different sorting functions.
                SortingUtils sort = new SortingUtils(studentList);
                sort.sortedAlphabetically();
                setUpdatedView(sort.sortedList());
            }
        });

        Button sortReversed = findViewById(R.id.sortReversed);
        sortReversed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SortingUtils sort = new SortingUtils(studentList);
                sort.sortReversedAlphabetically();
                setUpdatedView(sort.sortedList());
            }
        });


        Button newEntry = findViewById(R.id.addNewButton);
        newEntry.setOnClickListener(view -> startActivity(new Intent(DatabaseActivity.this, AddStudentActivity.class)));



    }

    /**
     * Method for displaying the entries in the database view.
     * Will be called after sorting buttons is clicked
     */

    private void setUpdatedView(List<Student> listOfStudents){

        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (Student s : listOfStudents) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("listview_title", s.getName());
            hm.put("listview_image", Integer.toString(s.getImage()));
            aList.add(hm);
        }


        String [] from = {"listview_title", "listview_image"};
        int [] to = {R.id.listview_item_title, R.id.listview_image};
        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.activity_database, from, to);

        ListView androidListView = findViewById(R.id.list_view);
        androidListView.setAdapter(simpleAdapter);
    }

}
