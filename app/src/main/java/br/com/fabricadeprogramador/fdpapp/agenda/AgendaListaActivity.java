package br.com.fabricadeprogramador.fdpapp.agenda;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Pessoa pessoaSelecionada = (Pessoa) parent.getItemAtPosition(position);

                Intent irParaForm = new Intent(AgendaListaActivity.this, AgendaActivity.class);
                irParaForm.putExtra("pessoaSel", pessoaSelecionada);

                startActivity(irParaForm);
                // Toast.makeText(AgendaListaActivity.this, "Clicou na pessoa " + pessoaSelecionada.getNome(), Toast.LENGTH_SHORT).show();
            }
        });

        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                Pessoa pessoaSelecionada = (Pessoa) parent.getItemAtPosition(position);

                BancoDeDados bancoDeDados = new BancoDeDados(AgendaListaActivity.this);
                bancoDeDados.excluir(pessoaSelecionada);

                atualiza();

                return true;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        atualiza();
    }

    public void atualiza(){
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