package utils;

import java.util.List;

public class RandomGenerator {


    private List<Student> listOfStudents;

    public RandomGenerator(List<Student> studentList){
        this.listOfStudents = studentList;

    }


    public Student generateCorrectStudent(){

        Student correct = listOfStudents.get(generateRandomIndex());
        correct.setCorrectStudent(true);
        return correct;

    }

    private int generateRandomIndex(){

        return 0 + (int)(Math.random() * ((listOfStudents.size() - 0)));

    }

    public List<Student> getListOfStudents() {
        return listOfStudents;
    }

}
