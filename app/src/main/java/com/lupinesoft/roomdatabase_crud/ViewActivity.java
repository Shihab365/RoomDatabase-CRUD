package com.lupinesoft.roomdatabase_crud;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

public class ViewActivity extends AppCompatActivity {
    StudentViewModel studentViewModel;
    RecyclerView recyclerView;
    StudentRecyAdapter studentRecyAdapter;
    ImageView backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        recyclerView = findViewById(R.id.recyclerview_ID);
        backButton = findViewById(R.id.back_view_ButtonID);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ViewActivity.this, MainActivity.class));
            }
        });
        studentRecyAdapter = new StudentRecyAdapter(this);
        recyclerView.setAdapter(studentRecyAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        studentViewModel = ViewModelProviders.of(this).get(StudentViewModel.class);
        studentViewModel.getmAllInfos().observe(this, new Observer<List<StudentInfo>>() {
            @Override
            public void onChanged(@Nullable List<StudentInfo> infos) {
                studentRecyAdapter.setStudentInfos(infos);
            }
        });
    }
}
