package com.kel6.kel6laundry.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.kel6.kel6laundry.database.dao.LaundryDao;
import com.kel6.kel6laundry.model.ModelLaundry;

    

@Database(entities = {ModelLaundry.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract LaundryDao laundryDao();
}
