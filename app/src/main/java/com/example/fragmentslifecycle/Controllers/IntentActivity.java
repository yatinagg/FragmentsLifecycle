package com.example.fragmentslifecycle.Controllers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fragmentslifecycle.Model.Student;
import com.example.fragmentslifecycle.R;

public class IntentActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextClass;
    private EditText editTextAge;
    private EditText editTextHeight;
    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        setupView();
        setupListener();
    }

    private void setupListener() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = editTextName.getText().toString();
                int clas = Integer.parseInt(editTextClass.getText().toString());
                int age = Integer.parseInt(editTextAge.getText().toString());
                float height = Float.parseFloat(editTextHeight.getText().toString());
                setContentView(R.layout.activity_intent_display);
                Intent intent = new Intent(getApplicationContext(), IntentDisplayActivity.class);
                Student student = new Student(name,clas,age,height);
                intent.putExtra("Student",student);
                startActivity(intent);
            }
        });
    }

    private void setupView(){
        button = findViewById(R.id.buttonIntent);
        editTextName = findViewById(R.id.editTextName);
        editTextAge = findViewById(R.id.editTextAge);
        editTextClass = findViewById(R.id.editTextClass);
        editTextHeight = findViewById(R.id.editTextHeight);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.titlebar);
        textView = findViewById(R.id.action_bar_title);
        textView.setText(R.string.intent_test);
    }
}
