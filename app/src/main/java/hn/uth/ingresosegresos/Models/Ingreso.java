package hn.uth.ingresosegresos.Models;

public class Ingreso {
    private long id;
    private double monto;
    private String descripcion;
    private String fecha;

    private String tipo;

    public Ingreso(long id, double monto, String descripcion, String fecha, String tipo) {
        this.id = id;
        this.monto = monto;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.tipo = tipo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

}
