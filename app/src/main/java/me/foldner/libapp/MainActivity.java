package me.foldner.libapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

import me.foldner.libapp.adapter.BookAdapter;
import me.foldner.libapp.model.Book;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper db;

    RecyclerView bookRecycler;
    BookAdapter bookAdapter;
    ImageButton adminNavigate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adminNavigate = (ImageButton) findViewById(R.id.adminNavigate3);

        adminNavigate.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, AdminPage.class);
            startActivity(intent);
        });

        db = new DatabaseHelper(this);
//        db.addBook("Гарри Поттер 1", "Джоан Роулинг");

        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book(1, "cover_harry_potter1", "Гарри Поттер 1", "Джоан Роулинг", "Классное описание"));
        bookList.add(new Book(2, "cover_harry_potter2", "Гарри Поттер 2", "Джоан Роулинг", "Классное описание"));
        bookList.add(new Book(3, "cover_harry_potter3", "Гарри Поттер 3", "Джоан Роулинг", "Классное описание"));
        bookList.add(new Book(4, "cover_harry_potter4", "Гарри Поттер 4", "Джоан Роулинг", "Классное описание"));
        bookList.add(new Book(5, "cover_harry_potter5", "Гарри Поттер 5", "Джоан Роулинг", "Классное описание"));
        bookList.add(new Book(6, "cover_harry_potter6", "Гарри Поттер 6", "Джоан Роулинг", "Классное описание"));
        bookList.add(new Book(6, "cover_harry_potter7", "Гарри Поттер 7", "Джоан Роулинг", "Классное описание"));

        setBookRecycler(bookList);
    }

    private void setBookRecycler(List<Book> bookList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        bookRecycler = findViewById(R.id.noveltiesRecycler);
        bookRecycler.setLayoutManager(layoutManager);

        bookAdapter = new BookAdapter(this, bookList);
        bookRecycler.setAdapter(bookAdapter);
    }
}