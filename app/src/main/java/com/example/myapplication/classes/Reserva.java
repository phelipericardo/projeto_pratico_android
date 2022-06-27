package com.example.myapplication.classes;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;


@Entity
public class Reserva {
    public Reserva(int id, int carroId, String locatarioId, Date dataInicioReserva, Date dataFimReserva, String status) {
        this.id = id;
        this.carroId = carroId;
        this.locatarioId = locatarioId;
        this.dataInicioReserva = dataInicioReserva;
        this.dataFimReserva = dataFimReserva;
        this.status = status;
    }

    @PrimaryKey(autoGenerate = true)
    public int id;
    public int carroId;
    public String locatarioId;
    public Date dataInicioReserva;
    public Date dataFimReserva;
    public String status;
}

