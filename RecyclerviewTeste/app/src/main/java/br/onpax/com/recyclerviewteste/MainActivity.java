package br.onpax.com.recyclerviewteste;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    final static int LIST_SIZE = 100;

    final static int TOP = 0;
    final static int BOTTOM = LIST_SIZE;
    final static int MIDDLE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        final ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < LIST_SIZE; i++) {
            list.add(i);
        }

        class Viewholder extends RecyclerView.ViewHolder {
            TextView textView;

            Viewholder(View itemView) {
                super(itemView);
                textView = itemView.findViewById(R.id.textView);
            }
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        final RecyclerView.Adapter<Viewholder> adapter = new RecyclerView.Adapter<Viewholder>() {
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);

            @Override
            public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
                switch (viewType) {
                    case TOP:
                        return new Viewholder(inflater.inflate(R.layout.topitem, parent, false));
                    case BOTTOM:
                        return new Viewholder(inflater.inflate(R.layout.bottomitem, parent, false));
                    case MIDDLE:
                    default:
                        return new Viewholder(inflater.inflate(R.layout.middleitem, parent, false));
                }
            }

            @Override
            public void onBindViewHolder(Viewholder holder, int position) {
                holder.textView.setText(String.valueOf(list.get(position)));
                if (position != 0 && position != LIST_SIZE - 1) {
                    int color = position % 2 == 0 ? android.R.color.holo_orange_dark : android.R.color.holo_orange_light;
                    holder.itemView.setBackgroundColor(getResources().getColor(color));
                }
            }

            @Override
            public int getItemCount() {
                return LIST_SIZE;
            }

            @Override
            public int getItemViewType(int position) {
                int itemViewType;
                switch (position) {
                    case 0:
                        itemViewType = TOP;
                        break;
                    case LIST_SIZE - 1:
                        itemViewType = BOTTOM;
                        break;
                    default:
                        itemViewType = MIDDLE;
                }
                return itemViewType;
            }
        };
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }
}