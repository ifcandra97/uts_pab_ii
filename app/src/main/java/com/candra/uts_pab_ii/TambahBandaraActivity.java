package com.candra.uts_pab_ii;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.candra.uts_pab_ii.database.MyDatabase;

public class TambahBandaraActivity extends AppCompatActivity {

    private EditText etNama, etKota, etAlamat;
    private Button btnTambah;
    private MyDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_bandara);
        this.setTitle("Bandara 2125250012");

        db = new MyDatabase(TambahBandaraActivity.this);
        etNama = findViewById(R.id.et_nama);
        etKota = findViewById(R.id.et_kota);
        etAlamat = findViewById(R.id.et_alamat);

        btnTambah = findViewById(R.id.btn_tambahdata);
        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama, kota, alamat;

                nama = etNama.getText().toString();
                kota = etKota.getText().toString();
                alamat = etAlamat.getText().toString();

                if(nama.trim().equals(""))
                {
                    etNama.setError("Nama Masih Kosong !");
                    etNama.requestFocus();
                }
                else if(kota.trim().equals(""))
                {
                    etKota.setError("Kota / Kabupaten Masih Kosong !");
                    etKota.requestFocus();
                }
                else if(alamat.trim().equals(""))
                {
                    etAlamat.setError("Alamat Masih Kosong !");
                    etAlamat.requestFocus();
                }
                else {
                    long execute = db.tambahData(nama, kota, alamat);
                    
                    if(execute == -1)
                    {
                        Toast.makeText(TambahBandaraActivity.this, "Data Bandara Gagal Di Tambahkan !", Toast.LENGTH_SHORT).show();
                        etNama.requestFocus();
                    }
                    else {
                        Toast.makeText(TambahBandaraActivity.this, "Data Bandara Berhasil Di Tambahkan !", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
            }
        });

    }
}