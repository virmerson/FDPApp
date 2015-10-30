package br.com.fabricadeprogramador.fdpapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Virmerson on 10/22/15.
 */
public class ResultadoActivity extends Activity{

    private final String TAG = "FDPResultadoActivity";

    @Bind(R.id.tv_resultado)
    TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultado);
        ButterKnife.bind(this);

        Log.i(TAG, "CHAMOU on CREATE " + TAG);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Double calculo = bundle.getDouble("calculo");


        tvResultado.setText(calculo.toString());

        //Toast.makeText(this, calculo.toString(), Toast.LENGTH_SHORT).show();
    }
    @OnClick(R.id.bt_fechar)
    public void fechar (){
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "CHAMOU on Start " + TAG);
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "CHAMOU on Pause " + TAG);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "CHAMOU on Stop " + TAG);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "CHAMOU on Destroy " + TAG);
    }
}
