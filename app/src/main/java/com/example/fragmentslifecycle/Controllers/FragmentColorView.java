package com.example.fragmentslifecycle.Controllers;

import android.content.Context;
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


    private FragmentColorViewOnClicked mCallback;

    public interface FragmentColorViewOnClicked {
        void sendView(View view);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (FragmentColorViewOnClicked) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement TextClicked");
        }
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_color_view_layout, container, false);
        View view2 = view.findViewById(R.id.viewFragment2);
        mCallback.sendView(view2);
        return view;
    }

}