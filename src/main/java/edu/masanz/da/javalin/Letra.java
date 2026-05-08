package edu.masanz.da.javalin;

public class Letra {

    private String valor;
    private int estado;

    public Letra(String valor) {
        this.valor = valor;
    }

    public Letra(String valor, int estado) {
        this.valor = valor;
        this.estado = estado;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
