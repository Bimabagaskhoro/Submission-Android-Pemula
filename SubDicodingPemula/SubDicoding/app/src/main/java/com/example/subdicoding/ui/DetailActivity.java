package com.example.subdicoding.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.subdicoding.R;
import com.example.subdicoding.model.Wisata;

public class DetailActivity extends AppCompatActivity {
    public static final String  EXTRA_KEY = "extra_key";
    private ImageView imgWisataPhoto;
    private TextView wisataNama, wisataDeskripsi,wisataLokasi,wisataKategori;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //inisial
        imgWisataPhoto = findViewById(R.id.img_item_photo);
        wisataNama = findViewById(R.id.tv_item_name);
        wisataDeskripsi = findViewById(R.id.tv_item_Deskripsi);
        wisataLokasi = findViewById(R.id.tv_lokasi);
        wisataKategori  =findViewById(R.id.tv_katagori);

        //ambildata
        Wisata dataWisata = getIntent().getParcelableExtra(EXTRA_KEY);
        Glide.with(this)
                .load(dataWisata.getPhoto())
                .into(imgWisataPhoto);
        wisataNama.setText(dataWisata.getName());
        wisataDeskripsi.setText(dataWisata.getDeskripsi());
        wisataLokasi.setText(dataWisata.getLokasi());
        wisataKategori.setText(dataWisata.getKatagori());
    }
}
