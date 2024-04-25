package es.babel;

import java.util.List;
import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                Teatro teatro = new Teatro(9, 10);

                // Simular algunas butacas ocupadas
                teatro.marcarButaca(3, 5);
                teatro.marcarButaca(3, 6);
                teatro.marcarButaca(4, 1);
                teatro.marcarButaca(4, 2);
                teatro.marcarButaca(4, 3);
                teatro.marcarButaca(1, 1);


                // Ejercicio 1
                teatro.mostrarEstado();
                //La parte de asignar butacas automáticamente ha sido eliminada debido a la existencia de la
                //propia elección del usuario de las butacas a reservar en el ejercicio 2.

                // Ejercicio 2
                System.out.print("Indique el número de butacas que desea reservar, las pondremos juntas: ");
                int butacasRequeridas = sc.nextInt();
                List<List<Butaca>> posibilidades = teatro.obtenerButacasContiguasLibres(butacasRequeridas);
                System.out.println("\nPosibilidades de butacas contiguas libres de " + butacasRequeridas + " asientos:");

                int posibilidadNumero = 1;
                for (List<Butaca> fila : posibilidades) {
                        System.out.print("Posibilidad " + posibilidadNumero + ": Fila: "
                                + fila.getFirst().getNumFila() + ", Butacas: ");
                        for (Butaca butaca : fila) {
                                System.out.print(butaca.getNumAsiento() + ", ");
                        }
                        System.out.println();
                        posibilidadNumero++;
                }

                System.out.print("Ingrese el número de posibilidad que desea seleccionar: ");
                int selectedPosibilidadNumero = sc.nextInt();
                posibilidadNumero = 0;

                for (List<Butaca> fila : posibilidades) {
                        posibilidadNumero++;
                        if (posibilidadNumero == selectedPosibilidadNumero) {
                                for (Butaca butaca : fila) {
                                        butaca.setReservado(true);
                                }
                                teatro.mostrarEstado();
                                String respuesta;
                                sc.nextLine();
                                do{
                                        System.out.print("¿Quieres confirmar la reserva?(s/n): ");
                                        respuesta = sc.nextLine();
                                } while (!respuesta.equalsIgnoreCase("s") && !respuesta.equalsIgnoreCase("n"));

                                if (respuesta.equalsIgnoreCase("s")){
                                        System.out.println("Reserva completada correctamente");
                                        for (Butaca butaca : fila) {
                                                if (butaca.isReservado()){
                                                        butaca.setReservado(false);
                                                        butaca.setOcupado(true);
                                                }
                                        }
                                        System.out.println();
                                        teatro.mostrarEstado();
                                } else {
                                        System.out.println("Reserva cancelada");
                                        for (Butaca butaca : fila) {
                                                if (butaca.isReservado()){
                                                        butaca.setReservado(false);
                                                }
                                        }
                                        System.out.println();
                                        teatro.mostrarEstado();
                                }

                                System.out.println();
                        }
                }
        }
}