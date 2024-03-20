package org.unrn;

public class Mastercard implements Tarjeta {
    public double aplicarDescuento(double mPl, double mBeb) {
        double t = mPl + mBeb - 0.02 * mPl;
        return t;
    }
}