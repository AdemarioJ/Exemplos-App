package preferenciascorusuario.cursoandroid.com.prefernciacorusurio;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends Activity {

    private RadioGroup radioGroup;
    private RadioButton radioButtonSelecionar;
    private Button botao;
    private static final String ARQUIVO_PREFERENCIAL = "ArquivoPreferencial";
    private ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = (RadioGroup)findViewById(R.id.radioGroupID);
        botao = (Button)findViewById(R.id.botaoSalvarID);
        layout = (ConstraintLayout)findViewById(R.id.layoutID);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int idRadioButtonEscolhido = radioGroup.getCheckedRadioButtonId();

                if (idRadioButtonEscolhido > 0){
                    radioButtonSelecionar = (RadioButton)findViewById(idRadioButtonEscolhido);

                    SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIAL,0);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    String corEscolhida = radioButtonSelecionar.getText().toString();
                    editor.putString("corEscolhida", corEscolhida);
                    editor.commit();

                    setBackground(corEscolhida);

                }
            }
        });

        //Recuperar a cor salva
        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIAL,0);
        if (sharedPreferences.contains("corEscolhida")){
            String corRecuperada = sharedPreferences.getString("corEscolhida","Laranja");
            setBackground(corRecuperada);
        }

    }

    private void setBackground(String cor){
        if (cor.equals("Azul")){
            layout.setBackgroundColor(Color.parseColor("#495b7c"));
        }else if (cor.equals("Laranja")){
            layout.setBackgroundColor(Color.parseColor("#ffce26"));

        }else if (cor.equals("Verde")){
            layout.setBackgroundColor(Color.parseColor("#009670"));

        }

    }
}
