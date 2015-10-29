package br.com.fabricadeprogramador.fdpapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Virmerson on 10/22/15.
 */
public class ResultadoActivity extends Activity{

    private final String TAG = "ResultadoActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultado);
        Log.i(TAG, "CHAMOU on CREATE " + TAG);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Double calculo = bundle.getDouble("calculo");

        TextView tvResultado= (TextView) findViewById(R.id.tv_resultado);
        tvResultado.setText(calculo.toString());

        //Toast.makeText(this, calculo.toString(), Toast.LENGTH_SHORT).show();
    }
}
