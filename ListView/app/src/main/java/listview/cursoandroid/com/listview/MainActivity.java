package listview.cursoandroid.com.listview;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private ListView listaItens;
    private String[] itens = {"Angra dos Reis","Caldas Novas",
                              "Campos do Jordão","Costa do Sauípe",
                              "Ilhéus","Porto Seguro","Rio de Janeiro",
                              "Tiradentes","Praga","Santiago","Zurique","Caribe",
                              "Bueno Aires","Budapest","Cancun","Aruba"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaItens = (ListView)findViewById(R.id.listViewID);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                itens
        );

        listaItens.setAdapter(adaptador);

        listaItens.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                int codigoPosicao = position;
                String valorClicado =(String) listaItens.getItemAtPosition(codigoPosicao);

                Toast.makeText(getApplicationContext(),valorClicado,Toast.LENGTH_LONG).show();
            }
        });
    }
}
