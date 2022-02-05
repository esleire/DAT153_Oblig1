package utils;

public class Student {

    private String name;
    private int image;
    private int id = 1;
    private boolean correctStudent;

    public Student(String name, int image) {
        this.name = name;
        this.image = image;
        correctStudent = false;
        generateId();
    }

    private void generateId(){
        this.setId(id);
        id++;

    }

    public boolean getCorrectStudent(){
        return correctStudent;
    }

    public void setCorrectStudent(boolean correct){
        correctStudent = correct;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
