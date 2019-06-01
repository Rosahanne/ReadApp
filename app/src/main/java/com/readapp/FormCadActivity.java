package com.readapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.readapp.bookAdapter.BookAdapter;
import com.readapp.bookDAO.BookDAO;
import com.readapp.model.Book;
import com.readapp.helper.BookHelper;

public class FormCadActivity extends AppCompatActivity {

    private BookDAO bookDAO;
    private BookHelper helper;
    private TextView titCadBook;
    private Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_cad);

        titCadBook = findViewById(R.id.tit_cadBook);
        btnSalvar = findViewById(R.id.btn_salvar);
        helper = new BookHelper(this);
        bookDAO = new BookDAO(this);



    }
}
