package com.example.quizapp_oblig1;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

import utils.SortingUtils;
import utils.Student;
import utils.StudentDAO;
import utils.StudentDatabase;

public class DatabaseActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    StudentDAO studentDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_students);


        recyclerView = findViewById(R.id.userRecyclerView);

        studentDAO = StudentDatabase.getDBInstance(this).studentDAO();
        StudentRecycler studentRecycler = new StudentRecycler(studentDAO.getAllUsers(), this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(studentRecycler);


    }

    public void sortAlphabetically(View v){

        studentDAO = StudentDatabase.getDBInstance(this).studentDAO();
        List<Student> studentList = studentDAO.getAllUsers();

        SortingUtils sort = new SortingUtils(studentList);
        sort.sortedAlphabetically();
        StudentRecycler studentRecycler = new StudentRecycler(sort.sortedList(), this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(studentRecycler);
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public void sortReversed(View v){
        studentDAO = StudentDatabase.getDBInstance(this).studentDAO();
        List<Student> studentList = studentDAO.getAllUsers();

        SortingUtils sort = new SortingUtils(studentList);
        sort.sortReversedAlphabetically();
        StudentRecycler studentRecycler = new StudentRecycler(sort.sortedList(), this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(studentRecycler);
    }

    public void addEntry(View v){
        startActivity(new Intent(DatabaseActivity.this, AddStudentActivity.class));
    }



    }



