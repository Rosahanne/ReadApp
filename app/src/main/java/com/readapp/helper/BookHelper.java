package com.readapp.helper;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import java.util.Arrays;
import java.util.List;
import com.readapp.EditBookActivity;
import com.readapp.model.Book;
import com.readapp.R;
import com.readapp.FormCadActivity;

public class BookHelper {

    private long idBook;
    private EditText edit_titulo;
    private EditText edit_autor;
    private EditText edit_editora;
    private Spinner sp_categoria;
    private EditText edit_dtInicio;
    private EditText edit_dtFim;
    private Book book;
    private Context activity;

    public BookHelper(FormCadActivity activity) {
        this.activity = activity;
        carregaCampos(activity);
        carregaSpinner(activity);
    }

    public void carregaCampos(FormCadActivity activity) {
        this.activity = activity;
        edit_titulo = activity.findViewById(R.id.txt_titulo);
        edit_autor = activity.findViewById(R.id.txt_autor);
        edit_editora = activity.findViewById(R.id.txt_editora);
        sp_categoria = activity.findViewById(R.id.spinner_categoria);
        edit_dtInicio = activity.findViewById(R.id.txt_dtInicio);
        edit_dtFim = activity.findViewById(R.id.txt_dtFim);
    }

    public BookHelper(EditBookActivity activity) {
        carregaCampos(activity);
        carregaSpinner(activity);
    }

    public void carregaCampos(EditBookActivity activity) {
        edit_titulo = activity.findViewById(R.id.txt_titulo);
        edit_autor = activity.findViewById(R.id.txt_autor);
        edit_editora = activity.findViewById(R.id.txt_editora);
        sp_categoria = activity.findViewById(R.id.spinner_categoria);
        edit_dtInicio = activity.findViewById(R.id.txt_dtInicio);
        edit_dtFim = activity.findViewById(R.id.txt_dtFim);
    }

    public Book getBook() {
        String titulo = edit_titulo.getText().toString();
        String autor = edit_autor.getText().toString();
        String editora = edit_editora.getText().toString();
        String categoria = sp_categoria.getSelectedItem().toString();
        String dataInicio = edit_dtInicio.getText().toString();
        String dataFim = edit_dtFim.getText().toString();
        
        if (book != null) {
            return new Book(book.getIdBook(), titulo, autor, editora, categoria, dataInicio, dataFim);
        }
        return new Book(titulo, autor, editora, categoria, dataInicio, dataFim);
    }


    public void preencheFormulario(Book book){
        this.book = book;
        edit_titulo.setText(book.getmTitulo());
        edit_autor.setText(book.getmAutor());
        edit_editora.setText(book.getmEditora());
        sp_categoria.setSelection(pegaIndexdaCategoria(book.getmCategoria()));
        edit_dtInicio.setText(book.getmDtInicio());
        edit_dtFim.setText(book.getmDtInicio());
    }

    private void carregaSpinner(EditBookActivity activity){
        sp_categoria = activity.findViewById(R.id.spinner_categoria);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
                (activity,R.array.CategoriaList,android.R.layout.simple_spinner_item);
                sp_categoria.setAdapter(adapter);
    }

    private void carregaSpinner(FormCadActivity activity){
        sp_categoria = activity.findViewById(R.id.spinner_categoria);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
                (activity,R.array.CategoriaList,android.R.layout.simple_spinner_item);
                sp_categoria.setAdapter(adapter);
    }

    private int pegaIndexdaCategoria(String categoria){
        String [] arrayCategoria =  activity.getResources().getStringArray(R.array.CategoriaList);
        List<String> CategoriaList = Arrays.asList(arrayCategoria);
        return  ((List) CategoriaList).indexOf(categoria);
    }

}
