package caracoroa.cursoandroid.com.caraoucoroa;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.Random;

public class DetalheActivity extends AppCompatActivity {

    private ImageButton botaoVoltar;
    private ImageView imagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        imagem = (ImageView)findViewById(R.id.moedaID);
        botaoVoltar = (ImageButton) findViewById(R.id.botaoVoltarID);

        Bundle extra = getIntent().getExtras();
        if (extra != null){
            String opcaoEscolhida = extra.getString("opcao");
            if (opcaoEscolhida.equals("Cara")){
                imagem.setImageDrawable(ContextCompat.getDrawable(DetalheActivity.this,R.drawable.moeda_cara));
            }else{
                imagem.setImageDrawable(ContextCompat.getDrawable(DetalheActivity.this,R.drawable.moeda_coroa));
            }
        }


        botaoVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DetalheActivity.this,MainActivity.class));
            }
        });
    }
}
