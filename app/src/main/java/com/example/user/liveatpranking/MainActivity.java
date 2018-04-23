package com.example.user.liveatpranking;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView konekcija;
    private Button ATP, U21, U25, WTA, U21z, U25z;

    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        konekcija = (TextView) findViewById(R.id.konekcija);
        konekcija.setVisibility(View.INVISIBLE);

        if (!isOnline()) {
            konekcija.setVisibility(View.VISIBLE);
        }
        else
        {
            ATP = (Button) findViewById(R.id.sviATP);
            U21 = (Button) findViewById(R.id.U21);
            U25 = (Button) findViewById(R.id.U25);
            WTA = (Button) findViewById(R.id.sviWTA);
            U21z= (Button) findViewById(R.id.U21z);
            U25z= (Button) findViewById(R.id.U25z);

            ATP.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, DataActivity.class);
                    intent.putExtra("donjaZai", 30);
                    intent.putExtra("srednjaZai", 51);
                    intent.putExtra("gornjaZai", 1050);
                    intent.putExtra("j", 32);
                    intent.putExtra("prag", 133);
                    intent.putExtra("link", "https://live-tennis.eu/en/atp-live-ranking");
                    startActivity(intent);
                }
            });

            U21.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, DataActivity.class);
                    intent.putExtra("donjaZai", 29);
                    intent.putExtra("srednjaZai", 50);
                    intent.putExtra("gornjaZai", 336);
                    intent.putExtra("j", 31);
                    intent.putExtra("prag", 132);
                    intent.putExtra("link", "https://live-tennis.eu/en/atp-ranking-under-21");
                    startActivity(intent);
                }
            });

            U25.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, DataActivity.class);
                    intent.putExtra("donjaZai", 29);
                    intent.putExtra("srednjaZai", 50);
                    intent.putExtra("gornjaZai", 642);
                    intent.putExtra("j", 31);
                    intent.putExtra("prag", 132);
                    intent.putExtra("link", "https://live-tennis.eu/en/atp-ranking-under-25");
                    startActivity(intent);
                }
            });

            /**************************/

            WTA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, DataActivity.class);
                    intent.putExtra("donjaZai", 29);
                    intent.putExtra("srednjaZai", 50);
                    intent.putExtra("gornjaZai", 1050);
                    intent.putExtra("j", 31);
                    intent.putExtra("prag", 132);
                    intent.putExtra("link", "https://live-tennis.eu/en/wta-live-ranking");
                    startActivity(intent);
                }
            });

            U21z.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, DataActivity.class);
                    intent.putExtra("donjaZai", 29);
                    intent.putExtra("srednjaZai", 50);
                    intent.putExtra("gornjaZai", 642);
                    intent.putExtra("j", 31);
                    intent.putExtra("prag", 132);
                    intent.putExtra("link", "https://live-tennis.eu/en/wta-ranking-under-21");
                    startActivity(intent);
                }
            });

            U25z.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, DataActivity.class);
                    intent.putExtra("donjaZai", 29);
                    intent.putExtra("srednjaZai", 50);
                    intent.putExtra("gornjaZai", 642);
                    intent.putExtra("j", 31);
                    intent.putExtra("prag", 132);
                    intent.putExtra("link", "https://live-tennis.eu/en/wta-ranking-under-25");
                    startActivity(intent);
                }
            });
        }
    }
}
