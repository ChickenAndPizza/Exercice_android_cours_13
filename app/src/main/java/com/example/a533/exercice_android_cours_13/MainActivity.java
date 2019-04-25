package com.example.a533.exercice_android_cours_13;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    final Context context = this;
    List<ToDo> toDoList = new ArrayList<>();

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView_toDo);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new ToDoRecyclerAdapter(toDoList);
        recyclerView.setAdapter(adapter);

        SetListeners();
    }

    private void SetListeners(){

        findViewById(R.id.btn_dialogToDo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.create_dialog);
                Button dialogButton = dialog.findViewById(R.id.btn_addToDo);

                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText txtToDoTitle = dialog.findViewById(R.id.txt_title);
                        EditText txtToDoDescription = dialog.findViewById(R.id.txt_description);
                        ToDo toDo = new ToDo(new Date(), txtToDoTitle.getText().toString(), txtToDoDescription.getText().toString());
                        toDoList.add(toDo);
                        adapter.notifyDataSetChanged();
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

    }
}
