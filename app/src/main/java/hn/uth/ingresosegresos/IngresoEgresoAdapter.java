package hn.uth.ingresosegresos;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import hn.uth.ingresosegresos.DataBase.DAO.EgresoDAO;
import hn.uth.ingresosegresos.DataBase.DAO.IngresoDAO;
import hn.uth.ingresosegresos.Models.Egreso;
import hn.uth.ingresosegresos.Models.Ingreso;

public class IngresoEgresoAdapter extends RecyclerView.Adapter<IngresoEgresoAdapter.ViewHolder> {
    private List<Ingreso> ingresos;
    private List<Egreso> egresos;

    private List<Object> ingresoEgreso;
    private IngresoDAO ingresoDAO;
    private EgresoDAO egresoDAO;




    public IngresoEgresoAdapter(List<Object> ingresosEgresos, Context context) {
        this.ingresos = ingresos;
        this.egresos = egresos;
        this.ingresoDAO = new IngresoDAO(context);
        this.egresoDAO= new EgresoDAO(context);
        this.ingresoEgreso = ingresosEgresos;



    }

    public void actualizarIngresosEgresos(List<Object> nuevosIngresosEgresos) {
        ingresoEgreso.clear();
        ingresoEgreso.addAll(nuevosIngresosEgresos);
        notifyDataSetChanged();
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
    }//fin  onCreateViewHolder




    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Obtener el tipo de elemento (Ingreso o Egreso) en función de la posición

        Object item = ingresoEgreso.get(position);
        if (item instanceof Ingreso){
            holder.bindIngreso((Ingreso) item);
        } else if(item instanceof Egreso){
            holder.bindEgreso((Egreso) item);
        }

        /*if (position < ingresos.size()) {
            Ingreso ingreso = ingresos.get(position);
            holder.bindIngreso(ingreso);

        } else {
            int egresoPosition = position - ingresos.size();
            Egreso egreso = egresos.get(egresoPosition);
            holder.bindEgreso(egreso);
        }*/

    }//fin onBindViewHolder

    @Override
    public int getItemCount() {
        //return ingresos.size() + egresos.size();
        return ingresoEgreso.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public View btnEliminar;
        private TextView montoTextView;
        private TextView descripcionTextView;
        private TextView fechaTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            montoTextView = itemView.findViewById(R.id.montoTextView);
            descripcionTextView = itemView.findViewById(R.id.descripcionTextView);
            fechaTextView = itemView.findViewById(R.id.fechaTextView);
            btnEliminar = itemView.findViewById(R.id.btnEliminar);

            //

            btnEliminar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int position = getAdapterPosition();
                    Object item = ingresoEgreso.get(position);
                    if(item instanceof Ingreso){
                        Ingreso lineaIngreso = (Ingreso) item;
                        ingresoDAO.eliminarIngreso(lineaIngreso.getId());
                    }else if(item instanceof Egreso){
                        Egreso lineaEgreso = (Egreso) item;
                        egresoDAO.eliminarEgreso(lineaEgreso.getId());
                    }

                    ingresoEgreso.remove(position);
                    notifyItemRemoved(position);
                    //notifyItemRangeChanged(getAdapterPosition(), ingresoEgreso.size());
                    /*if (position != RecyclerView.NO_POSITION) {
                        if (position < ingresos.size()) {
                            Ingreso ingreso = ingresos.get(position);
                           ingresoDAO.eliminarIngreso(ingreso.getId());
                            ingresos.remove(position);
                            notifyItemRemoved(position);
                        } else {
                            int egresoPosition = position - ingresos.size();
                            Egreso egreso = egresos.get(egresoPosition);
                           egresoDAO.eliminarEgreso(egreso.getId());
                            egresos.remove(egresoPosition);
                            notifyItemRemoved(position);
                        }
                    }*/
                }
            });



            //

        }


        /*
        public void bindIngreso(Ingreso ingreso) {
            String monto = String.valueOf(ingreso.getMonto());
            String descripcion = ingreso.getDescripcion();
            String fecha = ingreso.getFecha();

            montoTextView.setText(monto);
            descripcionTextView.setText(descripcion);
            fechaTextView.setText(fecha);
        }*/


        public void bindIngreso(Ingreso ingreso) {
            String monto = String.valueOf(ingreso.getMonto());
            String descripcion = ingreso.getDescripcion();
            String fecha = ingreso.getFecha();

            String textoFinal = " " + monto + " " + descripcion + " " + fecha;
            montoTextView.setText(textoFinal);
        }


        /*

        public void bindEgreso(Egreso egreso) {
            String monto = String.valueOf(egreso.getMonto());
            String descripcion = egreso.getDescripcion();
            String fecha = egreso.getFecha();

            montoTextView.setText(monto);
            descripcionTextView.setText(descripcion);
            fechaTextView.setText(fecha);
        }*/

        public void bindEgreso(Egreso egreso) {
            String monto = String.valueOf(egreso.getMonto());
            String descripcion = egreso.getDescripcion();
            String fecha = egreso.getFecha();

            String textoFinal = " " + monto + " " + descripcion + " " + fecha;
            montoTextView.setText(textoFinal);
        }

        public void eliminarElemento(int position) {
            if (position < ingresos.size()) {
                ingresos.remove(position);
                notifyItemRemoved(position);
            } else {
                int egresoPosition = position - ingresos.size();
                egresos.remove(egresoPosition);
                notifyItemRemoved(position);
            }
        }



    }
}


