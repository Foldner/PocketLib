package me.foldner.libapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import me.foldner.libapp.BookPage;
import me.foldner.libapp.R;
import me.foldner.libapp.model.Book;

public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.BookViewHolder> {

    Context context;
    private ArrayList bookId, bookTitle, bookAuthor;

    public BookListAdapter(Context context, ArrayList book_id, ArrayList bookTitle, ArrayList bookAuthor) {
        this.context = context;
        this.bookId = book_id;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View bookItems = LayoutInflater.from(context).inflate(R.layout.book_row, parent, false);
        return new BookListAdapter.BookViewHolder(bookItems);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        holder.bookId.setText(String.valueOf(bookId.get(position)));
        holder.bookTitle.setText(String.valueOf(bookTitle.get(position)));
        holder.bookAuthor.setText(String.valueOf(bookAuthor.get(position)));
    }

    @Override
    public int getItemCount() {
        return bookId.size();
    }

    public static final class BookViewHolder extends RecyclerView.ViewHolder {

        TextView bookId, bookTitle, bookAuthor;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);

            bookId = itemView.findViewById(R.id.book_id);
            bookTitle = itemView.findViewById(R.id.book_title);
            bookAuthor = itemView.findViewById(R.id.book_author);
        }
    }
}
