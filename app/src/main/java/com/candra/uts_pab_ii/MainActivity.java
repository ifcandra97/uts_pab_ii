package com.candra.uts_pab_ii;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.candra.uts_pab_ii.database.AdapterBandara;
import com.candra.uts_pab_ii.database.MyDatabase;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

    private MyDatabase db;
    private FloatingActionButton fabTambah;
    private RecyclerView rvBandara;
    private AdapterBandara adBandara;
    private ArrayList<String> arrId, arrNama, arrKota, arrAlamat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Bandara Candra");

        rvBandara = findViewById(R.id.rv_bandara);
        db = new MyDatabase(MainActivity.this);
        fabTambah = findViewById(R.id.fab_tambah);

        fabTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TambahBandaraActivity.class));
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        tampilBandara();
    }

    private void AddToArrayList()
    {
        Cursor c = db.bacaData();
        
        if(c.getCount() == 0)
        {
            Toast.makeText(this, "Tidak ada Data !", Toast.LENGTH_SHORT).show();
        }
        else {
            while (c.moveToNext())
            {
                arrId.add(c.getString(0));
                arrNama.add(c.getString(1));
                arrKota.add(c.getString(2));
                arrAlamat.add(c.getString(3));
            }
        }
    }

    private void tampilBandara()
    {
        arrId = new ArrayList<>();
        arrNama = new ArrayList<>();
        arrKota = new ArrayList<>();
        arrAlamat = new ArrayList<>();

        AddToArrayList();

        adBandara = new AdapterBandara(MainActivity.this, arrId, arrNama, arrKota, arrAlamat);
        rvBandara.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        rvBandara.setAdapter(adBandara);
    }


}