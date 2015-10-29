package br.com.fabricadeprogramador.fdpapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity{



    private final String  TAG = "MainActivity";

    @Override
    protected void onDestroy() {
        Log.i(TAG, "CHAMOU ON DESTROY");
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        Log.i(TAG, "CHAMOU ON STOP");
        super.onStop();
    }

    @Override
    protected void onPause() {
        Log.i(TAG, "CHAMOU ON PAUSE");
        super.onPause();
    }

    @Override
    protected void onStart() {
        Log.i(TAG, "CHAMOU ON START");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.i(TAG, "CHAMOU ON RESUME");
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "CHAMOU ON CREATE");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       final EditText ed1 = (EditText) findViewById(R.id.ed1);
       final EditText ed2 = (EditText) findViewById(R.id.ed2);


         Button btSoma = (Button) findViewById(R.id.btSomar);
         btSoma.setOnClickListener(new View.OnClickListener() {


             @Override
             public void onClick(View view) {
                  Double n1 = Double.parseDouble(ed1.getText().toString());
                  Double n2 = Double.parseDouble(ed2.getText().toString());

                 Double soma = n1 + n2;

                 Intent irParaResultado = new Intent(MainActivity.this, ResultadoActivity.class);

                 Bundle bundle = new Bundle();
                 bundle.putDouble("calculo", soma);

                 irParaResultado.putExtras(bundle);

                 startActivity(irParaResultado);


             }
         });

        Button btSub = (Button) findViewById(R.id.btSubtrair);
        btSub.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                 Double n1 = Double.parseDouble(ed1.getText().toString());
                 Double n2 = Double.parseDouble(ed2.getText().toString());
                Double sub =  n1-n2;


            }
        });

        Button btMul = (Button) findViewById(R.id.btMultiplicar);
        btMul.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                Double n1 = Double.parseDouble(ed1.getText().toString());
                Double n2 = Double.parseDouble(ed2.getText().toString());
                Double mult =  n1*n2;


            }
        });

        Button btDiv = (Button) findViewById(R.id.btDividir);
        btDiv.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                Double n1 = Double.parseDouble(ed1.getText().toString());
                Double n2 = Double.parseDouble(ed2.getText().toString());
                Double div =  n1/n2;


            }
        });
    }
}
