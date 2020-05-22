package com.myapplicationdev.android.lp2_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ModifyActivity extends AppCompatActivity {
    Button btnUpdate, btnDelete;
    EditText etContent;
    ToDo data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify);

        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        etContent = findViewById(R.id.etContent);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(ModifyActivity.this);
                data.setData(etContent.getText().toString());
                dbh.updateToDo(data);
                dbh.close();

                if (etContent.getText().toString() == "") {
                    Toast.makeText(ModifyActivity.this, "Provide new data for update to current record",
                            Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(ModifyActivity.this, "Record updated",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(ModifyActivity.this);
                dbh.deleteToDo(data.getId());
                dbh.close();

                Toast.makeText(ModifyActivity.this, "Record deleted",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
