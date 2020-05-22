package com.myapplicationdev.android.lp2_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class thirdActivity extends AppCompatActivity {
    Button btnUpdate, btnDelete;
    EditText etContent;
    ToDo data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        etContent = findViewById(R.id.etContent);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(thirdActivity.this);
                data.setNoteContent(etContent.getText().toString());
                dbh.updateToDo(data);
                dbh.close();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(thirdActivity.this);
                dbh.deleteToDo(data.getId());
                dbh.close();
            }
        });
    }
}
