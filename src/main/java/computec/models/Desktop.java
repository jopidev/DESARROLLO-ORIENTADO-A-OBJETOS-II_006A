package computec.models;

public class Desktop extends Equipo {
    private int potenciaFuente;
    private String factorForma;

    public Desktop(int id, String descripcion, String cpu, int disco, int ram, double precio,
                   int potenciaFuente, String factorForma) {
        super(id, descripcion, cpu, disco, ram, precio, "Desktop");
        this.potenciaFuente = potenciaFuente;
        this.factorForma = factorForma;
    }

    public Desktop() {}

    public int getPotenciaFuente() { return potenciaFuente; }
    public String getFactorForma() { return factorForma; }

    public void setPotenciaFuente(int potenciaFuente) { this.potenciaFuente = potenciaFuente; }
    public void setFactorForma(String factorForma) { this.factorForma = factorForma; }
}
