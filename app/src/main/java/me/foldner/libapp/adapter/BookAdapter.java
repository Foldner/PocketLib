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

import java.util.List;

import me.foldner.libapp.BookPage;
import me.foldner.libapp.R;
import me.foldner.libapp.model.Book;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    Context context;
    List<Book> books;

    public BookAdapter(Context context, List<Book> books) {
        this.context = context;
        this.books = books;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View bookItems = LayoutInflater.from(context).inflate(R.layout.book_item, parent, false);
        return new BookAdapter.BookViewHolder(bookItems);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        int imageId = context.getResources().getIdentifier(books.get(position).getImg(), "drawable", context.getPackageName());
        holder.bookImage.setImageResource(imageId);

        holder.bookTitle.setText((books.get(position).getTitle()));
        holder.bookAuthor.setText((books.get(position).getAuthor()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, BookPage.class);

                intent.putExtra("bookCover", imageId);
                intent.putExtra("titleName", books.get(position).getTitle());
                intent.putExtra("authorName", books.get(position).getAuthor());
                intent.putExtra("description", books.get(position).getDescription());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public static final class BookViewHolder extends RecyclerView.ViewHolder {

        ImageView bookImage;
        TextView bookTitle, bookAuthor;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);

            bookTitle = itemView.findViewById(R.id.textTitle);
            bookAuthor = itemView.findViewById(R.id.textAuthor);
            bookImage = itemView.findViewById(R.id.imageCover);
        }
    }
}
