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
import utils.StudentDao;

public class AddStudentActivity extends AppCompatActivity {

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


         // Method for setting the picture choosen in the gallery.
        addPicture.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mGetContent.launch("image/*");
            }
        }));
        ImageView imageView = findViewById(R.id.imageView);



        // onClickListener for the save-button.

        addEntry.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameInput.getText().toString();
                int picture = R.drawable.default_pic;

                Student s = new Student(name, picture);
                StudentDao databaseHelper = new StudentDao(AddStudentActivity.this);

                // add student to DB
                // we only store img.id's of pictures that exists in R.drawable.
                // therefore we only set the default picture when adding a new entry.
                databaseHelper.addStudent(s);

                // Redirect back to main-menu after save
                startActivity(new Intent(AddStudentActivity.this, MainActivity.class));

            }
        }));


    }

    }


