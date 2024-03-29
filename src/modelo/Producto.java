package modelo;

public class Producto {

    private int idProducto;
    private String nombre;
    private int stock;
    private double precio;
    private String descripcion;
    private int iva;
    private byte [] imagen;
    private int idCategoria;
    private int estado;

    public Producto(int idProducto, String nombre, int stock, double precio, String descripcion, int iva, int idCategoria, int estado) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
        this.descripcion = descripcion;
        this.iva = iva;
        this.idCategoria = idCategoria;
        this.estado = estado;
    }

    public Producto(int idProducto, String nombre, int stock, double precio) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
    }
    
    

    public Producto() {

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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIva() {
        return iva;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

}
