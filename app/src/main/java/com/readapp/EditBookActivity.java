package com.readapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.readapp.adapter.BookAdapter;
import com.readapp.dao.BookDAO;
import com.readapp.model.Book;
import com.readapp.helper.BookHelper;

public class EditBookActivity extends AppCompatActivity {

    private BookDAO bookDAO;
    private BookHelper helper;
    private TextView titEditBook;
    private Button btnEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_book);

        titEditBook = findViewById(R.id.tit_editBook);
        btnEditar = findViewById(R.id.btn_editar);
        helper = new BookHelper(this);
        bookDAO = new BookDAO(this);

        Intent intent = getIntent();
        Book book = (Book) intent.getSerializableExtra(BookAdapter.EDIT_GASTO);
        helper.preencheFormulario(book);

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = helper.getBook();

                if (bookDAO.editar(book) > 0) {
                    Toast.makeText(EditBookActivity.this,"Funcionou!", Toast.LENGTH_LONG).show();
                    finish();
                } else {
                    Toast.makeText(EditBookActivity.this,"Não funcionou!", Toast.LENGTH_LONG).show();
                }
            }
        });
        
    }
}