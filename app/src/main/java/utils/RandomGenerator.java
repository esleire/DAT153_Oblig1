package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomGenerator {


    private List<Student> listOfStudents;
    private Student correctStudent;

    public RandomGenerator(List<Student> studentList){
        this.listOfStudents = studentList;

    }

    /**
     *
     * @return list that contains three options, one with the correct name.
     */
    public List<Student> generateOptions(){

        List<Student> returnOptionsList = new ArrayList<>();
        returnOptionsList.add(this.correctStudent);

        int indexCorrect = listOfStudents.indexOf(this.correctStudent);
        int index2 = 0;
        int index3 = 0;

        if(indexCorrect == listOfStudents.size() - 1){
            index2 = indexCorrect - 1;
            index3 = indexCorrect - 2;
        }

        else if(indexCorrect == 0){
            index2 = indexCorrect + 1;
            index3 = indexCorrect + 2;
        } else {
            index2 = indexCorrect + 1;
            index3 = indexCorrect - 1;
        }

        Student option2 = listOfStudents.get(index2);
        Student option3 = listOfStudents.get(index3);
        returnOptionsList.add(option2);
        returnOptionsList.add(option3);

        Collections.shuffle(returnOptionsList);
        return returnOptionsList;


    }

    public Student generateCorrectStudent(){

        this.correctStudent = listOfStudents.get(generateRandomIndex());
        this.correctStudent.setCorrectStudent(true);
        return this.correctStudent;

    }

    private int generateRandomIndex(){

        return 0 + (int)(Math.random() * ((listOfStudents.size() - 0)));

    }

    public List<Student> getListOfStudents() {
        return listOfStudents;
    }

}
