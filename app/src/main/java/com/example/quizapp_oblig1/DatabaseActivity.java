package com.example.quizapp_oblig1;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.Student;
import utils.StudentList;

public class DatabaseActivity extends AppCompatActivity {
    /*
       Metode som setter nytt view ved opprettelse av klassen
     */
    private StudentList studentList = new StudentList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
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
