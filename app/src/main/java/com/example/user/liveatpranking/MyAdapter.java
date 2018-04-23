package com.example.user.liveatpranking;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by User on 4/23/2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    private ArrayList<Igrac> skupIgraca;
    private Context context;
    private static final String POZICIJA = "com.example.user.liveatpranking.pozicija";
    private static final String CH = "com.example.user.liveatpranking.ch";
    private static final String PUNOIME = "com.example.user.liveatpranking.punoime";
    private static final String GODINA = "com.example.user.liveatpranking.godina";
    private static final String DRZAVA = "com.example.user.liveatpranking.drzava";
    private static final String BODOVI = "com.example.user.liveatpranking.bodovi";
    private static final String PLUS = "com.example.user.liveatpranking.plus";
    private static final String MINUS = "com.example.user.liveatpranking.minus";
    private static final String TRENUTNI = "com.example.user.liveatpranking.trenutni";
    private static final String NXTPTS = "com.example.user.liveatpranking.nxtpts";
    private static final String MAXPTS = "com.example.user.liveatpranking.maxpts";


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder{
        // each data item is just a string in this case
        private LinearLayout redZaIgraca;
        public ViewHolder(LinearLayout v) {
            super(v);
            redZaIgraca = v;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(SkupIgraca skup, Context context) {
        skupIgraca = skup.getIgraci();
        this.context = context;

    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        LinearLayout mjestoZaIgraca = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.igracispis, parent, false);
        ViewHolder vh = new ViewHolder(mjestoZaIgraca);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        LinearLayout liniar = holder.redZaIgraca;
        final TextView pozicija = (TextView) liniar.findViewById(R.id.pozicijaID);
        TextView ime = (TextView) liniar.findViewById(R.id.imeId);
        ImageView drzava = (ImageView) liniar.findViewById(R.id.zastavaID);

        pozicija.setText(skupIgraca.get(position).getPozicija());
        ime.setText(skupIgraca.get(position).getPunoIme());
        drzava.setBackground(skupIgraca.get(position).getDrzava());

        liniar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context.getApplicationContext(), IgracActivity.class);
                intent.putExtra(POZICIJA, skupIgraca.get(position).getPozicija());
                intent.putExtra(CH, skupIgraca.get(position).getCH());
                intent.putExtra(PUNOIME, skupIgraca.get(position).getPunoIme());
                intent.putExtra(GODINA, skupIgraca.get(position).getGodine());
                intent.putExtra(DRZAVA, skupIgraca.get(position).getDrzavaStr());
                intent.putExtra(BODOVI, skupIgraca.get(position).getBodovi());
                intent.putExtra(PLUS, skupIgraca.get(position).getPlus());
                intent.putExtra(MINUS, skupIgraca.get(position).getMinus());
                intent.putExtra(TRENUTNI, skupIgraca.get(position).getTrenutniTurnir());
                intent.putExtra(NXTPTS, skupIgraca.get(position).getNextPts());
                intent.putExtra(MAXPTS, skupIgraca.get(position).getMaxPts());


                context.startActivity(intent);
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return skupIgraca.size();
    }

}