package org.unrn;

public class Pedido {
    private final String plato;
    private final String bebida;

    public Pedido(String plato, String bebida) {
        this.plato = plato;
        this.bebida = bebida;
    }

    public String getPlato() {
        return plato;
    }

    public String getBebida() {
        return bebida;
    }
}
