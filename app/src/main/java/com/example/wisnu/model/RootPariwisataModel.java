package com.example.wisnu.model;

import java.util.ArrayList;
import com.google.gson.annotations.SerializedName;

public class RootPariwisataModel{

    @SerializedName("wisata")
    private ArrayList<WisataItem> wisata;

    public void setWisata(ArrayList<WisataItem> wisata){
        this.wisata = wisata;
    }

    public ArrayList<WisataItem> getWisata(){
        return wisata;
    }
}