package com.example.quizapp_oblig1;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.RoomDatabase;

import java.util.List;

import utils.DataConverter;
import utils.Student;
import utils.StudentDAO;
import utils.StudentDatabase;

public class StudentRecycler extends RecyclerView.Adapter<StudentViewHolder> {

    List<Student> data;
    private StudentDAO database;
    private Activity context;

    public StudentRecycler(List<Student> users, Activity context){
        data = users;
        this.context = context;
    }


    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.student_item_layout,
                parent,
                false
        );
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int i) {
        Student student = data.get(i);
        database = StudentDatabase.getDBInstance(context).studentDAO();
        holder.imageView.setImageBitmap(DataConverter.convertByteArray2Image(student.getImage()));
        holder.name.setText(student.getName());

        holder.delete.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                database.deleteUser(student);

            }
        } );

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
