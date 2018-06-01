package com.example.giovani.todo.classes;

import java.util.ArrayList;

public class GerenciadorTarefas {
    ArrayList<Tarefa> tarefasAtuais = new ArrayList<>();
    ArrayList<Tarefa> tarefasConcluidas = new ArrayList<>();
    int cont = 0;

    public ArrayList<Tarefa> getTarefasAtuais() {
        return tarefasAtuais;
    }

    public void setTarefasAtuais(ArrayList<Tarefa> tarefasAtuais) {
        this.tarefasAtuais = tarefasAtuais;
    }

    public ArrayList<Tarefa> getTarefasConcluidas() {
        return tarefasConcluidas;
    }

    public void setTarefasConcluidas(ArrayList<Tarefa> tarefasConcluidas) {
        this.tarefasConcluidas = tarefasConcluidas;
    }

    public void criarTarefa(String titulo){
        Tarefa t = new Tarefa(this.cont,titulo);
        cont++;

        tarefasAtuais.add(t);
    }

    public Tarefa getTarefa(int id){
        for(Tarefa t : tarefasAtuais){
            if(t.getId() == id){
                return t;
            }
        }
        return null;
    }
    public Tarefa getTarefaTodas(int id){
        for(Tarefa t : tarefasAtuais){
            if(t.getId() == id){
                return t;
            }
        }
        for(Tarefa t : tarefasConcluidas){
            if(t.getId() == id){
                return t;
            }
        }
        return null;
    }


    public Tarefa getTarefaConcluida(int id){
        for(Tarefa t : tarefasConcluidas){
            if(t.getId() == id){
                return t;
            }
        }
        return null;
    }


    public void concluirTarefa(int id){
        Tarefa t = getTarefa(id);
        tarefasAtuais.remove(t);
        tarefasConcluidas.add(t);
    }
    public void reabrirTarefa(int id){
        Tarefa t = getTarefaConcluida(id);
        tarefasConcluidas.remove(t);
        tarefasAtuais.add(t);
    }

    // exclue a tarefa para sempre
    public void excluirTarefa(int id){
        Tarefa t = getTarefaTodas(id);
        tarefasAtuais.remove(t);
        tarefasConcluidas.remove(t);
    }
}
