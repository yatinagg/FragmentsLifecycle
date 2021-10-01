package com.example.fragmentslifecycle.ViewHelper;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.fragmentslifecycle.Controllers.FragmentActivity;
import com.example.fragmentslifecycle.Controllers.IntentActivity;
import com.example.fragmentslifecycle.Controllers.LifecycleActivity;
import com.example.fragmentslifecycle.Model.Item;
import com.example.fragmentslifecycle.R;

import java.util.ArrayList;

public class ItemArrayAdapter extends RecyclerView.Adapter<ItemArrayAdapter.ViewHolder> {

    //All methods in this adapter are required for a bare minimum recyclerview adapter
    private int listItemLayout;
    private ArrayList<Item> itemList;
    // Constructor of the class
    public ItemArrayAdapter(int layoutId, ArrayList<Item> itemList) {
        listItemLayout = layoutId;
        this.itemList = itemList;
    }

    // get the size of the list
    @Override
    public int getItemCount() {
        return itemList == null ? 0 : itemList.size();
    }


    // specify the row layout file and click for each row
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(listItemLayout, parent, false);
        ViewHolder myViewHolder = new ViewHolder(view);
        return myViewHolder;
    }

    // load data in each row element
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int listPosition) {
        holder.bind(itemList.get(listPosition).getName(),listPosition);
    }


    // Static inner class to initialize the views of rows
    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final Context context;
        public TextView item;
        public ViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            itemView.setOnClickListener(this);
            item = itemView.findViewById(R.id.row_item);
        }
        @Override
        public void onClick(View view) {
            int adapPosition=getAdapterPosition();
            int layoutPosition = getLayoutPosition();
            Log.d("onclick", "onClick " + adapPosition +"lay : "+ layoutPosition + " " + item.getText());
            Intent intent = null;
            if(layoutPosition==0)
                intent = new Intent(context, LifecycleActivity.class);
            else if(layoutPosition==1)
                intent = new Intent(context, FragmentActivity.class);
            else if(layoutPosition==2)
                intent = new Intent(context, IntentActivity.class);
            context.startActivity(intent);
        }

        private void bind(String name, int position){
            item.setText(name);
        }
    }
}