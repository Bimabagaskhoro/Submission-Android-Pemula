package com.example.subdicoding;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.subdicoding.adapter.ListWisataAdapter;
import com.example.subdicoding.model.Wisata;
import com.example.subdicoding.ui.DataBima;
import com.example.subdicoding.utils.WisataData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvWisata;
    private ArrayList<Wisata> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvWisata = findViewById(R.id.rv_Wisata);
        rvWisata.setHasFixedSize(true);
        list=new ArrayList<>();

        list.addAll(WisataData.getListData());
        showRecyclerList();
    }
    private void showRecyclerList(){
        rvWisata.setLayoutManager(new LinearLayoutManager(this));
        ListWisataAdapter listWisataAdapter = new ListWisataAdapter(this);
        listWisataAdapter.setListWisataData(list);
        rvWisata.setAdapter(listWisataAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.action) {
            startActivity(new Intent(this, DataBima.class));
        }
        return true;
    }
}
