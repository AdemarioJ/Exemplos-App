package com.cursoandroid.firebaseapp.autenticacaousuario;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance(); // Consegue fazer a autenticação



        // LOGIN
        /*firebaseAuth.signInWithEmailAndPassword("ademariocc@gmail.com","ademario123")
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Log.i("signIn","Sucesso ao fazer login do usuário");
                        }else {
                            Log.i("signIn","Erro ao fazer o login do usuário");
                        }
                    }
                });*/



        //Verificar usuario se está logado
        if (firebaseAuth.getCurrentUser() != null){
            Log.i("VerificaUsuario","Usuário está logado");
        }else{
            Log.i("VerificaUsuario","Usuário não está logado");
        }

        //Deslogar usuario
        firebaseAuth.signOut();

        // CADASTRO
        /*firebaseAuth.createUserWithEmailAndPassword("ademariocc@gmail.com","ademario123")
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful() ){ //Sucesso ao cadastrar o usuário
                            Log.i("CreatUser","Sucesso ao cadastrar o usuário");
                        }else{
                            Log.i("CreatUser","Erro ao cadastrar o usuário");
                        }
                    }
                });*/

    }
}
