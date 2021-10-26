package com.example.laba_1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.laba_1.R;
import com.example.laba_1.dto.Book;

import java.util.List;

public class BooksListAdapter extends
        RecyclerView.Adapter<BooksListAdapter.ViewHolder>{

    private final LayoutInflater inflater;
    private final List<Book> books;

    public BooksListAdapter(LayoutInflater inflater, List<Book> books) {
        this.inflater = inflater;
        this.books = books;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.books_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Book book = books.get(position);
        holder.author.setText(book.Author);
        holder.bookTitle.setText(book.BookTitle);
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView author, bookTitle;
        ViewHolder(View view){
            super(view);
            author = view.findViewById((R.id.books_list__item_author));
            bookTitle = view.findViewById(R.id.books_list__item_book_title);
        }
    }
}
