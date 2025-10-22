package com.example.octandroid;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {
    RecyclerView rvList;
    List<MyListData> myListData;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recycler_view);
        rvList = findViewById(R.id.rvlist);
        myListData = new ArrayList<>();
        myListData.add(new MyListData("Apple","Macbook",R.drawable.onboardone));
        myListData.add(new MyListData("Samsung","Galaxy",R.drawable.onboardone));
        myListData.add(new MyListData("Apple","Macbook",R.drawable.onboardone));
        myListData.add(new MyListData("Samsung","Galaxy",R.drawable.onboardone));
        myListData.add(new MyListData("Apple","Macbook",R.drawable.onboardone));

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(myListData);
        rvList.setHasFixedSize(true);
       // rvList.setLayoutManager(new GridLayoutManager(this, 2));
       // rvList.setLayoutManager(new LinearLayoutManager(this));
        rvList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        rvList.setAdapter(adapter);



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}