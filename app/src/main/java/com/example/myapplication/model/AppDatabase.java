package com.example.myapplication.model;

import android.content.Context;

import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.myapplication.classes.Car;
import com.example.myapplication.classes.Locatario;
import com.example.myapplication.classes.Reserva;

@Database(entities={Car.class, Reserva.class},version=2)
@TypeConverters(DateConverter.class)
abstract public class AppDatabase extends RoomDatabase {
    private static AppDatabase sInstance;
    @VisibleForTesting
    public static final String DATABASE_NAME = "teste.db";
    public abstract CarDao cardao();
    public abstract ReservaDao reservadao();

    private final MutableLiveData<Boolean> mIsDatabaseCreated = new MutableLiveData<>();

    public static AppDatabase getInstance(final Context context) {
        if (sInstance == null) {
            synchronized (AppDatabase.class) {
                if (sInstance == null) {
                    sInstance = buildDatabase(context.getApplicationContext());
                    sInstance.updateDatabaseCreated(context.getApplicationContext());
                }
            }
        }
        return sInstance;
    }

    private static AppDatabase buildDatabase(final Context appContext) {
        return Room.databaseBuilder(appContext, AppDatabase.class, DATABASE_NAME).allowMainThreadQueries().build();
    }

    private void updateDatabaseCreated(final Context context) {
        if (context.getDatabasePath(DATABASE_NAME).exists()) {
            setDatabaseCreated();
        }
    }

    private void setDatabaseCreated(){
        mIsDatabaseCreated.postValue(true);
    }
}
