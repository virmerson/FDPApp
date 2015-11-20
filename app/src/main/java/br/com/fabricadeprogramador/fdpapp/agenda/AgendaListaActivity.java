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

        Intent i = getIntent();
        Bundle bundle = i.getExtras();

        //Capturando Dados do Bundle
        Long id= bundle.getLong("id");
        String nome= bundle.getString("nome");
        String email= bundle.getString("email");
        String telefone= bundle.getString("telefone");
        Bitmap imagem = (Bitmap) bundle.get("img");

        //Criando objeto pessoa com dados vindos da tela anterior
        Pessoa pessoa = new Pessoa();
        pessoa.setId(id);
        pessoa.setNome(nome);
        pessoa.setEmail(email);
        pessoa.setTelefone(telefone);
       // pessoa.setImagem(imagem);

        //Instanciando objeto para salvar no banco
        BancoDeDados banco = new BancoDeDados(this);

        //Salvando
        banco.salvar(pessoa);

       //Listar as pessoas
        PessoaListAdapter adapter = new PessoaListAdapter(this,banco.buscarTodos());

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, GerenciadorAgenda.getPessoaList());

       lista.setAdapter(adapter);

    }

    @OnClick(R.id.bt_fechar_agenda)
    public void fechar (){
        finish();
    }
}
