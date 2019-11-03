package com.example.subdicoding.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Wisata implements Parcelable {
        private String name;
        private String deskripsi;
        private String photo;
        private String lokasi;
        private String katagori;


    protected Wisata(Parcel in) {
        name = in.readString();
        deskripsi = in.readString();
        photo = in.readString();
        lokasi = in.readString();
        katagori = in.readString();
    }

    public static final Creator<Wisata> CREATOR = new Creator<Wisata>() {
        @Override
        public Wisata createFromParcel(Parcel in) {
            return new Wisata(in);
        }

        @Override
        public Wisata[] newArray(int size) {
            return new Wisata[size];
        }
    };

    public Wisata() {

    }

    public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDeskripsi() {
            return deskripsi;
        }

        public void setDeskripsi(String deskripsi) {
            this.deskripsi = deskripsi;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }
        public String getLokasi() {
            return lokasi;
        }

        public void setLokasi(String lokasi) {
            this.lokasi = lokasi;
        }
        public String getKatagori() {
            return katagori;
        }

        public void setKatagori(String katagori) {
            this.katagori = katagori;
        }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(deskripsi);
        dest.writeString(photo);
        dest.writeString(lokasi);
        dest.writeString(katagori);
    }
}

