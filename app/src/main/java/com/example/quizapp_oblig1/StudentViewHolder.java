package com.example.quizapp_oblig1;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView name;

    public StudentViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.cardName);
        imageView = itemView.findViewById(R.id.cardImage);

    }
}
