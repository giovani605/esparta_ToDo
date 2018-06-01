package com.example.giovani.todo.classes;

import android.view.View;

public class listenerBotao implements View.OnClickListener {
    private int tipo;
    private Tarefa tarefa;
    private ControladorListaView controladorListaView;

    public listenerBotao(int tipo,Tarefa tarefa,ControladorListaView controladorListaView){
        this.tipo = tipo;
        this.tarefa = tarefa;
        this.controladorListaView = controladorListaView;
    }
    
    @Override
    public void onClick(View v) {
        switch (this.tipo){
            case 0:
                concluir();
                break;
            case 1:
                reabrir();
                break;
            case 2:
                excluir();
                break;
        }
        this.controladorListaView.atualizar();
    }
    private void concluir() {
        VariaveisGlobais var = VariaveisGlobais.getInstance();
        GerenciadorTarefas gerenciadorTarefas = var.getGerenciadorTarefas();
        gerenciadorTarefas.concluirTarefa(tarefa.getId());


    }

    private void excluir() {
        VariaveisGlobais var = VariaveisGlobais.getInstance();
        GerenciadorTarefas gerenciadorTarefas = var.getGerenciadorTarefas();
        gerenciadorTarefas.excluirTarefa(tarefa.getId());
    }
    private void reabrir() {
        VariaveisGlobais var = VariaveisGlobais.getInstance();
        GerenciadorTarefas gerenciadorTarefas = var.getGerenciadorTarefas();
        gerenciadorTarefas.reabrirTarefa(tarefa.getId());
    }


}
