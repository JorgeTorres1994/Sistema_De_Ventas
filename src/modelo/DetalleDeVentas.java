package Modelo;

public class DetalleDeVentas {
    
    private int idDetalleVentas;
    private int idEncabezadoVentas;
    private int idProducto; 
    private String nombre;
    private int cantidad;
    private double precioUnidad;
    private double subTotal;
    private double descuento;
    private double igv;
    private double totalPago;
    private int estado;

    public DetalleDeVentas() {
        this.idDetalleVentas = 0;
        this.idEncabezadoVentas = 0;
        this.idProducto = 0;
        this.nombre = "";
        this.cantidad = 0;
        this.precioUnidad = 0.0;
        this.subTotal = 0.0;
        this.descuento = 0.0;
        this.igv = 0.0;
        this.totalPago = 0.0;
        this.estado = 0;
    }

    public DetalleDeVentas(int idDetalleVentas, int idEncabezadoVentas, int idProducto, String nombre, int cantidad, double precioUnidad, double subTotal, double descuento, double igv, double totalPago, int estado) {
        this.idDetalleVentas = idDetalleVentas;
        this.idEncabezadoVentas = idEncabezadoVentas;
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioUnidad = precioUnidad;
        this.subTotal = subTotal;
        this.descuento = descuento;
        this.igv = igv;
        this.totalPago = totalPago;
        this.estado = estado;
    }

    public int getIdDetalleVentas() {
        return idDetalleVentas;
    }

    public void setIdDetalleVentas(int idDetalleVentas) {
        this.idDetalleVentas = idDetalleVentas;
    }

    public int getIdEncabezadoVentas() {
        return idEncabezadoVentas;
    }

    public void setIdEncabezadoVentas(int idEncabezadoVentas) {
        this.idEncabezadoVentas = idEncabezadoVentas;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(double precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public double getTotalPago() {
        return totalPago;
    }

    public void setTotalPago(double totalPago) {
        this.totalPago = totalPago;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "DetalleDeVentas{" + "idDetalleVentas=" + idDetalleVentas + ", idEncabezadoVentas=" + idEncabezadoVentas + ", idMedicamento=" + idProducto + ", nombre=" + nombre + ", cantidad=" + cantidad + ", precioUnidad=" + precioUnidad + ", subTotal=" + subTotal + ", descuento=" + descuento + ", igv=" + igv + ", totalPago=" + totalPago + ", estado=" + estado + '}';
    }
    
    
    
    
}
