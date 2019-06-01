package com.readapp.model;

import java.io.Serializable;

public class Book implements Serializable {

    private long idBook;
    private String mTitulo;
    private String mAutor;
    private String mEditora;
    private String mCategoria;
    private String mDtInicio;
    private String mDtFim;

    public Book() {
    }

    public Book(long idBook, String mTitulo, String mAutor, String mEditora, String mCategoria, String mDtInicio, String mDtFim) {
        this.idBook = idBook;
        this.mTitulo = mTitulo;
        this.mAutor = mAutor;
        this.mEditora = mEditora;
        this.mCategoria = mCategoria;
        this.mDtInicio = mDtInicio;
        this.mDtFim = mDtFim;
    }

    public Book(String mTitulo, String mAutor, String mEditora, String mCategoria, String mDtInicio, String mDtFim) {
        this.mTitulo = mTitulo;
        this.mAutor = mAutor;
        this.mEditora = mEditora;
        this.mCategoria = mCategoria;
        this.mDtInicio = mDtInicio;
        this.mDtFim = mDtFim;
    }

    public long getIdBook() {
        return idBook;
    }

    public void setIdBook(long idBook) {
        this.idBook = idBook;
    }

    public String getmTitulo() {
        return mTitulo;
    }

    public void setmTitulo(String mTitulo) {
        this.mTitulo = mTitulo;
    }

    public String getmAutor() {
        return mAutor;
    }

    public void setmAutor(String mAutor) {
        this.mAutor = mAutor;
    }

    public String getmEditora() {
        return mEditora;
    }

    public void setmEditora(String mEditora) {
        this.mEditora = mEditora;
    }

    public String getmCategoria() {
        return mCategoria;
    }

    public void setmCategoria(String mCategoria) {
        this.mCategoria = mCategoria;
    }

    public String getmDtInicio() {
        return mDtInicio;
    }

    public void setmDtInicio(String mDtInicio) {
        this.mDtInicio = mDtInicio;
    }

    public String getmDtFim() {
        return mDtFim;
    }

    public void setmDtFim(String mDtFim) {
        this.mDtFim = mDtFim;
    }
}
