package adivinha.cursoandroid.com.adivinha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button botaoJogar;
    private TextView textResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoJogar = (Button) findViewById(R.id.botao_jogarID);
        textResultado = (TextView) findViewById(R.id.resultado_ID);

        botaoJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random numero = new Random();
                int randomNumber = numero.nextInt(10);
                textResultado.setText("Número escolhido: "+ randomNumber);
            }
        });
        //textoResultado.setText("Texto alterado");


    }
}
