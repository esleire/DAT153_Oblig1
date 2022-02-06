package utils;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.quizapp_oblig1.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingUtils {

    private List<Student> studentList;


    public SortingUtils(List<Student> studentList){
        this.studentList = studentList;


    }


    public void sortedAlphabetically(){

        Collections.sort(this.studentList, new Comparator<Student>() {

            @Override
            public int compare(Student s1, Student s2) {
                return s1.getName().compareTo(s2.getName());
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void sortReversedAlphabetically(){
        this.studentList.sort(Comparator.comparing(Student::getName, Comparator.reverseOrder()));
    }

    public List<Student> sortedList(){
        return this.studentList;
    }

}
