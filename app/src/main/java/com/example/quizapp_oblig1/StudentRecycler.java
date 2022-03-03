package com.example.quizapp_oblig1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import utils.DataConverter;
import utils.Student;

public class StudentRecycler extends RecyclerView.Adapter<StudentViewHolder> {

    List<Student> data;

    public StudentRecycler(List<Student> users){
        data = users;
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
        holder.imageView.setImageBitmap(DataConverter.convertByteArray2Image(student.getImage()));
        holder.name.setText(student.getName());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
