package utils;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface StudentDAO {
    @Query("Select * from Students")
    List<Student> getAllUsers();

    @Insert
    void insertUser(Student student);

    @Update
    void updateUser(Student student);

    @Delete
    void deleteUser(Student student);
}
