package com.example.a533.exercice_android_cours_13;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ToDoRecyclerAdapter extends RecyclerView.Adapter<ToDoRecyclerAdapter.MyViewHolder> {
    List<ToDo> toDoList;

    public ToDoRecyclerAdapter(List<ToDo> toDoList){
        this.toDoList = toDoList;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        TextView description;
        TextView dateAdded;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_title);
            description = itemView.findViewById(R.id.tv_description);
            dateAdded = itemView.findViewById(R.id.tv_dateAdded);
        }
    }


    @NonNull
    @Override
    public ToDoRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_card, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ToDoRecyclerAdapter.MyViewHolder holder, int position) {
        ToDo toDoDisplay = toDoList.get(position);
        holder.title.setText(toDoDisplay.getTitle());
        holder.description.setText(toDoDisplay.getDescription());
        holder.dateAdded.setText(toDoDisplay.getDateAdded().toString());
    }

    @Override
    public int getItemCount() {
        return toDoList.size();
    }
}
