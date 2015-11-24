package br.com.fabricadeprogramador.fdpapp.agenda;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import br.com.fabricadeprogramador.fdpapp.R;
import br.com.fabricadeprogramador.fdpapp.agenda.adapter.PessoaListAdapter;
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
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Instanciando objeto para salvar no banco
        BancoDeDados banco = new BancoDeDados(this);
        //Listar as pessoas
        PessoaListAdapter adapter = new PessoaListAdapter(this,banco.buscarTodos());

        lista.setAdapter(adapter);
    }

    @OnClick(R.id.bt_novo)
    public void novo(){
        Intent irParaForm = new Intent(this, AgendaActivity.class);

        startActivity(irParaForm);
    }
}