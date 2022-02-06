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

import utils.Student;
import utils.StudentList;

public class DatabaseActivity extends AppCompatActivity {
    /*
       Metode som setter nytt view ved opprettelse av klassen
     */
    private StudentList studentList = new StudentList();

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        setUpdatedView();


        /**
         * Set listeners on sorting buttons
         */

        Button sortAlpha = findViewById(R.id.sortAlphabetically);
        sortAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                studentList.sortedAlphabetically();
                setUpdatedView();
            }
        });

        Button sortReversed = findViewById(R.id.sortReversed);
        sortReversed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                studentList.sortReversedAlphabetically();
                setUpdatedView();
            }
        });


        Button newEntry = findViewById(R.id.addNewButton);
        newEntry.setOnClickListener(view -> startActivity(new Intent(DatabaseActivity.this, AddStudentActivity.class)));



    }

    /**
     * Method for displaying the entries in the database view.
     * Will be called after sorting buttons is clicked
     */

    private void setUpdatedView(){
        List<Student> listOfStudents = studentList.getStudentList();
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
