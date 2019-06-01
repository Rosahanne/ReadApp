package com.readapp.bookDAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.readapp.model.Book;
import java.util.ArrayList;
import java.util.List;


public class BookDAO extends SQLiteOpenHelper {


    public BookDAO(Context context) {
        super(context, "ReadApp", null, 1);
    }

    // chamado quendo o BD é criado pela primeira vez
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table Book(" +
                "idBook INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "titulo TEXT not null," +
                "autor TEXT not null," +
                "editora TEXT not null," +
                "categoria TEXT not null," +
                "dtInicio TEXT," + 
                "dtFim TEXT)";
        db.execSQL(sql);
    }

    // chamado quendo o BD precisar ser atualizado
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public long inserir(Book book) {
        //Inserir registros com rocedimento de segureança
        ContentValues dados = getContentValues(book);
        SQLiteDatabase db = getWritableDatabase();
        return db.insert("Book", null, dados);}

    private ContentValues getContentValues(Book book) {
        ContentValues dados = new ContentValues();
        dados.put("titulo", book.getmTitulo());
        dados.put("autor", book.getmAutor());
        dados.put("editora", book.getmEditora());
        dados.put("categoria", book.getmCategoria());
        dados.put("dtInicio", book.getmDtInicio());
        dados.put("dtFim", book.getmDtFim());
        return dados;
    }

    public List<Book> BookList() {
        SQLiteDatabase db = getReadableDatabase();
        List<Book> BookList = new ArrayList<>();

        String sql = "SELECT 'idBook', * FROM Book";
        Cursor cursor = db.rawQuery(sql, null);

        while (((Cursor) cursor).moveToNext()) {
            long idBook = cursor.getLong(cursor.getColumnIndex("idBook"));
            String titulo = cursor.getString(cursor.getColumnIndex("titulo"));
            String autor = cursor.getString(cursor.getColumnIndex("autor"));
            String editora = cursor.getString(cursor.getColumnIndex("editora"));
            String categoria = cursor.getString(cursor.getColumnIndex("categoria"));
            String dtInicio = cursor.getString(cursor.getColumnIndex("dtInicio"));
            String dtFim = cursor.getString(cursor.getColumnIndex("dtFim"));

            Book book = new Book(idBook, titulo, autor, editora, categoria, dtInicio, dtFim );
            BookList.add(book);
        }
        return BookList;
    }

    public int editar(Book book) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = getContentValues(book);
        String selection = "idBook = ?";
        String[] args = {String.valueOf(book.getIdBook())};

        int resultado = db.update("Book", dados, selection, args);
        db.close();
        return resultado;
    }

    public int deletar(long idBook) {
        SQLiteDatabase db = getWritableDatabase();
        String selection = "idBook = ?";
        String[] args = {String.valueOf(idBook)};

        int resultado = db.delete("Book", selection, args);
        db.close();
        return resultado;

    }
}