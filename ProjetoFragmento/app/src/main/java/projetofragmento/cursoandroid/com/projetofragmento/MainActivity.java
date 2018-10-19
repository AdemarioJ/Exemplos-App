package projetofragmento.cursoandroid.com.projetofragmento;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button logar;
    private boolean status = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logar = (Button)findViewById(R.id.bt_logarID);
        logar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction(); // Prepara para fazer as edições

                if ( status ){

                    LoginFragment loginFragment = new LoginFragment();
                    fragmentTransaction.add(R.id.rl_conteiner_fragmentoID, loginFragment); // adicionar o fragmento ao container
                    fragmentTransaction.commit();
                    logar.setText("Cadastre-se");
                    status = false;

                }else{

                    CadastroFragment cadastroFragment = new CadastroFragment();
                    fragmentTransaction.add(R.id.rl_conteiner_fragmentoID, cadastroFragment);
                    fragmentTransaction.commit();
                    logar.setText("Logar");
                    status = true;
                }
            }
        });
    }
}
