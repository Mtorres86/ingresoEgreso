package hn.uth.ingresosegresos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

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
        // Lógica para actualizar la base de datos en caso de cambios en la estructura
        // No es necesario implementarla en este ejemplo básico
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

    public long insertIngreso(double monto, String descripcion, String fecha) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_MONTO, monto);
        values.put(COLUMN_DESCRIPCION, descripcion);
        values.put(COLUMN_FECHA, fecha);

        long id = db.insert(TABLE_INGRESOS, null, values);

        db.close();

        return id;
    }

    public long insertEgreso(double monto, String descripcion, String fecha) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_MONTO, monto);
        values.put(COLUMN_DESCRIPCION, descripcion);
        values.put(COLUMN_FECHA, fecha);

        long id = db.insert(TABLE_EGRESOS, null, values);

        db.close();

        return id;
    }

    public List<Ingreso> getAllIngresos() {
        List<Ingreso> ingresos = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(TABLE_INGRESOS, null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                long id = cursor.getLong(cursor.getColumnIndex(COLUMN_ID));
                double monto = cursor.getDouble(cursor.getColumnIndex(COLUMN_MONTO));
                String descripcion = cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPCION));
                String fecha = cursor.getString(cursor.getColumnIndex(COLUMN_FECHA));

                Ingreso ingreso = new Ingreso(id, monto, descripcion, fecha);
                ingresos.add(ingreso);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return ingresos;
    }

    public List<Egreso> getAllEgresos() {
        List<Egreso> egresos = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(TABLE_EGRESOS, null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                long id = cursor.getLong(cursor.getColumnIndex(COLUMN_ID));
                double monto = cursor.getDouble(cursor.getColumnIndex(COLUMN_MONTO));
                String descripcion = cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPCION));
                String fecha = cursor.getString(cursor.getColumnIndex(COLUMN_FECHA));

                Egreso egreso = new Egreso(id, monto, descripcion, fecha);
                egresos.add(egreso);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return egresos;
    }
}
