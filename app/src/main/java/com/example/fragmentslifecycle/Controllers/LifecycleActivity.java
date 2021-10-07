package com.example.fragmentslifecycle.Controllers;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fragmentslifecycle.R;

public class LifecycleActivity extends AppCompatActivity {

    private String data;
    private Button button;
    private EditText editText;
    private TextView textView;
    private TextView textView1;
    private Button buttonDialog;
    private final String TAG = "test_2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "OnCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);

        setupView();
        setupListener();
    }

    private void setupView() {
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.titlebar);
        buttonDialog = findViewById(R.id.buttonDialog);
        textView1 = findViewById(R.id.action_bar_title);
        textView1.setText(R.string.lifecycle_test);

        button = findViewById(R.id.buttonLifecycle);
        editText = findViewById(R.id.editTextInput);
        textView = findViewById(R.id.textViewDisplay);
    }

    private void setupListener() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = editText.getText().toString();
                textView.setText(data);
            }
        });
        buttonDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = createAlertDialog("Dialog Box","Exit !","Yes","No");
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        textView.setText(savedInstanceState.getString("Text"));
        Log.d(TAG, "OnRestoreInstanceState");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("Text", editText.getText().toString());
        Log.d(TAG, "OnSaveInstanceState");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "OnStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "OnPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "OnResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "OnStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "OnRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "OnDestroy");
    }

    private AlertDialog.Builder createAlertDialog(String message, String title, String pos, String neg){
        AlertDialog.Builder builder = new AlertDialog.Builder(LifecycleActivity.this, R.style.MyDialogTheme);
        builder.setMessage(message);
        builder.setTitle(title);
        builder.setCancelable(false);

        builder.setPositiveButton(pos, (dialog, which) -> finish());
        builder.setNegativeButton(neg, (dialog, which) -> dialog.cancel());

        return builder;
    }
}
