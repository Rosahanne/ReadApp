package com.readapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import java.util.List;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.readapp.adapter.BookAdapter;
import com.readapp.model.Book;
import com.readapp.dao.BookDAO;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fabAddBook;
    private ListView listViewBooks;
    private BookDAO bookDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewBooks=(findViewById(R.id.main_listViewBooks));
        fabAddBook=(findViewById(R.id.fab_AddBook));

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
        List<Book> bookList = bookDAO.bookListFull();
        BookAdapter adapter = new BookAdapter(bookList, this);
        listViewBooks.setAdapter(adapter);
    }



}

