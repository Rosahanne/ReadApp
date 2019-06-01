package com.readapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import java.util.List;
import androidx.appcompat.app.AppCompatActivity;
import com.readapp.BookDAO;
import com.readapp.bookAdapter.BookAdapter;
import com.readapp.bookDAO.BookDAO;
import com.readapp.model.Book;

public class MainActivity extends AppCompatActivity {

    private Fl fabAddBook;
    private ListView listViewBooks;
    private BookDAO bookDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewBooks=(findViewById(R.id.main_listViewBooks));
        fabAddBook=(findViewById(R.id.AddBook));

        fabAddBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FormCadActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume(){
        super.onResume();
        BookDAO bookDAO = new BookDAO(this);
        List<Book> bookList = ookDAO();
        BookAdapter adapterB = new BookAdapter(bookList, this);
        listViewBooks.setAdapter(adapterB);
    }


}}

