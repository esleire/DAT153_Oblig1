package com.example.quizapp_oblig1;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;


import utils.Student;
import utils.StudentList;

public class AddStudentActivity extends AppCompatActivity {

    private StudentList studentList = new StudentList();


    /*
       Metode som setter nytt view ved opprettelse av klassen
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addstudent);


        Button addPicture = findViewById(R.id.addImage);
        Button addEntry = findViewById(R.id.addEntryButton);
        EditText nameInput = findViewById(R.id.nameInput);

        ActivityResultLauncher<String> mGetContent = registerForActivityResult(new ActivityResultContracts.GetContent(),
                new ActivityResultCallback<Uri>() {
                    @Override
                    public void onActivityResult(Uri uri) {
                        // Handle the returned Uri
                        ImageView imageView = findViewById(R.id.imageView);
                        imageView.setImageURI(uri);

                    }
                });



        addPicture.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mGetContent.launch("image/*");
            }
        }));
        ImageView imageView = findViewById(R.id.imageView);



        addEntry.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameInput.getText().toString();
                int picture = imageView.getDrawable().getAlpha();

                if(picture == 0){
                    picture = R.drawable.default_pic;
                }

                Student s = new Student(name, picture);
                studentList.addStudent(s);
                startActivity(new Intent(AddStudentActivity.this, MainActivity.class));

            }
        }));


    }

    }


