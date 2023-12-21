package me.foldner.libapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class BookPage extends AppCompatActivity {

    ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_page);

        backButton = (ImageButton) findViewById(R.id.backButton);

        backButton.setOnClickListener(view -> {
            Intent intent = new Intent(BookPage.this, MainActivity.class);
            startActivity(intent);
        });

        ImageView bookCover = findViewById(R.id.bookCoverImage);
        TextView bookTitle = findViewById(R.id.textTitleName);
        TextView bookAuthor = findViewById(R.id.textAuthorName);
        TextView bookDescription = findViewById(R.id.textDescriptionContent);

        bookCover.setImageResource(getIntent().getIntExtra("bookCover", 0));
        bookTitle.setText(getIntent().getStringExtra("titleName"));
        bookAuthor.setText(getIntent().getStringExtra("authorName"));
        bookDescription.setText(getIntent().getStringExtra("description"));
    }
}