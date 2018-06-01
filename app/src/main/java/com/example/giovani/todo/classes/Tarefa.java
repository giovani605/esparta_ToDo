package com.example.giovani.todo.classes;

import android.view.View;
import android.widget.GridLayout;

import com.example.giovani.todo.R;

public class Tarefa {
    private int id;
    private String titulo;
    private int status;
    // 1 - ativa
    // 2 - concluida
    public Tarefa(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
        this.status =1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    private String descricao;


}
