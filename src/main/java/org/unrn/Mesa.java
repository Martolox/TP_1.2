package org.unrn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mesa {
    private Map<String, Double> platos = new HashMap<String, Double>();
    private Map<String, Double> bebidas = new HashMap<String, Double>();
    private List<Pedido> pedidos = new ArrayList<Pedido>();

    public Mesa() {
        CrearMenuConPrecios();
    }

    private void CrearMenuConPrecios() {
        platos.put("Plato1", 10.0);
        platos.put("Plato2", 20.0);
        platos.put("Plato3", 30.0);
        bebidas.put("Bebida1", 1.0);
        bebidas.put("Bebida2", 2.0);
        bebidas.put("Bebida3", 3.0);
    }

    public void crearPedido(String plato, String bebida) {
        pedidos.add(new Pedido(plato, bebida));
    }

    public double cobrar(Tarjeta t, Propina p) {
        return calcularPropina(p, calcularDescuento(t,
                calcularTotalPlatos(), calcularTotalBebidas()));
    }

    public double calcularDescuento(Tarjeta t, double mPl, double mBeb) {
        double monto = switch (t) {
            case VISA -> mPl + mBeb - 0.03 * mBeb;
            case MASTERCARD -> mPl + mBeb - 0.02 * mPl;
            case COMARCAPLUS -> mPl + mBeb - 0.02 * (mPl + mBeb);
            case OTRA -> mPl + mBeb;
        };
        return monto;
    }

    private double calcularTotalPlatos() {
        double v = 0;
        for (Pedido p : pedidos) {
            v += platos.get(p.getPlato());
        }
        return v;
    }

    private double calcularTotalBebidas() {
        double v = 0;
        for (Pedido p : pedidos) {
            v += bebidas.get(p.getBebida());
        }
        return v;
    }

    private double calcularPropina(Propina p, double t) {
        double total = switch (p) {
            case DOS -> t + 0.02 * t;
            case TRES -> t + 0.03 * t;
            case CINCO -> t + 0.05 * t;
        };
        return total;
    }

    public enum Tarjeta {
        VISA,
        MASTERCARD,
        COMARCAPLUS,
        OTRA
    }

    public enum Propina {
        DOS,
        TRES,
        CINCO
    }
}
