package com.example.giovani.todo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.giovani.todo.classes.ControladorListaView;
import com.example.giovani.todo.classes.GerenciadorTarefas;
import com.example.giovani.todo.classes.VariaveisGlobais;

public class ListarConcluidos_Activity extends AppCompatActivity {

    VariaveisGlobais variaveisGlobais = VariaveisGlobais.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_concluidos_);
        criarLista();

    }


    @Override
    protected void onRestart() {
        super.onRestart();
        criarLista();
    }

    @Override
    protected void onResume() {
        super.onResume();
        criarLista();
    }

    private void criarLista(){
        ListView listaDeCursos = (ListView) findViewById(R.id.listaConcluidos);
        variaveisGlobais = VariaveisGlobais.getInstance();
        GerenciadorTarefas gerenciadorTarefas = variaveisGlobais.getGerenciadorTarefas();
        // Array para o lsit view
        // renomear
        ControladorListaView listaViewMain = new ControladorListaView(gerenciadorTarefas.getTarefasConcluidas(),
                this,R.layout.itemtodoconcluido, listaDeCursos);

        listaDeCursos.setAdapter(listaViewMain);

    }
    public void voltarMain(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}
