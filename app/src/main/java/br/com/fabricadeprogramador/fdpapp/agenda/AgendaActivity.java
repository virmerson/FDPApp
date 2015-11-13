package br.com.fabricadeprogramador.fdpapp.agenda;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import br.com.fabricadeprogramador.fdpapp.R;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Virmerson on 11/5/15.
 */
public class AgendaActivity extends AppCompatActivity{


    private static final  int CAMERA_REQUEST = 123 ;
    @Bind(R.id.ed_nome)
    EditText edNome;

    @Bind(R.id.pessoa_imagem_cad)
    ImageView imagemPessoa;

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
        irParaAgendaLista.putExtra("nome", nome);
        startActivity(irParaAgendaLista);
    }



    @OnClick(R.id.pessoa_imagem_cad)
      public void mudarImagem(){
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==CAMERA_REQUEST && resultCode==RESULT_OK){
            Bitmap imagem = (Bitmap)data.getExtras().get("data");
            imagemPessoa.setImageBitmap(imagem);

        }
    }
}
