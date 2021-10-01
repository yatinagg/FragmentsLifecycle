package com.example.fragmentslifecycle.Controllers;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fragmentslifecycle.Model.Student;
import com.example.fragmentslifecycle.R;

public class IntentDisplayActivity extends AppCompatActivity {

    private TextView textViewIntentDisplay;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_display);

        Student student = getIntent().getParcelableExtra("Student");
        textViewIntentDisplay = findViewById(R.id.textViewIntentDisplay);
        textViewIntentDisplay.setText(getString(R.string.intent_display, student.getName(), student.getAge(), student.getHeight(), student.getClas()));
    }
}
