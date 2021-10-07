package com.example.fragmentslifecycle.Controllers;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fragmentslifecycle.R;

public class FragmentColorView extends Fragment {

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_color_view_layout, container, false);
        Bundle arguments = getArguments();
        String color = arguments.getString("color");
        System.out.println("col : " + color);
        view.setBackgroundColor(Color.parseColor(color));

        return view;
    }

}