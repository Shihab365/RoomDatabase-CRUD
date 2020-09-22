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

public class DeleteActivity extends AppCompatActivity {
    StudentViewModel studentViewModel;
    EditText editText;
    Button button;
    ImageView backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        editText = findViewById(R.id.edit_DeleteId_ID);
        button = findViewById(R.id.button_studentinfo_delete_ID);
        backButton = findViewById(R.id.back_delete_ButtonID);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DeleteActivity.this, MainActivity.class));
            }
        });

        studentViewModel = ViewModelProviders.of(this).get(StudentViewModel.class);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strID = editText.getText().toString();

                StudentInfo studentInfo = new StudentInfo(strID,"","");
                studentViewModel.deleteStudentInfo(studentInfo);

                Toast.makeText(DeleteActivity.this, "Deleted", Toast.LENGTH_SHORT).show();

                editText.setText("");
            }
        });
    }
}
