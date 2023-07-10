package hn.uth.ingresosegresos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import hn.uth.ingresosegresos.DataBase.DAO.EgresoDAO;
import hn.uth.ingresosegresos.DataBase.DAO.IngresoDAO;
import hn.uth.ingresosegresos.DataBase.DatabaseHelper;
import hn.uth.ingresosegresos.Models.Egreso;
import hn.uth.ingresosegresos.Models.Ingreso;

public class FormularioEgresosActivity extends AppCompatActivity {

    private EditText etMonto;
    private EditText etDescripcion;
    private EditText etFecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_egresos);

        etMonto = findViewById(R.id.etMontoEgreso);
        etDescripcion = findViewById(R.id.etDescripcionEgreso);
        etFecha = findViewById(R.id.etFechaEgreso);
    }

    public void guardarEgreso(View view) {
        String monto = etMonto.getText().toString();
        String descripcion = etDescripcion.getText().toString();
        String fecha = etFecha.getText().toString();

        // Obtener los ingresos y egresos de la base de datos
        EgresoDAO egresoDAO= new EgresoDAO(getApplicationContext());
        egresoDAO.insertEgreso(new Egreso(0, Double.parseDouble(monto), descripcion, fecha, "E"));



        Toast.makeText(this, "Egreso guardado correctamente", Toast.LENGTH_SHORT).show();
        finish();
    }
}
