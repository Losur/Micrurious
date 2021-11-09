package com.example.laba_1.activity.ui.books_list;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.laba_1.R;
import com.example.laba_1.ViewModel.ApiRequestController;
import com.example.laba_1.adapter.BooksListAdapter;
import com.example.laba_1.databinding.FragmentBooksListBinding;
import com.example.laba_1.dto.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BooksListFragment extends Fragment {

    private FragmentBooksListBinding binding;
    private List<Book> books = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentBooksListBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        String[] a = getResources().getStringArray(R.array.authors);
        List<String> recyclerData = Arrays.asList(a);
        for (int i = 0; i < recyclerData.size(); i+=2) {
            Book b = new Book();
            b.Author = recyclerData.get(i);
            b.Name = recyclerData.get(i + 1);
            books.add(b);
        }

        BooksListAdapter adapter = new BooksListAdapter(this.getLayoutInflater(), books);
        RecyclerView recyclerView = binding.booksListRecycler;
        recyclerView.setAdapter(adapter);

        ApiRequestController controller = new ApiRequestController();
        controller.start();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}