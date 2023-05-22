package com.kel6.kel6laundry.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.kel6.kel6laundry.model.ModelLaundry;


import java.util.List;

import retrofit2.http.DELETE;

@Dao
public interface LaundryDao {

    @Query("SELECT * FROM tbl_laundry")
    LiveData<List<ModelLaundry>> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertData(ModelLaundry modelLaundries);

    @Query("DELETE FROM tbl_laundry")
    void deleteAllData();

    @Query("DELETE FROM tbl_laundry WHERE uid= :uid")
    void deleteSingleData(int uid);

    @Query("UPDATE tbl_laundry SET nama_jasa = :nama_jasa, items = :items, alamat = :alamat, harga = :harga WHERE uid = :uid")
    void updateData(String nama_jasa, int items, String alamat, int harga, int uid);
}
