package com.example.textbookmakert;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final ArrayList<Textbook> textbooks = new ArrayList<>();
    private TextbookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        adapter = new TextbookAdapter(textbooks);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        Button addBookButton = findViewById(R.id.btnAddBook);
        addBookButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddTextbookActivity.class);
            startActivityForResult(intent, 1);
        });

        SearchView searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            public boolean onQueryTextSubmit(String query) {
                adapter.filter(query);
                return false;
            }
            public boolean onQueryTextChange(String newText) {
                adapter.filter(newText);
                return false;
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            Textbook newBook = (Textbook) data.getSerializableExtra("newBook");
            if (!textbooks.contains(newBook)) {
                textbooks.add(newBook);
                adapter.notifyDataSetChanged();
            } else {
                Toast.makeText(this, "Duplicate book not added", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
