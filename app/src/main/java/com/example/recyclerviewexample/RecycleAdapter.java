package com.example.recyclerviewexample;

import android.content.Context;
import android.content.Intent;
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
    private Context context;

    public RecycleAdapter(List<String> list, int[] images, Context context) {
        this.list = list;
        this.images = images;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.album_layout,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view,context,images,list);

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

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView versionLogo;
        TextView versionName;
        Context context;
        int[] images;
        List<String> list;
        public MyViewHolder(@NonNull View itemView,Context context,int[] images,List<String> list) {
            super(itemView);
            versionLogo = itemView.findViewById(R.id.image_view);
            versionName = itemView.findViewById(R.id.text_view);
            itemView.setOnClickListener(this);
            this.context =context;
            this.images =images;
            this.list = list;
        }

        @Override
        public void onClick(View view) {
            Intent intent= new Intent(context,DisplayActivity.class);
            intent.putExtra("image_id",images[getAdapterPosition()]);
            context.startActivity(intent);


        }
    }

}
