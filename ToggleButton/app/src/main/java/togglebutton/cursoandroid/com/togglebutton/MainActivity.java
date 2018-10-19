package togglebutton.cursoandroid.com.togglebutton;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends Activity {

    private ToggleButton toggleButton;
    private TextView textoExibicao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoExibicao = (TextView)findViewById(R.id.TextoExibicaoID);
        toggleButton = (ToggleButton)findViewById(R.id.toggleButtonID);

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                textoExibicao.setText("");

                if (b){
                    textoExibicao.setText("Mostrar...");
                }
            }
        });
    }
}
