package br.com.fabricadeprogramador.fdpapp.calculo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import java.io.Serializable;

import br.com.fabricadeprogramador.fdpapp.R;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class CalcActivity extends Activity {


    private final String TAG = "FDPCalcActivity";

    @Override
    protected void onDestroy() {
        Log.i(TAG, "CHAMOU ON DESTROY " + TAG);
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        Log.i(TAG, "CHAMOU ON STOP " + TAG);
        super.onStop();
    }

    @Override
    protected void onPause() {
        Log.i(TAG, "CHAMOU ON PAUSE " + TAG);
        super.onPause();
    }

    @Override
    protected void onStart() {
        Log.i(TAG, "CHAMOU ON START " + TAG);
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.i(TAG, "CHAMOU ON RESUME " + TAG);
        super.onResume();
    }

    @Bind(R.id.ed1)
    EditText ed1;

    @Bind(R.id.ed2)
    EditText ed2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "CHAMOU ON CREATE " + TAG);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc);

        ButterKnife.bind(this);

    }


    @OnClick(R.id.btDividir)
    public void dividir(){
        Double n1 = Double.parseDouble(ed1.getText().toString());
        Double n2 = Double.parseDouble(ed2.getText().toString());
        Double div = n1 / n2;

        mostrarResultado(div);
    }

    @OnClick(R.id.btMultiplicar)
    public void multiplicar(){
        Double n1 = Double.parseDouble(ed1.getText().toString());
        Double n2 = Double.parseDouble(ed2.getText().toString());
        Double mult = n1 * n2;

        mostrarResultado(mult);
    }


    @OnClick(R.id.btSubtrair)
    public void subtrair() {

        Double n1 = Double.parseDouble(ed1.getText().toString());
        Double n2 = Double.parseDouble(ed2.getText().toString());
        Double sub = n1 - n2;

        mostrarResultado(sub);
    }


    @OnClick(R.id.btSomar)
    public void somar() {


        Double n1 = Double.parseDouble(ed1.getText().toString());
        Double n2 = Double.parseDouble(ed2.getText().toString());

        Double soma = n1 + n2;

        mostrarResultado(soma);


    }

    public void mostrarResultado(Double resultado){
        Intent irParaResultado = new Intent(CalcActivity.this, ResultadoActivity.class);



        Bundle bundle = new Bundle();
       // bundle.putDouble("calculo", calc_resultado);

        bundle.putSerializable("calculo", new Resultado(resultado));


        irParaResultado.putExtras(bundle);

        startActivity(irParaResultado);
    }

}

class Resultado implements Serializable {
    private Double res;

    public Resultado(Double res){
        this.res=res;

    }

    public Double getR() {
        return res;
    }
}