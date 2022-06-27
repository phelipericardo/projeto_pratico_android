package com.example.myapplication.model;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myapplication.classes.Car;

import java.util.List;

@Dao
public interface CarDao {
    @Query("SELECT * from Car WHERE status='livre'")
    List<Car> getAll();
    @Query("SELECT * from Car WHERE id=:idCarro")
    Car buscarPorId( int idCarro );

    @Query("SELECT * from Car WHERE model =:carModelo")
    List<Car> buscarPorModelo(int carModelo);

    @Query("UPDATE Car SET status=\"locado\" WHERE id=:idCarro")
    void locarCarro(int idCarro );

    @Update
    void locarCarro( Car ... alunos);

    @Insert(onConflict= OnConflictStrategy.REPLACE)
    void insertAll( Car ... alunos);
    @Delete
    void delete(Car ... alunos);
    @Update
    void update( Car ... alunos);
}
