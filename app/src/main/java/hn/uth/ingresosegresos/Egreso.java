package hn.uth.ingresosegresos;

public class Egreso {
    private long id;
    private double monto;
    private String descripcion;
    private String fecha;

    public Egreso(long id, double monto, String descripcion, String fecha) {
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
