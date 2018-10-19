package caracoroa.cursoandroid.com.caraoucoroa;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageButton botaoJogar;
    private String[] opcao = {"Cara","Coroa"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoJogar = (ImageButton) findViewById(R.id.botaoJogarID);
        botaoJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int numeroAleatorio = random.nextInt(2);
                Intent intent = new Intent(MainActivity.this,DetalheActivity.class);
                intent.putExtra("opcao",opcao[numeroAleatorio]);

                startActivity(intent);
            }
        });
    }
}
