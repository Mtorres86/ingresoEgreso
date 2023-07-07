package hn.uth.ingresosegresos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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

        // Aquí puedes agregar la lógica para guardar el egreso en el DAO

        Toast.makeText(this, "Egreso guardado correctamente", Toast.LENGTH_SHORT).show();
        finish();
    }
}
