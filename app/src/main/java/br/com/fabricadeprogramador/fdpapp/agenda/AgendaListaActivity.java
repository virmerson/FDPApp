package br.com.fabricadeprogramador.fdpapp.agenda;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.fabricadeprogramador.fdpapp.R;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Virmerson on 11/5/15.
 */
public class AgendaListaActivity extends AppCompatActivity{

    @Bind(R.id.lv_agenda)
    ListView lista;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agenda_lista);
        ButterKnife.bind(this);

        Intent i = getIntent();
        Bundle bundle = i.getExtras();
        String nome= bundle.getString("nome");

       GerenciadorAgenda.adicionar(nome);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, GerenciadorAgenda.getNomes());

       lista.setAdapter(adapter);

    }

    @OnClick(R.id.bt_fechar_agenda)
    public void fechar (){
        finish();
    }
}
