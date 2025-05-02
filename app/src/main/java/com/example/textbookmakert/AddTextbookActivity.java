package com.example.textbookmakert;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class AddTextbookActivity extends AppCompatActivity {
    EditText titleInput, sellerInput, copiesInput, priceInput, bankInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_textbook);

        titleInput = findViewById(R.id.etTitle);
        sellerInput = findViewById(R.id.etSeller);
        copiesInput = findViewById(R.id.etCopies);
        priceInput = findViewById(R.id.etPrice);
        bankInput = findViewById(R.id.etBank);

        Button submitBtn = findViewById(R.id.btnSubmit);
        submitBtn.setOnClickListener(v -> {
            String title = titleInput.getText().toString();
            String seller = sellerInput.getText().toString();
            int copies = Integer.parseInt(copiesInput.getText().toString());
            double price = Double.parseDouble(priceInput.getText().toString());
            String bank = bankInput.getText().toString();

            Textbook newBook = new Textbook(title, seller, copies, price, bank);
            Intent result = new Intent();
            result.putExtra("newBook", newBook);
            setResult(RESULT_OK, result);
            finish();
        });
    }
}
