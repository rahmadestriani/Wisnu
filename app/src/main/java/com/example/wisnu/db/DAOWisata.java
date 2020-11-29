package com.example.wisnu.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface DAOWisata {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertWisata(Wisata wisata);

    @Update
    int updateWisata(Wisata wisata);

    @Delete
    int deleteWisata(Wisata wisata);

    @Query("SELECT * FROM wisata_table ORDER BY nama asc")
    Wisata[] getAllWisata();
}
