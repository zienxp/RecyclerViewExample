package com.example.recyclerviewexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter <RecycleAdapter.MyViewHolder>{

    private List<String> list;
    private int[] images;

    public RecycleAdapter(List<String> list, int[] images) {
        this.list = list;
        this.images = images;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.album_layout,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.versionLogo.setImageResource(images[position]);
        holder.versionName.setText(list.get(position));


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView versionLogo;
        TextView versionName;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            versionLogo = itemView.findViewById(R.id.image_view);
            versionName = itemView.findViewById(R.id.text_view);
        }
    }

}
