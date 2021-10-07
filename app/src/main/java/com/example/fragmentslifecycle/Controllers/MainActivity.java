package com.example.fragmentslifecycle.Controllers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.fragmentslifecycle.Model.Item;
import com.example.fragmentslifecycle.ViewHelper.ItemArrayAdapter;
import com.example.fragmentslifecycle.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnButtonClickListener {

    private RecyclerView recyclerView;
    private TextView textView;
    private final String TAG = "test_1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "OnCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupView();
    }

    private void setupView() {
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.titlebar);
        textView = findViewById(R.id.action_bar_title);
        textView.setText(R.string.android_test);

        recyclerView = (RecyclerView) findViewById(R.id.item_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setItemAnimator(new DefaultItemAnimator());
        // Initializing list view with the custom adapter
        ArrayList<Item> itemList = new ArrayList<>();
        // Populating list items
        ItemArrayAdapter itemArrayAdapter = new ItemArrayAdapter(R.layout.list_item, itemList,this);
        itemList.add(new Item(getString(R.string.test_lifecycle)));
        itemList.add(new Item(getString(R.string.test_fragment)));
        itemList.add(new Item(getString(R.string.test_intent)));
        recyclerView.setAdapter(itemArrayAdapter);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "OnRestoreInstanceState");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
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

    @Override
    public void onButtonClick(int position) {
        Intent intent = null;
        if (position == 0)
            intent = new Intent(this, LifecycleActivity.class);
        else if (position == 1)
            intent = new Intent(this, FragmentActivity.class);
        else
            intent = new Intent(this, IntentActivity.class);
        this.startActivity(intent);
    }
}