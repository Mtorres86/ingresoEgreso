package hn.uth.ingresosegresos;

public class Ingreso {
    private long id;
    private double monto;
    private String descripcion;
    private String fecha;

    public Ingreso(long id, double monto, String descripcion, String fecha) {
        this.id = id;
        this.monto = monto;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public long getId() {
        return id;
    }

    public double getMonto() {
        return monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFecha() {
        return fecha;
    }
}

