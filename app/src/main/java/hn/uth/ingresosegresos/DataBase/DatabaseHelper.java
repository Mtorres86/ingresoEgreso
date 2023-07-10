package hn.uth.ingresosegresos.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import hn.uth.ingresosegresos.Models.Egreso;
import hn.uth.ingresosegresos.Models.Ingreso;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "ingresos_egresos.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_INGRESOS = "ingresos";
    private static final String TABLE_EGRESOS = "egresos";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_MONTO = "monto";
    private static final String COLUMN_DESCRIPCION = "descripcion";
    private static final String COLUMN_FECHA = "fecha";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createTableIngresos(db);
        createTableEgresos(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private void createTableIngresos(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_INGRESOS + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_MONTO + " REAL, " +
                COLUMN_DESCRIPCION + " TEXT, " +
                COLUMN_FECHA + " TEXT)";
        db.execSQL(query);
    }

    private void createTableEgresos(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_EGRESOS + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_MONTO + " REAL, " +
                COLUMN_DESCRIPCION + " TEXT, " +
                COLUMN_FECHA + " TEXT)";
        db.execSQL(query);
    }



}
