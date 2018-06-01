package com.example.giovani.todo.classes;

public class VariaveisGlobais {

    private static VariaveisGlobais variaveis;
    private  GerenciadorTarefas gerenciadorTarefas;

    public GerenciadorTarefas getGerenciadorTarefas() {
        return gerenciadorTarefas;
    }

    public void setGerenciadorTarefas(GerenciadorTarefas gerenciadorTarefas) {
        this.gerenciadorTarefas = gerenciadorTarefas;
    }

    public static VariaveisGlobais getInstance(){
        if(variaveis == null){
            variaveis = new VariaveisGlobais();
        }
        return variaveis;

    }
    private VariaveisGlobais(){
        gerenciadorTarefas = new GerenciadorTarefas();
    }


}
