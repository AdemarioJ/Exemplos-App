package br.clinup.com.palmaresbus.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

import br.clinup.com.palmaresbus.R;

public class RecyclerViewHorariosAdapter extends RecyclerView.Adapter<RecyclerViewHorariosAdapter.ViewHolder> {

    private Context context;
    private ArrayList<String> mHorariosDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        Button horario;

        public ViewHolder(View itemView) {
            super(itemView);

            horario = itemView.findViewById(R.id.horariosID);
        }
    }

    // Construtor
    public RecyclerViewHorariosAdapter(Context context, ArrayList<String> horarios) {
        this.context = context;
        this.mHorariosDataset = horarios;
    }

    @NonNull
    @Override
    public RecyclerViewHorariosAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horarios, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //holder.textView.setText(SubjectValues[position]);

        holder.horario.setText(mHorariosDataset.get(position));
    }

    //quantidade de itens que teremos
    @Override
    public int getItemCount() {
        return mHorariosDataset.size();
    }
}
