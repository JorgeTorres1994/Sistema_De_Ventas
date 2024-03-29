package modelo;

public class CajaRegistradora{
    private double montoApertura;
    private String responsableApertura;
    private String fechaApertura;

    public CajaRegistradora(double montoApertura, String responsableApertura, String fechaApertura) {
        this.montoApertura = montoApertura;
        this.responsableApertura = responsableApertura;
        this.fechaApertura = fechaApertura;
    }

    public double getMontoApertura() {
        return montoApertura;
    }

    public String getResponsableApertura() {
        return responsableApertura;
    }

    public String getFechaApertura() {
        return fechaApertura;
    }
}