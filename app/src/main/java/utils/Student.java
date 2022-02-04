package utils;

public class Student {

    private String name;
    private int image;
    private int id = 1;

    public Student(String name, int image) {
        this.name = name;
        this.image = image;
        generateId();
    }

    private void generateId(){
        this.setId(id);
        id++;

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
