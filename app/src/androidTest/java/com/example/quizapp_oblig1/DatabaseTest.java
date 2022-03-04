package com.example.quizapp_oblig1;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import utils.DataConverter;
import utils.Student;
import utils.StudentDAO;
import utils.StudentDatabase;

@RunWith(AndroidJUnit4.class)
public class DatabaseTest {

    private StudentDAO studentDAO;
    Context context;

    @Before
    public void createDb(){
        context = ApplicationProvider.getApplicationContext();
        studentDAO = StudentDatabase.getDBInstance(context).studentDAO();
    }

    @Test
    public void insertIntoDatabase(){

        Student m = new Student();
        m.setName("Magnus");
        Bitmap magnus = BitmapFactory.decodeResource(context.getResources(), R.drawable.magnus);
        m.setImage(DataConverter.convertImage2Byte(magnus));
        int numberOfEntries = studentDAO.getAllUsers().size();

        studentDAO.insertUser(m);
        int actualNumberOfEnteries = studentDAO.getAllUsers().size();



        Assert.assertEquals(numberOfEntries + 1, actualNumberOfEnteries);


    }

    @Test
    public void getFromDatabase(){


    }

    @Test
    public void deleteFromDatabase(){

    }


}
