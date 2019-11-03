package com.example.subdicoding.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.subdicoding.CustomOnitemClickListener;
import com.example.subdicoding.R;
import com.example.subdicoding.model.Wisata;
import com.example.subdicoding.ui.DetailActivity;

import java.util.ArrayList;

public class ListWisataAdapter extends RecyclerView.Adapter<ListWisataAdapter.ListViewHolder> {
    private ArrayList<Wisata> listWisata;
    private Context context;

    public ArrayList<Wisata> getListWisataData(){
        return listWisata;
    }

    public void setListWisataData(ArrayList<Wisata>listWisata){
        this.listWisata = listWisata;
    }

    public ListWisataAdapter(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_wisata,
                viewGroup,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder listViewHolder, int position) {
        Wisata wisata = listWisata.get(position);

        Glide.with(listViewHolder.itemView.getContext())
                .load(wisata.getPhoto())
                .apply(new RequestOptions().override(55,55))
                .into(listViewHolder.imgPhoto);

        listViewHolder.tvName.setText(wisata.getName());
        listViewHolder.tvDeskripsi.setText(wisata.getDeskripsi());
        listViewHolder.tvLokasi.setText(wisata.getLokasi());
        listViewHolder.tvKategori.setText(wisata.getKatagori());

        listViewHolder.itemView.setOnClickListener(new CustomOnitemClickListener(position, new CustomOnitemClickListener.OnItemClickCallBack() {

            @Override
            public void DataClick(View view, int position) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_KEY,getListWisataData().get(position));
                context.startActivity(intent);

                Toast.makeText(context,"Wisata yang dipilih adalah "+getListWisataData().get(position).getName(),
                        Toast.LENGTH_SHORT).show();
            }
        }));

    }

    @Override
    public int getItemCount() {
        return listWisata.size();
    }
    public interface OnItemClickCallback{
        void onItemClicked(Wisata data);
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName,tvDeskripsi,tvLokasi,tvKategori;

       public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDeskripsi = itemView.findViewById(R.id.tv_item_Deskripsi);
            tvLokasi = itemView.findViewById(R.id.tv_lokasi);
            tvKategori = itemView.findViewById(R.id.tv_katagori);

        }
    }
}
