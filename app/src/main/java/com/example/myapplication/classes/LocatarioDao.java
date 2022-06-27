package com.example.myapplication.classes;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface LocatarioDao {
    @Query("SELECT * from Locatario")
    List<Locatario> getLocatarios();
    @Query("SELECT * from Locatario WHERE cpf=:cpfLocatario")
    Locatario buscarPorCpf( int cpfLocatario );
    @Insert(onConflict= OnConflictStrategy.REPLACE)
    void insertAll( Locatario ... locatarios);
    @Delete
    void delete(Locatario ... locatarios);
    @Update
    void update( Locatario ... locatarios);
}