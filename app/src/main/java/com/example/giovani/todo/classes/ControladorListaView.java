package com.example.giovani.todo.classes;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.giovani.todo.R;

import java.util.ArrayList;

public class ControladorListaView extends BaseAdapter{

    private ArrayList<Tarefa> tarefas = new ArrayList<>();
    private Activity act;
    private int layout;

    public ArrayList<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(ArrayList<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    public Activity getAct() {
        return act;
    }

    public void setAct(Activity act) {
        this.act = act;
    }

    public int getLayout() {
        return layout;
    }

    public void setLayout(int layout) {
        this.layout = layout;
    }

    public ListView getListaDeCursos() {
        return listaDeCursos;
    }

    public void setListaDeCursos(ListView listaDeCursos) {
        this.listaDeCursos = listaDeCursos;
    }

    private ListView listaDeCursos;
    public ControladorListaView(ArrayList<Tarefa> lista, Activity act, int layout, ListView listaDeCursos){
        this.tarefas = lista;
        this.act = act;
        this.layout = layout;
        this.listaDeCursos = listaDeCursos;
    }

    @Override
    public int getCount() {
        return tarefas.size();
    }

    @Override
    public Object getItem(int position) {
        return tarefas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return tarefas.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = act.getLayoutInflater()
                .inflate(this.layout, parent, false);
        Tarefa t = this.tarefas.get(position);


        TextView nome = (TextView)
                view.findViewById(R.id.itemTexto);
        if (nome != null){
            nome.setText(t.getTitulo());
    }

        TextView nome2 = (TextView)
                view.findViewById(R.id.itemTextoConcluido);
        if (nome2 != null){
            nome2.setText(t.getTitulo());
        }
        // ver como fazer o botao
        Button botaoConcluir = (Button)
                view.findViewById(R.id.botaoTexto);
        if( botaoConcluir != null) {
            botaoConcluir.setOnClickListener(new listenerBotao(0,t,this));
        }
        Button botaoReabrir = (Button)
                view.findViewById(R.id.botaoReabrir);
        if( botaoReabrir != null) {
            botaoReabrir.setOnClickListener(new listenerBotao(1,t,this));
        }
        Button botaoexcluir = (Button)
                view.findViewById(R.id.botaoExcluir);
        if( botaoexcluir != null) {
            botaoexcluir.setOnClickListener(new listenerBotao(2,t,this));
        }

        return view;
    }


    public void atualizar() {
        this.listaDeCursos.setAdapter(this);
    }
}
