package me.foldner.libapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.MultiAutoCompleteTextView;

public class AddBook extends AppCompatActivity {

    EditText inputTitle, inputAuthor, inputDescription;
    ImageButton backButton;
    Button addBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        backButton = findViewById(R.id.backButton2);
        addBook = findViewById(R.id.addNewBook);

        inputTitle = findViewById(R.id.inputTitle);
        inputAuthor = findViewById(R.id.inputAuthor);
        inputDescription = findViewById(R.id.inputDescription);

        backButton.setOnClickListener(view -> {
            Intent intent = new Intent(AddBook.this, AdminPage.class);
            startActivity(intent);
        });
        addBook.setOnClickListener(view -> {
            DatabaseHelper db = new DatabaseHelper(AddBook.this);
            db.addBook(inputTitle.getText().toString().trim(),
                    inputAuthor.getText().toString().trim(),
                    inputDescription.getText().toString().trim());

            Intent intent = new Intent(AddBook.this, AdminPage.class);
            startActivity(intent);
        });
    }
}