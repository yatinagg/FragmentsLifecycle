package com.example.fragmentslifecycle.Controllers;

import static android.app.PendingIntent.getActivity;

import static com.example.fragmentslifecycle.R.*;
import static com.example.fragmentslifecycle.R.id.gone;
import static com.example.fragmentslifecycle.R.id.layout_fragment_potrait;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.fragmentslifecycle.R;

public class FragmentActivity extends AppCompatActivity implements FragmentColorList.FragmentColorListOnClicked, FragmentColorView.FragmentColorViewOnClicked {

    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager;
    private String color = "WHITE";
    private String TAG = "check1";
    private boolean colorScreen = false;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setupView();
    }


    private void setupView() {
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(layout.titlebar);
        textView = findViewById(R.id.action_bar_title);
        textView.setText(string.fragment_test);


        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        // Replace whatever is in the fragment_container view with this fragment
        changeFragment(true,false,FragmentColorList.class,false);
    }

    @Override
    public void buttonClicked(String color) {
        this.color = color;
        int orientation = this.getResources().getConfiguration().orientation;

        fragmentTransaction = fragmentManager.beginTransaction();
        changeFragment(false,true, FragmentColorView.class,true);
    }

    @Override
    public void sendView(View view) {
        int clr = Color.parseColor(color);
        view.setBackgroundColor(clr);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Checks the orientation of the screen
        Log.d(TAG, "orientationChanged");

        fragmentTransaction = fragmentManager.beginTransaction();
        changeFragment(true,false, FragmentColorList.class,true);
    }

    @Override
    public void onBackPressed() {
        int orientation = this.getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT && colorScreen) {
            Log.d(TAG, "landscape");
            fragmentTransaction = fragmentManager.beginTransaction();
            setContentView(layout.activity_fragment);
            fragmentTransaction.replace(layout_fragment_potrait, FragmentColorList.class, null);
            fragmentTransaction.commit();
            colorScreen = false;
        }
        else{
            super.onBackPressed();
        }
    }

    private void changeFragment(boolean activityChange, boolean changeColor, Class className, boolean colorScr){
        int orientation = this.getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            if(activityChange)
                setContentView(layout.activity_fragment);
            colorScreen = colorScr;
            fragmentTransaction.replace(layout_fragment_potrait, className, null);
        } else {
            if(activityChange)
                setContentView(layout.activity_fragment_landscape);
            if(changeColor){
                Fragment fragment = fragmentManager.findFragmentById(id.layout_fr2);
                fragment.getView().setBackgroundColor(Color.parseColor(color));
            }
            fragmentTransaction.replace(R.id.layout_fr1, FragmentColorList.class, null);
            fragmentTransaction.replace(R.id.layout_fr2, FragmentColorView.class, null);
        }
        fragmentTransaction.commit();
    }
}