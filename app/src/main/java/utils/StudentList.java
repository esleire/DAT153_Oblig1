package utils;

import com.example.quizapp_oblig1.R;

import java.util.ArrayList;
import java.util.Arrays;

public class StudentList {

    private ArrayList<Student> studentList = new ArrayList<Student>();
    public StudentList(){

        Student magnus = new Student("Magnus", R.drawable.magnus);
        Student frede = new Student("Frede", R.drawable.frede);
        Student even = new Student("Even", R.drawable.even);

        studentList.addAll(Arrays.asList(new Student[] {magnus, frede, even}));
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void addStudent(Student s){
        this.studentList.add(s);
    }
}
