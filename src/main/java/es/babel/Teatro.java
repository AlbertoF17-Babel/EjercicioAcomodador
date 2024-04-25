package es.babel;

import java.util.ArrayList;
import java.util.List;

public class Teatro {
    private Butaca[][] butacas;
    private int filas;
    private int butacasPorFila;

    public Teatro(int filas, int butacasPorFila) {
        this.filas = filas;
        this.butacasPorFila = butacasPorFila;
        this.butacas = new Butaca[filas][butacasPorFila];
        inicializarButacas();
    }

    private void inicializarButacas() {
        for (int i = 0; i < filas+1; i++) {
            if (i == 0){
                i++;
            }
            int j = 1;
            int numAsiento = 9;
            while (numAsiento != 1){
                if (numAsiento % 2 == 1) {
                    butacas[i-1][j-1] = new Butaca(i, numAsiento, false, false);
                    numAsiento-=2;
                }
                j++;
            }
            if (numAsiento == 1){
                while (numAsiento <= 10){
                    butacas[i-1][j-1] = new Butaca(i, numAsiento, false, false);
                    if (numAsiento == 1){
                        numAsiento++;
                    } else {
                        numAsiento+=2;
                    }
                    j++;
                }
            }
        }
    }

    public void marcarButaca(int fila, int numButaca) {
        for (Butaca[] filaButacas : butacas) {
            for (Butaca butaca : filaButacas) {
                if (butaca.equals(new Butaca(fila, numButaca, false, false))){
                    butaca.setOcupado(true);
                }
            }
        }
    }

    public void reservarButaca(int fila, int numButaca) {
        for (Butaca[] filaButacas : butacas) {
            for (Butaca butaca : filaButacas) {
                if (butaca.equals(new Butaca(fila, numButaca, false, false))){
                    butaca.setReservado(true);
                }
            }
        }
    }

    public void desmarcarButaca(int fila, int numButaca) {
        for (Butaca[] filaButacas : butacas) {
            for (Butaca butaca : filaButacas) {
                if (butaca.equals(new Butaca(fila, numButaca, false, false))){
                    butaca.setOcupado(false);
                }
            }
        }
    }

    public void mostrarEstado() {
        System.out.println("Estado del teatro:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < butacasPorFila; j++) {
                if (butacas[i][j].isOcupado()) {
                    System.out.print("[X]");
                } else if (butacas[i][j].isReservado()){
                        System.out.print("[R]");
                } else {
                    System.out.print("[ ]");
                }
            }
            System.out.println();
        }
    }

    public List<List<Butaca>> obtenerButacasContiguasLibres(int cantidad) {
        List<List<Butaca>> posibilidades = new ArrayList<>();

        for (int fila = 0; fila < filas; fila++) {
            List<Butaca> filaButacas = new ArrayList<>();
            int contador = 0;

            for (int butaca = 0; butaca < butacasPorFila; butaca++) {
                if (!butacas[fila][butaca].isOcupado()) {
                    contador++;
                    filaButacas.add(butacas[fila][butaca]);
                } else {
                    contador = 0;
                    filaButacas.clear();
                }

                if (contador == cantidad) {
                    posibilidades.add(new ArrayList<>(filaButacas));
                    contador = 0;
                    filaButacas.clear();
                }
            }
        }

        return posibilidades;
    }
}