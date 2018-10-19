package gasolinaoualcool.cursoandroid.com.gasolinaoualcool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText precoAlcool;
    private EditText precoGasolina;
    private Button botaoVerificar;
    private TextView textoResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        precoAlcool = (EditText) findViewById(R.id.precoAlcoolID);
        precoGasolina = (EditText) findViewById(R.id.precoGasolinaID);
        textoResultado = (TextView) findViewById(R.id.textoResultadoID);
        botaoVerificar = (Button) findViewById(R.id.botaoVerificarID);

        botaoVerificar.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                //Recupera valores digitados
                String textoPrecoAlcool = precoAlcool.getText().toString();
                String textoPrecoGasolina = precoGasolina.getText().toString();

                //Alcool / Gasolina

                if (textoPrecoAlcool.isEmpty() || textoPrecoGasolina.isEmpty()){
                    textoResultado.setText("Digite os preços de Alcool e Gasolina");

                }else {
                    //Conversão de string para números
                    Double valorAlcool = Double.parseDouble(textoPrecoAlcool);
                    Double valorGasolina = Double.parseDouble(textoPrecoGasolina);

                    double Resultado = valorAlcool / valorGasolina;
                    if (Resultado >= 0.7) {
                        textoResultado.setText("É melhor utilizar gasolina");
                    } else {
                        textoResultado.setText("É melhor utilizar alcool");
                    }
                }



            }
        });
    }
}
