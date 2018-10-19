package br.com.whatsappandroid.cursoandroid.whatsapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.whatsappandroid.cursoandroid.whatsapp.R;
import br.com.whatsappandroid.cursoandroid.whatsapp.config.ConfiguracaoFirebase;
import br.com.whatsappandroid.cursoandroid.whatsapp.helper.Preferencias;
import br.com.whatsappandroid.cursoandroid.whatsapp.model.Mensagem;

public class MensagemAdapter extends ArrayAdapter<Mensagem> {

    private Context context;
    private ArrayList<Mensagem> mensagens;

    public MensagemAdapter(@NonNull Context c, @NonNull ArrayList<Mensagem> objects) {
        super(c, 0, objects);
        this.context = c;
        this.mensagens = objects;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = null;

        //Verificar se a lista está preenchida
        if ( mensagens != null ){

            // Recuperar os dados do usuário remetente
            Preferencias preferencias = new Preferencias( context );
            String idUsuarioRemetente = preferencias.getIdentificador();

            //Inicializar o objeto para a montagem do layout
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

            // Recuperar a mensagem
            Mensagem mensagem = mensagens.get( position );

            // Montar layout a partir do XML
            if ( idUsuarioRemetente.equals( mensagem.getIdUsuario() ) ) {

                view = inflater.inflate(R.layout.item_mensagem_direita, parent, false);

            }else{
                view = inflater.inflate(R.layout.item_mensagem_esquerda, parent, false);

            }
            // Recuperar elemento para exibição
            TextView textoMensagem = (TextView) view.findViewById(R.id.tv_mensagem);
            textoMensagem.setText( mensagem.getMensagem() );


        }

        return view;
    }
}
