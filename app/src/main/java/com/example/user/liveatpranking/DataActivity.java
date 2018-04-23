package com.example.user.liveatpranking;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class DataActivity extends AppCompatActivity {

    private SkupIgraca sviIgraci;
    private RecyclerView mRecyclerView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 1;
                int j = getIntent().getIntExtra("j", 32);
                int prag = getIntent().getIntExtra("prag", 133);
                int donjaGranicaZai = getIntent().getIntExtra("donjaZai", 30);
                int gornjaGranicaZai = getIntent().getIntExtra("gornjaZai", 642);
                int srednjaGranicaZai = getIntent().getIntExtra("srednjaZai", 51);
                String link = getIntent().getStringExtra("link");

                try
                {
                    final Document document = Jsoup.connect(link).get();
                    ArrayList<String> niz;
                    final ArrayList<Igrac> skupIgraca = new ArrayList<>();
                    Elements elementi;
                    niz = new ArrayList<String>();

                    Igrac igrac;
                    for(Element row : document.select("tr"))
                    {
                        if(i > donjaGranicaZai && i < gornjaGranicaZai && i != srednjaGranicaZai)
                        {
                            if(i != prag)
                            {
                                if(i != j)
                                {
                                    elementi = row.getAllElements();

                                    for (Element kolona: elementi)
                                    {

                                        if(kolona != elementi.first()){//zato sto svaki niz elementi u prvom elementu ima sve podatke, a ostali su redom
                                            if(kolona.text() != "") {
                                                niz.add(kolona.text());
                                            }
                                        }
                                    }

                                    String duzina = niz.get(5).substring(1, niz.get(5).length()-1);//NCH
                                    if(duzina.matches("\\d+"))
                                    {
                                        String drzava = "upitnik";
                                        for (int l = 0; l < 15; l++)
                                        {
                                            String pom = niz.get(l);
                                            if(pom.matches("[A-Za-z]{3}\\d{1,3}"))
                                                drzava = pom;
                                        }

                                        int id;
                                        id = getResources().getIdentifier(drzava.substring(0,3).toLowerCase(), "drawable", getPackageName());
                                        if(id == 0) id = getResources().getIdentifier("upitnik", "drawable", getPackageName());
                                        Drawable drawable = getResources().getDrawable(id);

                                        igrac = new Igrac(niz.get(0), niz.get(1), niz.get(7), niz.get(8), drawable, drzava, niz.get(12),niz.get(13), niz.get(14), niz.get(16), niz.get(niz.size()-2), niz.get(niz.size()-1));
                                    }
                                    else
                                    {
                                        if(niz.get(6).length() > 2)//godine
                                        {
                                            String name = niz.get(8).substring(0,3).toLowerCase();
                                            int id = getResources().getIdentifier(name, "drawable", getPackageName());
                                            if(id == 0) id = getResources().getIdentifier("upitnik", "drawable", getPackageName());
                                            Drawable drawable = getResources().getDrawable(id);
                                            igrac = new Igrac(niz.get(0), niz.get(1), niz.get(5), niz.get(6), drawable, niz.get(8), niz.get(10),niz.get(11), niz.get(12), niz.get(14), niz.get(niz.size()-2), niz.get(niz.size()-1));
                                        }
                                        else
                                        {
                                            String name = niz.get(7).substring(0,3).toLowerCase();
                                            int id = getResources().getIdentifier(name, "drawable", getPackageName());
                                            if(id == 0) id = getResources().getIdentifier("upitnik", "drawable", getPackageName());
                                            Drawable drawable = getResources().getDrawable(id);

                                            igrac = new Igrac(niz.get(0), niz.get(1), niz.get(5), niz.get(6), drawable, niz.get(7), niz.get(9),niz.get(10), niz.get(11), niz.get(13), niz.get(niz.size()-2), niz.get(niz.size()-1));
                                        }
                                    }
                                    skupIgraca.add(igrac);
                                }
                                else
                                {
                                    j += 2;
                                }
                            }
                            else
                            {
                                prag += 102;
                            }
                        }
                        niz.clear();
                        i++;
                    }
                    sviIgraci = new SkupIgraca(skupIgraca);
                }
                catch (IOException e)
                {
                    String greska = e.getMessage();
                    Log.d("Hahu", greska);
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setVisibility(View.GONE);
                        mRecyclerView = (RecyclerView) findViewById(R.id.recycler);

                        MyAdapter myAdapter = new MyAdapter(sviIgraci, getApplicationContext());
                        mRecyclerView.setAdapter(myAdapter);
                        LinearLayoutManager layoutManager = new LinearLayoutManager(DataActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);

                    }
                });
            }
        }).start();
    }
}
