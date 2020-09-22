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

public class UpdateActivity extends AppCompatActivity {
    Button button;
    EditText editUpId, editUpName, editUpCgpa;
    StudentViewModel studentViewModel;
    ImageView backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        button = findViewById(R.id.button_studentinfo_update_ID);
        editUpId = findViewById(R.id.edit_Updateid_ID);
        editUpName = findViewById(R.id.edit_Updatename_ID);
        editUpCgpa = findViewById(R.id.edit_Updatecgpa_ID);
        backButton = findViewById(R.id.back_update_ButtonID);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UpdateActivity.this, MainActivity.class));
            }
        });

        studentViewModel = ViewModelProviders.of(this).get(StudentViewModel.class);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strID = editUpId.getText().toString();
                String strName = editUpName.getText().toString();
                String strCgpa = editUpCgpa.getText().toString();

                StudentInfo studentInfo = new StudentInfo(strID, strName, strCgpa);
                studentViewModel.updateStudentInfo(studentInfo);

                Toast.makeText(UpdateActivity.this, "Updated", Toast.LENGTH_SHORT).show();

                editUpId.setText("");
                editUpName.setText("");
                editUpCgpa.setText("");
            }
        });
    }
}
