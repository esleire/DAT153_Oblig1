package utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.quizapp_oblig1.R;

@Database(
        entities = Student.class,
        version = 1,
        exportSchema = false
)
public abstract class StudentDatabase extends RoomDatabase {

    private static StudentDatabase studentDB = null;

    public abstract StudentDAO studentDAO();

    public static synchronized StudentDatabase getDBInstance(Context context){
        if(studentDB == null){
            studentDB = Room.databaseBuilder(
                    context.getApplicationContext(),
                    StudentDatabase.class,
                    "oblig2-quizapp"
            ).allowMainThreadQueries().build();


        }
        return studentDB;
    }
}
