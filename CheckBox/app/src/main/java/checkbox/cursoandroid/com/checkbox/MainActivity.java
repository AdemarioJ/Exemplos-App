package checkbox.cursoandroid.com.checkbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button botaoMostrar;

    private CheckBox checkBoxCao;
    private CheckBox checkBoxGato;
    private CheckBox checkBoxPapagaio;

    private TextView textoExibicao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoMostrar = (Button)findViewById(R.id.botaoMostrarID);

        checkBoxCao = (CheckBox)findViewById(R.id.checkBoxCaoID);
        checkBoxGato = (CheckBox)findViewById(R.id.checkBoxGatoID);
        checkBoxPapagaio = (CheckBox)findViewById(R.id.checkBoxPapagaioID);

        textoExibicao = (TextView)findViewById(R.id.textoExibicaoID);

        botaoMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String itensSelecionados = "";

                if (checkBoxCao.isChecked() == true){
                    itensSelecionados += "Item:" + checkBoxCao.getText() + "\n";
                }if (checkBoxGato.isChecked() == true){
                    itensSelecionados += "Item:" + checkBoxGato.getText() + "\n";
                }if(checkBoxPapagaio.isChecked() == true){
                    itensSelecionados += "Item:" + checkBoxPapagaio.getText() + "\n";
                }if(checkBoxCao.isChecked()== false && checkBoxGato.isChecked() == false && checkBoxPapagaio.isChecked() == false) {
                    textoExibicao.setText("Nenhum item selecionado");
                }else
                    textoExibicao.setText(itensSelecionados);

            }
        });
    }
}
