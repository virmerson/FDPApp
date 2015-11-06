package br.com.fabricadeprogramador.fdpapp.agenda;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import br.com.fabricadeprogramador.fdpapp.R;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Virmerson on 11/5/15.
 */
public class AgendaActivity extends AppCompatActivity{



    @Bind(R.id.ed_nome)
    EditText edNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agenda);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bt_salvar)
    public void salvar(){
        String nome = edNome.getText().toString();

        Intent irParaAgendaLista = new Intent(AgendaActivity.this, AgendaListaActivity.class);
        irParaAgendaLista.putExtra("nome",  nome);
        startActivity(irParaAgendaLista);
    }

}
