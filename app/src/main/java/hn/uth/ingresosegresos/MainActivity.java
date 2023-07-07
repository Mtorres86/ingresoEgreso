package hn.uth.ingresosegresos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private IngresoEgresoAdapter adapter;
    private List<Ingreso> ingresos;
    private List<Egreso> egresos;
    private DatabaseHelper databaseHelper;


    @Override
    protected void onResume() {
        super.onResume();

        // Obtener los nuevos datos de ingresos y egresos de la base de datos
        ingresos = databaseHelper.getAllIngresos();
        egresos = databaseHelper.getAllEgresos();

        // Actualizar los datos en el adaptador
        adapter.actualizarIngresos(ingresos);
        adapter.actualizarEgresos(egresos);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        // Inicializar el DatabaseHelper
        databaseHelper = new DatabaseHelper(this);

        // Obtener los ingresos y egresos de la base de datos
        ingresos = databaseHelper.getAllIngresos();
        egresos = databaseHelper.getAllEgresos();

        // Crear una instancia del adaptador
        adapter = new IngresoEgresoAdapter(ingresos, egresos);

        // Configurar el RecyclerView con el adaptador
        recyclerView.setAdapter(adapter);

        // Configurar el diseño del RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

    }

    public void registrarIngreso(View view) {
        // Código para registrar ingreso
        // Obtener los datos del formulario
        EditText montoEditText = findViewById(R.id.etMontoIngreso);
        EditText descripcionEditText = findViewById(R.id.etDescripcionIngreso);
        EditText fechaEditText = findViewById(R.id.etFechaIngreso);

        double monto = Double.parseDouble(montoEditText.getText().toString());
        String descripcion = descripcionEditText.getText().toString();
        String fecha = fechaEditText.getText().toString();

        // Insertar el ingreso en la base de datos
        long id = databaseHelper.insertIngreso(monto, descripcion, fecha);

        // Crear un objeto Ingreso con los datos ingresados
        Ingreso ingreso = new Ingreso(id, monto, descripcion, fecha);

        // Agregar el nuevo ingreso a la lista y notificar al adaptador
        ingresos.add(ingreso);
        adapter.notifyDataSetChanged();

        // Limpiar los campos del formulario
        montoEditText.setText("");
        descripcionEditText.setText("");
        fechaEditText.setText("");
    }

    public void registrarEgreso(View view) {
        // Código para registrar egreso
        // Obtener los datos del formulario
        EditText montoEditText = findViewById(R.id.etMontoEgreso);
        EditText descripcionEditText = findViewById(R.id.etDescripcionEgreso);
        EditText fechaEditText = findViewById(R.id.etFechaEgreso);

        double monto = Double.parseDouble(montoEditText.getText().toString());
        String descripcion = descripcionEditText.getText().toString();
        String fecha = fechaEditText.getText().toString();

        // Insertar el egreso en la base de datos
        long id = databaseHelper.insertEgreso(monto, descripcion, fecha);

        // Crear un objeto Egreso con los datos ingresados
        Egreso egreso = new Egreso(id, monto, descripcion, fecha);

        // Agregar el nuevo egreso a la lista y notificar al adaptador
        egresos.add(egreso);
        adapter.notifyDataSetChanged();

        // Limpiar los campos del formulario
        montoEditText.setText("");
        descripcionEditText.setText("");
        fechaEditText.setText("");
    }

    public void abrirFormularioIngresos(View view) {
        Intent intent = new Intent(this, FormularioIngresosActivity.class);
        startActivity(intent);
    }

    public void abrirFormularioEgresos(View view) {
        Intent intent = new Intent(this, FormularioEgresosActivity.class);
        startActivity(intent);
    }


    public void generarReporteIngresos(View view) {
        // Código para generar reporte de ingresos
    }

    public void generarReporteEgresos(View view) {
        // Código para generar reporte de egresos
    }

    //



}