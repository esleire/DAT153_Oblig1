package utils;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Students")
public class Student {
    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name = "name")
    String name;

    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    byte [] image;

    boolean correctStudent;


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

    public byte [] getImage() {
        return image;
    }

    public void setImage(byte [] image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
