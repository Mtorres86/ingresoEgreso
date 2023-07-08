package hn.uth.ingresosegresos.DataBase.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import hn.uth.ingresosegresos.DataBase.DatabaseHelper;
import hn.uth.ingresosegresos.Models.Egreso;
import hn.uth.ingresosegresos.Models.Ingreso;

public class IngresoDAO {

    private SQLiteDatabase database;

    public IngresoDAO(Context context) {
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
    }

    public long insertIngreso(Ingreso ingreso) {

        ContentValues values = new ContentValues();
        values.put("monto", ingreso.getMonto());
        values.put("descripcion", ingreso.getDescripcion());
        values.put("fecha", ingreso.getFecha());

        long id = database.insert("ingresos", null, values);

        return id;
    }


    public List<Ingreso> getAllIngresos() {
        List<Ingreso> ingresos = new ArrayList<>();

        Cursor cursor = database.query("ingresos", null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                long id = cursor.getLong(cursor.getColumnIndex("id"));
                double monto = cursor.getDouble(cursor.getColumnIndex("monto"));
                String descripcion = cursor.getString(cursor.getColumnIndex("descripcion"));
                String fecha = cursor.getString(cursor.getColumnIndex("fecha"));

                Ingreso ingreso = new Ingreso(id, monto, descripcion, fecha);
                ingresos.add(ingreso);
            } while (cursor.moveToNext());
        }

        cursor.close();

        return ingresos;
    }


}
