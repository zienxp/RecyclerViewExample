package com.example.recyclerviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<String> list;
    private RecycleAdapter adapter;
    private int[] images ={R.drawable.cupcake,R.drawable.donut,R.drawable.eclair,R.drawable.froyo,R.drawable.gingerbread,
            R.drawable.honeycomb,R.drawable.icecream_sandwich,R.drawable.jellybean,R.drawable.kitkat,R.drawable.lollipop,
            R.drawable.marshmallow,R.drawable.nogat,R.drawable.oreo,R.drawable.android};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        //get word list from Strings
        list = Arrays.asList(getResources().getStringArray(R.array.android_version));
        adapter = new RecycleAdapter(list,images);
        recyclerView.setAdapter(adapter);


    }
}
