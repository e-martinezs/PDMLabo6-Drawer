package com.example.pdmlabo6;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MenuItemAdapter extends RecyclerView.Adapter<MenuItemAdapter.MenuItemViewHolder>{

    private Context context;
    private List<MenuItem> list;

    public MenuItemAdapter(Context context){
        this.context = context;
        this.list = MainActivity.list;
    }

    @NonNull
    @Override
    public MenuItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.menu_item_layout, parent, false);
        return  new MenuItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuItemViewHolder holder, int position) {
        MenuItem item = list.get(position);
        holder.nameTextView.setText(item.getName());
        holder.descriptionTextView.setText(item.getDescription());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MenuItemViewHolder extends RecyclerView.ViewHolder{

        private TextView nameTextView;
        private TextView descriptionTextView;

        public MenuItemViewHolder(View view){
            super(view);
            nameTextView = view.findViewById(R.id.nameTextView);
            descriptionTextView = view.findViewById(R.id.descriptionTextView);
        }
    }
}
