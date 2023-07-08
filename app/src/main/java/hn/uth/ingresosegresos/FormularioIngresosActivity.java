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
        ingresoDAO.insertIngreso(new Ingreso(0, Double.parseDouble(monto), descripcion, fecha));

        // Aquí puedes agregar la lógica para guardar el ingreso en el DAO
        // por ejemplo, puedes crear un objeto Ingreso con los datos ingresados
        // y llamar a un método del DAO para guardarlo en la base de datos.

        Toast.makeText(this, "Ingreso guardado correctamente", Toast.LENGTH_SHORT).show();
        finish();
    }
}
