package hn.uth.ingresosegresos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import hn.uth.ingresosegresos.DataBase.DAO.IngresoDAO;
import hn.uth.ingresosegresos.DataBase.DatabaseHelper;
import hn.uth.ingresosegresos.Models.Ingreso;

public class FormularioIngresosActivity extends AppCompatActivity {

    private EditText etMonto;
    private EditText etDescripcion;
    private EditText etFecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_ingresos);

        etMonto = findViewById(R.id.etMontoIngreso);
        etDescripcion = findViewById(R.id.etDescripcionIngreso);
        etFecha = findViewById(R.id.etFechaIngreso);
    }

    public void guardarIngreso(View view) {
        String monto = etMonto.getText().toString();
        String descripcion = etDescripcion.getText().toString();
        String fecha = etFecha.getText().toString();


        IngresoDAO ingresoDAO= new IngresoDAO(getApplicationContext());
        ingresoDAO.insertIngreso(new Ingreso(0, Double.parseDouble(monto), descripcion, fecha, "I"));



        Toast.makeText(this, "Ingreso guardado correctamente", Toast.LENGTH_SHORT).show();
        finish();
    }
}
