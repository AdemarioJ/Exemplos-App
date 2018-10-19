package sqlite.cursoandroid.com.sqlite;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            //Criando o banco de dados
            SQLiteDatabase bancoDeDatos = openOrCreateDatabase("app",MODE_PRIVATE,null);

            //tabela
            bancoDeDatos.execSQL("CREATE TABLE IF NOT EXISTS pessoas(id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR , idade INTEGER(3))");
            // Apagar a tabela
            //bancoDeDatos.execSQL("DROP TABLE pessoas");

            //Inserir dados na tabela
            bancoDeDatos.execSQL("INSERT INTO pessoas(nome,idade) VALUES('Marcos',30)");
            bancoDeDatos.execSQL("INSERT INTO pessoas(nome,idade) VALUES('Ana',20)");
            bancoDeDatos.execSQL("INSERT INTO pessoas(nome,idade) VALUES('Maria',50)");
            bancoDeDatos.execSQL("INSERT INTO pessoas(nome,idade) VALUES('Tiago',18)");


            // bancoDeDatos.execSQL("UPDATE pessoas SET idade = 18 WHERE nome = 'Marcos'");

            //bancoDeDatos.execSQL("DELETE FROM pessoas WHERE nome = 'Marcos'");


            //Recuperar os dados
            Cursor cursor = bancoDeDatos.rawQuery("SELECT * FROM pessoas",null);

            //Recuperando os indicis das colunas
            int indiceColunaNome = cursor.getColumnIndex("nome");
            int indiceColunaIdade = cursor.getColumnIndex("idade");
            int indiceColunaId = cursor.getColumnIndex("id");

            cursor.moveToFirst();

            while (cursor != null){

                Log.i("RESULTADO - nome", cursor.getString(indiceColunaNome));
                Log.i("RESULTADO - idade", cursor.getString(indiceColunaIdade));
                Log.i("RESULTADO - id", cursor.getString(indiceColunaId));

                cursor.moveToNext();

            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
