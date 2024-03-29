package Modelo;

public class EncabezadoDeVenta {

    private int idEncabezadoVentas;
    private int idCliente;
    private double valorPago;
    private String fechaVentas;
    private int estado;

    public EncabezadoDeVenta() {
        this.idEncabezadoVentas = 0;
        this.idCliente = 0;
        this.valorPago = 0.0;
        this.fechaVentas = "";
        this.estado = 0;
    }

    public EncabezadoDeVenta(int idEncabezadoVentas, int idCliente, double valorPago, String fechaVentas, int estado) {
        this.idEncabezadoVentas = idEncabezadoVentas;
        this.idCliente = idCliente;
        this.valorPago = valorPago;
        this.fechaVentas = fechaVentas;
        this.estado = estado;
    }

    public int getIdEncabezadoVentas() {
        return idEncabezadoVentas;
    }

    public void setIdEncabezadoVentas(int idEncabezadoVentas) {
        this.idEncabezadoVentas = idEncabezadoVentas;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public String getFechaVentas() {
        return fechaVentas;
    }

    public void setFechaVentas(String fechaVentas) {
        this.fechaVentas = fechaVentas;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "EncabezadoDeVenta{" + "idEncabezadoVentas=" + idEncabezadoVentas + ", idCliente=" + idCliente + ", valorPago=" + valorPago + ", fechaVentas=" + fechaVentas + ", estado=" + estado + '}';
    }
    
    
    
    
}
