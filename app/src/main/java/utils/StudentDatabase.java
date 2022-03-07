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
                    "oblig2-quiz"
            ).allowMainThreadQueries().build();

            Student e = new Student();

            e.setName("Even");
            Bitmap even = BitmapFactory.decodeResource(context.getResources(), R.drawable.even);
            e.setImage(DataConverter.convertImage2Byte(even));

            studentDB.studentDAO().insertUser(e);

            Student m = new Student();

            m.setName("Magnus");
            Bitmap magnus = BitmapFactory.decodeResource(context.getResources(), R.drawable.magnus);
            m.setImage(DataConverter.convertImage2Byte(magnus));

            studentDB.studentDAO().insertUser(m);

            Student f = new Student();

            f.setName("Frede");
            Bitmap frede = BitmapFactory.decodeResource(context.getResources(), R.drawable.frede);
            f.setImage(DataConverter.convertImage2Byte(frede));

            studentDB.studentDAO().insertUser(f);
        }
        return studentDB;
    }
}
