package es.babel;

import java.util.Objects;

class Butaca {
    private int numFila;
    private int numAsiento;
    private boolean ocupado;
    private boolean reservado;

    public Butaca(int numFila, int numAsiento, boolean ocupado, boolean reservado) {
        this.numFila = numFila;
        this.numAsiento = numAsiento;
        this.ocupado = ocupado;
        this.reservado = reservado;
    }

    public int getNumFila() {
        return numFila;
    }

    public int getNumAsiento() {
        return numAsiento;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public boolean isReservado() {
        return reservado;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Butaca butaca)) return false;
        return numFila == butaca.numFila && numAsiento == butaca.numAsiento;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numFila, numAsiento);
    }
}