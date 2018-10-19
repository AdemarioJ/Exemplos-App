package br.clinup.com.palmaresbus.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import br.clinup.com.palmaresbus.R;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Context context;
    private int qnt_cidades;

    private ArrayList<String> mHorariosDataset = new ArrayList<>();

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);

        }
    }

    // Construtor
    public RecyclerViewAdapter(Context context, int qnt_cidades, ArrayList<String> mHorariosDataset) {
        this.context = context;
        this.qnt_cidades = qnt_cidades;
        this.mHorariosDataset = mHorariosDataset;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_items, parent, false);
        ViewHolder holder = new ViewHolder(view);


        RecyclerView recyclerView = view.findViewById(R.id.recycler_horariosID);

        RecyclerView.LayoutManager recyclerViewLayoutManager = new GridLayoutManager(context,4);
        recyclerView.setLayoutManager(recyclerViewLayoutManager);

        RecyclerViewHorariosAdapter recyclerViewHorariosAdapter = new RecyclerViewHorariosAdapter(context, mHorariosDataset);
        recyclerView.setAdapter(recyclerViewHorariosAdapter);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //holder.textView.setText(SubjectValues[position]);

    }

    //quantidade de itens que teremos
    @Override
    public int getItemCount() {
        return qnt_cidades;
    }
}
