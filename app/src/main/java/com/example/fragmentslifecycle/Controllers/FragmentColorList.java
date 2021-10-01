package com.example.fragmentslifecycle.Controllers;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fragmentslifecycle.R;

public class FragmentColorList extends Fragment {

    private Button buttonRed;
    private Button buttonBlue;
    private Button buttonGreen;
    private Button buttonYellow;
    private Button buttonOrange;

    private FragmentColorListOnClicked mCallback;

    public interface FragmentColorListOnClicked {
        void buttonClicked(String color);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (FragmentColorListOnClicked) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement TextClicked");
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_color_list_layout, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        buttonRed = view.findViewById(R.id.buttonRed);
        buttonBlue = view.findViewById(R.id.buttonBlue);
        buttonGreen = view.findViewById(R.id.buttonGreen);
        buttonYellow = view.findViewById(R.id.buttonYellow);
        buttonOrange = view.findViewById(R.id.buttonOrange);

        buttonRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("hello", "red");
                mCallback.buttonClicked("red");
            }
        });

        buttonBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCallback.buttonClicked("blue");
            }
        });

        buttonGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCallback.buttonClicked("green");
            }
        });

        buttonYellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCallback.buttonClicked("yellow");
            }
        });

        buttonOrange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCallback.buttonClicked("#FFA500");
            }
        });
    }
}