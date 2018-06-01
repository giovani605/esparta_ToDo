package com.example.giovani.todo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.giovani.todo.classes.GerenciadorTarefas;
import com.example.giovani.todo.classes.ControladorListaView;
import com.example.giovani.todo.classes.VariaveisGlobais;

public class MainActivity extends AppCompatActivity {

    public static String EXTRA_MESSAGE = "Teste";
    VariaveisGlobais variaveisGlobais = VariaveisGlobais.getInstance();


    public void createDados(){
        variaveisGlobais.getGerenciadorTarefas().criarTarefa("Teste");

        variaveisGlobais.getGerenciadorTarefas().criarTarefa("Coisas");

        variaveisGlobais.getGerenciadorTarefas().criarTarefa("LOL");

        variaveisGlobais.getGerenciadorTarefas().criarTarefa("YOLO");
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
        ListView listaDeCursos = (ListView) findViewById(R.id.lista);
        variaveisGlobais = VariaveisGlobais.getInstance();
        GerenciadorTarefas gerenciadorTarefas = variaveisGlobais.getGerenciadorTarefas();
        // Array para o lsit view
        // renomear
        ControladorListaView listaViewMain = new ControladorListaView(gerenciadorTarefas.getTarefasAtuais(),
                this,R.layout.itemtodo,listaDeCursos);

        listaDeCursos.setAdapter(listaViewMain);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //createDados();
        setContentView(R.layout.activity_main);
        criarLista();

        // remover essa parte padrao


    }

        public void criarTarefa(View view) {
        Intent intent = new Intent(this, CriarAtividade_Activity.class);
        startActivity(intent);

        }
    public void verTarefasConcluidas(View view) {
        Intent intent = new Intent(this, ListarConcluidos_Activity.class);
        startActivity(intent);

    }



}
