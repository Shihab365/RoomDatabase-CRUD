package com.lupinesoft.roomdatabase_crud;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity {
    EditText editID, editName, editCGPA;
    Button buttonSave;
    StudentViewModel studentViewModel;
    ImageView backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        editID = findViewById(R.id.edit_studentid_ID);
        editName = findViewById(R.id.edit_studentname_ID);
        editCGPA = findViewById(R.id.edit_studentcgpa_ID);
        buttonSave = findViewById(R.id.button_studentinfo_insert_ID);
        backButton = findViewById(R.id.back_insert_ButtonID);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InsertActivity.this, MainActivity.class));
            }
        });

        studentViewModel = ViewModelProviders.of(this).get(StudentViewModel.class);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strID = editID.getText().toString();
                String strName = editName.getText().toString();
                String strCgpa = editCGPA.getText().toString();

                StudentInfo studentInfo = new StudentInfo(strID, strName, strCgpa);
                studentViewModel.insertStudentInfo(studentInfo);

                Toast.makeText(InsertActivity.this, "Saved", Toast.LENGTH_SHORT).show();

                editID.setText("");
                editName.setText("");
                editCGPA.setText("");
            }
        });
    }
}
