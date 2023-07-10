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

public class EgresoDAO {


    private SQLiteDatabase database;

    public EgresoDAO(Context context) {
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
    }


    public long insertEgreso(Egreso egreso) {

        ContentValues values = new ContentValues();
        values.put("monto", egreso.getMonto());
        values.put("descripcion", egreso.getDescripcion());
        values.put("fecha", egreso.getFecha());

        long id = database.insert("egresos", null, values);

        return id;
    }
    public void eliminarEgreso(long id) {
        String whereClause = "id = ?";
        String[] whereArgs = {String.valueOf(id)};
        database.delete("egresos", whereClause, whereArgs);
    }


    public List<Egreso> getAllEgresos() {
        List<Egreso> egresos = new ArrayList<>();

        Cursor cursor = database.query("egresos", null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                long id = cursor.getLong(cursor.getColumnIndex("id"));
                double monto = cursor.getDouble(cursor.getColumnIndex("monto"));
                String descripcion = cursor.getString(cursor.getColumnIndex("descripcion"));
                String fecha = cursor.getString(cursor.getColumnIndex("fecha"));

                egresos.add(new Egreso(id, monto, descripcion, fecha, "E"));
            } while (cursor.moveToNext());
        }

        cursor.close();
        return egresos;
    }


}
