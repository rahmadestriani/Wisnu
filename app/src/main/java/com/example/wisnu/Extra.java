package com.example.wisnu;

import android.content.Context;
import android.util.Log;

import com.example.wisnu.db.Wisata;
import com.example.wisnu.model.WisataItem;

import java.util.ArrayList;

public class Extra {
    private static String TAG = com.example.wisnu.Extra.class.getSimpleName();

    public static void wisataToDB(Context context, ArrayList<WisataItem> wisataItems){
        for (WisataItem wisataItem: wisataItems){
            if (MainActivity.db.getWisata().getAllWisata() == null){
                try {
                    Wisata wisata = new Wisata(
                            String.valueOf(wisataItem.getNama()),
                            String.valueOf(wisataItem.getGambarUrl()),
                            String.valueOf(wisataItem.getKategori()));

                    MainActivity.db.getWisata().insertWisata(wisata);
                }catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                }
            }
        }
    }
}
