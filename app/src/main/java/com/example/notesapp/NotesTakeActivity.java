package com.example.notesapp;

import android.app.Activity;
import android.content.Intent;
import android.icu.text.CaseMap;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.notesapp.Model.Notes;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NotesTakeActivity extends AppCompatActivity {

    EditText titleED,notesEd;
    ImageView saveBtn;
    Notes notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_notes_take);

        saveBtn = findViewById(R.id.savebtn);
        titleED = findViewById(R.id.titleEdt);
        notesEd = findViewById(R.id.noteEdt);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notes = new Notes();
                String title = titleED.getText().toString();
                String description = notesEd.getText().toString();

                if (description.isEmpty()){
                    Toast.makeText(NotesTakeActivity.this, "Please Enter the Description", Toast.LENGTH_SHORT).show();
                    return;
                }
                SimpleDateFormat format = new SimpleDateFormat("EEE, dd MMM YYYY HH:mm a");
                Date date = new Date();

                notes.setTitle(title);
                notes.setNotes(description);
                notes.setDate(format.format(date));

                Intent intent = new Intent();
                intent.putExtra("note",notes);
                setResult(Activity.RESULT_OK,intent);
                finish();

            }
        });

    }
}