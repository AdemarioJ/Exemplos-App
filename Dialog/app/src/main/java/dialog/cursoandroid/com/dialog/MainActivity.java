package dialog.cursoandroid.com.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Button botao;
    private AlertDialog.Builder dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botao = (Button)findViewById(R.id.botaoID);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //criar alert Dialog
                dialog = new AlertDialog.Builder(MainActivity.this);

                //Configurar a Dialog
                dialog.setTitle("Título da dialog");

                //Configurar Mensagem
                dialog.setMessage("Mensagem");

                //Configurar negativo
                dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Pressionado Botão Não", Toast.LENGTH_SHORT).show();
                    }
                });

                //Configurar positivo
                dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Pressionado Botão Sim", Toast.LENGTH_SHORT).show();
                    }
                });

                dialog.setCancelable(false);
                dialog.setIcon(android.R.drawable.ic_delete);

                // Criamos e exibimos a Dialog
                dialog.create();
                dialog.show();
            }
        });
    }
}
