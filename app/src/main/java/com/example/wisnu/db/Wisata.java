package com.example.wisnu.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "wisata_table")
public class Wisata {
    @PrimaryKey(autoGenerate = true)
    public int wisata_id;

    @ColumnInfo(name = "nama")
    public String nama;

    @ColumnInfo(name = "gambar_url")
    public String gambar_url;

    @ColumnInfo(name = "kategori")
    public String kategori;

    @Ignore
    public Wisata(int wisata_id, String nama, String gambar_url, String kategori) {
        this.wisata_id = wisata_id;
        this.nama = nama;
        this.gambar_url = gambar_url;
        this.kategori = kategori;
    }

    public Wisata(String nama, String gambar_url, String kategori) {
        this.nama = nama;
        this.gambar_url = gambar_url;
        this.kategori = kategori;
    }
}
