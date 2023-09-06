package ru.geekbrains.lesson1.store3D.models;

public class Angle3D {
    private int psi;
    private int teta;
    private int fi;

    public Angle3D() {
    }

    public Angle3D(int psi, int teta, int fi) {
        this.psi = psi;
        this.teta = teta;
        this.fi = fi;
    }

    public int getPsi() {
        return psi;
    }

    public void setPsi(int psi) {
        this.psi = psi;
    }

    public int getTeta() {
        return teta;
    }

    public void setTeta(int teta) {
        this.teta = teta;
    }

    public int getFi() {
        return fi;
    }

    public void setFi(int fi) {
        this.fi = fi;
    }

    @Override
    public String toString() {
        return "Angle3D{" +
                "psi=" + psi +
                ", teta=" + teta +
                ", fi=" + fi +
                '}';
    }
}
