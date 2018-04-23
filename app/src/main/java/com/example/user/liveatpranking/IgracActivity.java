package com.example.user.liveatpranking;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class IgracActivity extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_igrac);

        int id;
        id = getResources().getIdentifier(getIntent().getStringExtra(DRZAVA).substring(0,3).toLowerCase(), "drawable", getPackageName());
        if(id == 0) id = getResources().getIdentifier("upitnik", "drawable", getPackageName());
        Drawable draw = getResources().getDrawable(id);

        TextView p = (TextView) findViewById(R.id.pId);
        TextView chpom = (TextView) findViewById(R.id.CHID2);
        ImageView img = (ImageView) findViewById(R.id.zID);
        TextView imedrz = (TextView) findViewById(R.id.imeDrzID);
        TextView punIme = (TextView) findViewById(R.id.iID);
        TextView godd = (TextView) findViewById(R.id.gID);
        TextView bod = (TextView) findViewById(R.id.bID);
        TextView pl = (TextView) findViewById(R.id.pnaID);
        TextView mi = (TextView) findViewById(R.id.mID);
        TextView tr = (TextView) findViewById(R.id.tID);
        TextView nxt = (TextView) findViewById(R.id.nID);
        TextView mxt = (TextView) findViewById(R.id.mxID);
        TextView pn = (TextView) findViewById(R.id.pnID);
        //ScrollView scrollview = (ScrollView) findViewById(R.id.scroll);

        punIme.setText("Ime i prezime: "+getIntent().getStringExtra(PUNOIME));
        p.setText("Trenutna pozicija: "+getIntent().getStringExtra(POZICIJA));
        chpom.setText("Najbolji plasman: "+getIntent().getStringExtra(CH));
        imedrz.setText("Drzava: "+getIntent().getStringExtra(DRZAVA).substring(0,3));
        img.setImageDrawable(draw);
        pn.setText("Pozicija u nacionalnom timu: "+getIntent().getStringExtra(DRZAVA).substring(3,getIntent().getStringExtra(DRZAVA).length()));
        godd.setText("Godine: "+getIntent().getStringExtra(GODINA));
        bod.setText("Bodovi: "+getIntent().getStringExtra(BODOVI));
        pl.setText("Promjena ranka u odnosu na zadnje rankiranje: "+getIntent().getStringExtra(PLUS));
        mi.setText("Promjena bodova u odnosu na zadnje rankiranje: "+getIntent().getStringExtra(MINUS));
        tr.setText("Posljednji turnir: "+getIntent().getStringExtra(TRENUTNI));
        nxt.setText("Broj bodova ukoliko pobijedi naredni meč: "+getIntent().getStringExtra(NXTPTS));
        mxt.setText("Maksimalan broj bodova nakon turnira: "+getIntent().getStringExtra(MAXPTS));
    }
}
