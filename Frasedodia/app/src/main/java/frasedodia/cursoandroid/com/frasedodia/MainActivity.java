package frasedodia.cursoandroid.com.frasedodia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView textoNovaFrase;
    private Button botaoNovaFrase;

    private String[] frases = {"Teste1",
                                "Teste2",
                                "Teste3",
                                "Teste4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoNovaFrase =(TextView) findViewById(R.id.textoNovaFraseID);
        botaoNovaFrase = (Button) findViewById(R.id.botaoNovaFraseID);

        botaoNovaFrase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Random aleatorio = new Random();
                int Num = aleatorio.nextInt(frases.length);
                textoNovaFrase.setText(frases[Num]);

            }
        });
    }

}
