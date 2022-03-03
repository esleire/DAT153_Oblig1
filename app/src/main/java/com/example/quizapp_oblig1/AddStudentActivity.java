package com.example.quizapp_oblig1;


import android.app.Activity;
import android.content.Intent;

import android.graphics.Bitmap;

import android.os.Bundle;

import android.provider.MediaStore;
import android.view.View;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;


import utils.DataConverter;
import utils.Student;
import utils.StudentDAO;
import utils.StudentDatabase;

public class AddStudentActivity extends AppCompatActivity {


    ImageView imageView;
    Bitmap bmpImage;
    EditText name;

    StudentDAO studentDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addstudent);


        name = findViewById(R.id.nameInput);
        bmpImage = null;
        imageView = findViewById(R.id.imageView);

        studentDAO = StudentDatabase.getDBInstance(this).studentDAO();



    }
    ActivityResultLauncher<Intent> takePictureResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {

                        Intent data = result.getData();

                        bmpImage = (Bitmap) data.getExtras().get("data");
                        imageView.setImageBitmap(bmpImage);
                    }
                }
            });

    public void takePicture(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        takePictureResultLauncher.launch(intent);
    }

    public void saveStudent(View view) {

        if(name.getText().toString().isEmpty() || bmpImage == null){
            Toast.makeText(this, "Missing some userdata",  Toast.LENGTH_SHORT).show();

        } else {
            Student student = new Student();
            student.setName(name.getText().toString());
            student.setImage(DataConverter.convertImage2Byte(bmpImage));
            studentDAO.insertUser(student);
            Toast.makeText(
                    this,
                    "Successfully saved",
                    Toast.LENGTH_SHORT).show();
            startActivity(new Intent(AddStudentActivity.this, MainActivity.class));

        }
    }

    }


