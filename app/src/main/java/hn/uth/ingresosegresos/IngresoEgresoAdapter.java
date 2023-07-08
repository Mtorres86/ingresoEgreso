package hn.uth.ingresosegresos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import hn.uth.ingresosegresos.Models.Egreso;
import hn.uth.ingresosegresos.Models.Ingreso;

public class IngresoEgresoAdapter extends RecyclerView.Adapter<IngresoEgresoAdapter.ViewHolder> {
    private List<Ingreso> ingresos;
    private List<Egreso> egresos;

    public IngresoEgresoAdapter(List<Ingreso> ingresos, List<Egreso> egresos) {
        this.ingresos = ingresos;
        this.egresos = egresos;
    }

    public void actualizarIngresos(List<Ingreso> nuevosIngresos) {
        ingresos.clear();
        ingresos.addAll(nuevosIngresos);
        notifyDataSetChanged();
    }

    public void actualizarEgresos(List<Egreso> nuevosEgresos) {
        egresos.clear();
        egresos.addAll(nuevosEgresos);
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflar el diseño del elemento de la lista
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ingreso_egreso, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Obtener el tipo de elemento (Ingreso o Egreso) en función de la posición
        if (position < ingresos.size()) {
            Ingreso ingreso = ingresos.get(position);
            holder.bindIngreso(ingreso);
        } else {
            int egresoPosition = position - ingresos.size();
            Egreso egreso = egresos.get(egresoPosition);
            holder.bindEgreso(egreso);
        }
    }

    @Override
    public int getItemCount() {
        return ingresos.size() + egresos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView montoTextView;
        private TextView descripcionTextView;
        private TextView fechaTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            montoTextView = itemView.findViewById(R.id.montoTextView);
            descripcionTextView = itemView.findViewById(R.id.descripcionTextView);
            fechaTextView = itemView.findViewById(R.id.fechaTextView);
        }

        public void bindIngreso(Ingreso ingreso) {
            montoTextView.setText(String.valueOf(ingreso.getMonto()));
            descripcionTextView.setText(ingreso.getDescripcion());
            fechaTextView.setText(ingreso.getFecha());
        }

        public void bindEgreso(Egreso egreso) {
            montoTextView.setText(String.valueOf(egreso.getMonto()));
            descripcionTextView.setText(egreso.getDescripcion());
            fechaTextView.setText(egreso.getFecha());
        }



    }
}
