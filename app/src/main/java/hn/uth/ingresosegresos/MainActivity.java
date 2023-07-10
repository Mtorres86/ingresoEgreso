package hn.uth.ingresosegresos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import hn.uth.ingresosegresos.DataBase.DAO.EgresoDAO;
import hn.uth.ingresosegresos.DataBase.DAO.IngresoDAO;
import hn.uth.ingresosegresos.DataBase.DatabaseHelper;
import hn.uth.ingresosegresos.Models.Egreso;
import hn.uth.ingresosegresos.Models.Ingreso;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private IngresoEgresoAdapter adapter;
    private List<Ingreso> ingresos;
    private List<Egreso> egresos;
    private IngresoDAO ingresoDAO;
    private EgresoDAO egresoDAO;

    private List<Object> ingresosEgresos;


    @Override
    protected void onResume() {
        super.onResume();

        // Obtener los nuevos datos de ingresos y egresos de la base de datos
        ingresos = ingresoDAO.getAllIngresos();
        egresos = egresoDAO.getAllEgresos();

        // Actualizar los datos en el adaptador
        //adapter.actualizarIngresos(ingresos);
        //adapter.actualizarEgresos(egresos);

        ingresosEgresos = new ArrayList<>();
        ingresosEgresos.addAll(ingresos);
        ingresosEgresos.addAll(egresos);
        adapter.actualizarIngresosEgresos(ingresosEgresos);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        // Obtén el contexto de la actividad
        Context context = this; // o Context context = getApplicationContext();

        // Inicializar el DatabaseHelper
        ingresoDAO = new IngresoDAO(this);
        egresoDAO = new EgresoDAO(this);

        // Obtener los ingresos y egresos de la base de datos
        ingresos = ingresoDAO.getAllIngresos();
        egresos = egresoDAO.getAllEgresos();

        ingresosEgresos = new ArrayList<>();
        ingresosEgresos.addAll(ingresos);
        ingresosEgresos.addAll(egresos);

        // Crear una instancia del adaptador
        adapter = new IngresoEgresoAdapter(ingresosEgresos, this);

        // Configurar el RecyclerView con el adaptador
        recyclerView.setAdapter(adapter);

        // Configurar el diseño del RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

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