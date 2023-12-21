package me.foldner.libapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import me.foldner.libapp.adapter.BookListAdapter;
import me.foldner.libapp.model.Book;

public class AdminPage extends AppCompatActivity {

    DatabaseHelper db;
    ArrayList<String> bookId, bookTitle, bookAuthor, bookDescription;

    BookListAdapter bookListAdapter;

    ImageButton catalogueNavigate;

    Button addBookButton;
    RecyclerView booksView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);

        catalogueNavigate = (ImageButton) findViewById(R.id.catalogueNavigate3);
        booksView = findViewById(R.id.booksView);
        addBookButton = findViewById(R.id.addBookButton);

        db = new DatabaseHelper(AdminPage.this);
        bookId = new ArrayList<>();
        bookTitle = new ArrayList<>();
        bookAuthor = new ArrayList<>();
        bookDescription = new ArrayList<>();

        catalogueNavigate.setOnClickListener(view -> {
            Intent intent = new Intent(AdminPage.this, MainActivity.class);
            startActivity(intent);
        });

        addBookButton.setOnClickListener(view -> {
            Intent intent = new Intent(AdminPage.this, AddBook.class);
            startActivity(intent);
        });

        displayData();

        bookListAdapter = new BookListAdapter(AdminPage.this, bookId, bookTitle, bookAuthor);
        booksView.setAdapter(bookListAdapter);
        booksView.setLayoutManager(new LinearLayoutManager(AdminPage.this));
    }

    void displayData() {
        Cursor cursor = db.readBookData();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "Книг нет", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                bookId.add(cursor.getString(0));
                bookTitle.add(cursor.getString(1));
                bookAuthor.add(cursor.getString(2));
                bookDescription.add(cursor.getString(3));
            }
        }
    }
}