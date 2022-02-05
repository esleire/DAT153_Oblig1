package utils;

import android.content.Intent;

import com.example.quizapp_oblig1.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentList implements Serializable {

    private List<Student> studentList = new ArrayList<>();
    Intent myIntent = new Intent();

    public StudentList(){

        Student magnus = new Student("Magnus", R.drawable.magnus);
        Student frede = new Student("Frede", R.drawable.frede);
        Student even = new Student("Even", R.drawable.even);

        studentList.addAll(Arrays.asList(new Student[] {magnus, frede, even}));
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void addStudent(Student s){
        this.studentList.add(s);
    }
}
