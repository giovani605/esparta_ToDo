package com.example.giovani.todo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.giovani.todo.classes.VariaveisGlobais;

public class CriarAtividade_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_atividade_);
        // Get the Intent that started this activity and extract the string

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
       // TextView textView = findViewById(R.id.textView);
        //textView.setText(message);


    }

    public void salvarTarefa(View view) {
        TextView textView= (TextView)findViewById(R.id.textoTitulo);
        String titulo =  textView.getText().toString();
        VariaveisGlobais variaveisGlobais = VariaveisGlobais.getInstance();
        variaveisGlobais.getGerenciadorTarefas().criarTarefa(titulo);
        voltarMain(view);
    }
    public void voltarMain(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
