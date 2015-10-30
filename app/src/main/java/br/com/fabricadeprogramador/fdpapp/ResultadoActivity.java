package br.com.fabricadeprogramador.fdpapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Virmerson on 10/22/15.
 */
public class ResultadoActivity extends Activity{

    private final String TAG = "FDPResultadoActivity";

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

        Button btFechar = (Button) findViewById(R.id.bt_fechar);

        btFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        //Toast.makeText(this, calculo.toString(), Toast.LENGTH_SHORT).show();
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
