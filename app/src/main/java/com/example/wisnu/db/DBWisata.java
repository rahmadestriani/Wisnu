package com.example.wisnu.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Wisata.class}, version = 1, exportSchema = false)
public abstract class DBWisata extends RoomDatabase {
    public abstract DAOWisata getWisata();

    private static DBWisata DB;

    public static DBWisata getInstance(Context context) {
        if (null == DB) {
            DB = buildDatabaseInstance(context);
        }
        return DB;
    }

    private static DBWisata buildDatabaseInstance(Context context) {
        return Room.databaseBuilder(context,
                DBWisata.class,
                "wisata_db")
                .allowMainThreadQueries().build();
    }

    public void cleanUp(){
        DB = null;
    }
}
