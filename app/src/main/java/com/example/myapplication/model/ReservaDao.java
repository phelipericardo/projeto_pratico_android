package com.example.myapplication.model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myapplication.classes.Reserva;

import java.util.List;

@Dao
public interface ReservaDao {
    @Query("SELECT * from Reserva")
    List<Reserva> getReservas();

    @Query("DELETE FROM Reserva WHERE id=:idReserva")
    int deleteWhere( int idReserva );

    @Query("SELECT * from Reserva WHERE id=:idReserva")
    Reserva buscarPorId( int idReserva );
    @Query("SELECT * from Reserva ORDER BY id DESC LIMIT 1")
    Reserva getLast();
    @Query("SELECT * from Reserva WHERE locatarioId=:cpf ORDER BY id DESC LIMIT 1")
    Reserva buscarReserva(String cpf );
    @Insert(onConflict= OnConflictStrategy.REPLACE)
    void insertAll( Reserva... reservas);
    @Delete
    void delete(Reserva ... reservas);
    @Update
    void update( Reserva ... reservas);
}
