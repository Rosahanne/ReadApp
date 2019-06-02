package com.readapp.bookAdapter;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.readapp.EditBookActivity;
import com.readapp.MainActivity;
import com.readapp.bookDAO.BookDAO;
import com.readapp.model.Book;
import com.readapp.R;





public class BookAdapter extends BaseAdapter {

    public static final double LINHA_AFETADA = 1;
    public static final String EDIT_GASTO = "EditarDado";
    private BookDAO bookDAO;
    private final List<Book> bookList;
    private final Activity act;


    public BookAdapter(List<Book> bookList, Activity act) {
        this.bookList = bookList;
        this.act = act;
    }

    public BookAdapter(List<Book> bookList, MainActivity mainActivity){
        this.bookList = bookList;
        this.act = mainActivity;
    }

    @Override
    public int getCount() {
        return bookList.size();
    }

    @Override
    public Object getItem(int position) {
        return bookList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return bookList.get(position).getIdBook();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = act.getLayoutInflater()
                .inflate(R.layout.activity_list_view, parent, false);
        bookDAO = new BookDAO(act);

        TextView titulo = (TextView)
                view.findViewById(R.id.textView_Titulo);
        TextView autor = (TextView)
                view.findViewById(R.id.textView_Autor);
        TextView editora = (TextView)
                view.findViewById(R.id.textView_Editora);
        TextView categoria = (TextView)
                view.findViewById(R.id.textView_Categoria);
        TextView dtInicio = (TextView)
                view.findViewById(R.id.textView_DtInicio);
        TextView dtFim = (TextView)
                view.findViewById(R.id.textView_DtFim);

        FloatingActionButton fabExcBook = view.findViewById(R.id.list_ExcBook);
        FloatingActionButton fabEditBook = view.findViewById(R.id.list_EditBook);

        final Book book = bookList.get(position);
        titulo.setText(book.getmTitulo());
        autor.setText(book.getmAutor());
        editora.setText(book.getmEditora());
        categoria.setText(book.getmCategoria());
        dtInicio.setText(book.getmDtInicio());
        dtFim.setText(book.getmDtFim());
        


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(act, EditBookActivity.class);
                intent.putExtra("EditarDado", bookList.get(position));
                act.startActivity(intent);

            }
        });

        fabEditBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(act, EditBookActivity.class);
                intent.putExtra("EditarDado", bookList.get(position));
                act.startActivity(intent);
            }
        });


        fabExcBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bookDAO.deletar(getItemId(position)) == LINHA_AFETADA) {
                    Toast.makeText(act,"Funcionou!", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(act,"Não funcionou!", Toast.LENGTH_LONG).show();
                }
            }
        });
        return view;
    }




}
