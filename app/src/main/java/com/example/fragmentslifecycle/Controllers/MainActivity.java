package com.example.fragmentslifecycle.Controllers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.fragmentslifecycle.Model.Item;
import com.example.fragmentslifecycle.ViewHelper.ItemArrayAdapter;
import com.example.fragmentslifecycle.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupView();
    }

    private void setupView(){
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.titlebar);
        textView = findViewById(R.id.action_bar_title);
        textView.setText(R.string.android_test);

        recyclerView = (RecyclerView) findViewById(R.id.item_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        // Initializing list view with the custom adapter
        ArrayList<Item> itemList = new ArrayList<>();
        // Populating list items
        ItemArrayAdapter itemArrayAdapter = new ItemArrayAdapter(R.layout.list_item, itemList);
        itemList.add(new Item(getString(R.string.test_lifecycle)));
        itemList.add(new Item(getString(R.string.test_fragment)));
        itemList.add(new Item(getString(R.string.test_intent)));
        recyclerView.setAdapter(itemArrayAdapter);
    }

}