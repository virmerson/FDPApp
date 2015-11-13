package br.com.fabricadeprogramador.fdpapp.agenda;

import android.content.Intent;

import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ImageView;

import com.android.camera.CropImageIntentBuilder;

import java.io.File;

import br.com.fabricadeprogramador.fdpapp.R;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Virmerson on 11/5/15.
 */
public class AgendaActivity extends AppCompatActivity{


    private static final  int CAMERA_REQUEST = 123 ;
    private static final  int CROP_REQUEST = 456 ;

    @Bind(R.id.ed_nome)
    EditText edNome;

    @Bind(R.id.pessoa_imagem_cad)
    ImageView imagemPessoa;

    Uri imagemOriginalUri;

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

    File imagemOriginal;

    @OnClick(R.id.pessoa_imagem_cad)
      public void mudarImagem(){
        imagemOriginal = new File (getExternalCacheDir(),"img");
        imagemOriginalUri = Uri.fromFile(imagemOriginal);

        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imagemOriginalUri);

        startActivityForResult(cameraIntent, CAMERA_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        File imagemCortada = new File(getFilesDir(), "img.jpg");

        //A camera respondeu com foto original
        if(requestCode==CAMERA_REQUEST && resultCode==RESULT_OK){
            //Chamada para O Crop
            Uri imageContadaUri = Uri.fromFile(imagemCortada);

            CropImageIntentBuilder crop = new CropImageIntentBuilder(200,200,imageContadaUri);

            crop.setSourceImage(imagemOriginalUri);

            startActivityForResult(crop.getIntent(AgendaActivity.this),CROP_REQUEST );

        }else if (requestCode==CROP_REQUEST && resultCode==RESULT_OK){
            //Resposta do Crop
            imagemPessoa.setImageBitmap(BitmapFactory.decodeFile(imagemCortada.getAbsolutePath()));
        }
    }
}
