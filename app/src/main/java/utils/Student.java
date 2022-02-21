package utils;


public class Student {

    private String name;
    private int id;
    private boolean correctStudent;
    private String image;

    public Student(int id, String name, String image) {
        this.name = name;
        this.image = image;
        this.id = id;
        correctStudent = false;
    }
    public Student(String name, String image) {
        this.name = name;
        this.image = image;
        correctStudent = false;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", image=" + image +
                ", id=" + id +
                ", correctStudent=" + correctStudent +
                '}';
    }
}
