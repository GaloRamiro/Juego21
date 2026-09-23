package com.krakedev.juegos.test;

import java.util.ArrayList;

import com.krakedev.juegos.entidades.Jugador;
import com.krakedev.juegos.servicios.Juego21;

public class TestJuego21 {

    public static void main(String[] args) {

        /*
         * Códigos ANSI para colocar colores
         * en los mensajes de la consola.
         *
         * RESET permite regresar al color normal.
         */
        String RESET = "\u001B[0m";
        String ROJO = "\u001B[31m";
        String VERDE = "\u001B[32m";
        String AMARILLO = "\u001B[33m";
        String AZUL = "\u001B[34m";
        String MORADO = "\u001B[35m";
        String CYAN = "\u001B[36m";

        /*
         * Creamos el objeto principal del juego.
         */
        Juego21 juego = new Juego21();

        /*
         * Creamos los tres jugadores.
         */
        Jugador jugador1 = new Jugador();
        jugador1.setNickname("Galo");

        Jugador jugador2 = new Jugador();
        jugador2.setNickname("Carlos");

        Jugador jugador3 = new Jugador();
        jugador3.setNickname("Ana");

        /*
         * Agregamos los jugadores al juego.
         */
        juego.agregarJugador(jugador1);
        juego.agregarJugador(jugador2);
        juego.agregarJugador(jugador3);

        /*
         * Inicializamos el Dealer y las 52 cartas.
         */
        juego.inicializar();

        /*
         * Ejecutamos como máximo 10 partidas.
         */
        for (int i = 0; i < 10; i++) {

            /*
             * CYAN será utilizado para identificar
             * el inicio de cada partida.
             */
            System.out.println();
            System.out.println(CYAN
                    + "===================================="
                    + RESET);

            System.out.println(CYAN
                    + "          PARTIDA " + (i + 1)
                    + RESET);

            System.out.println(CYAN
                    + "===================================="
                    + RESET);

            /*
             * Ejecutamos el juego.
             *
             * jugar() puede realizar hasta
             * tres rondas.
             */
            ArrayList<Jugador> ganadores = juego.jugar();

            /*
             * AMARILLO identifica la sección
             * donde mostramos los resultados.
             */
            System.out.println();
            System.out.println(AMARILLO
                    + "========== RESULTADOS =========="
                    + RESET);

            /*
             * Recorremos todos los jugadores.
             */
            for (Jugador jugador : juego.getJugadores()) {

                /*
                 * AZUL identifica el nombre
                 * del jugador.
                 */
                System.out.println();
                System.out.println(AZUL
                        + "Jugador: "
                        + jugador.getNickname()
                        + RESET);

                /*
                 * Imprimimos las cartas que
                 * recibió el jugador.
                 */
                jugador.getCartas().forEach(carta -> carta.imprimir());

                /*
                 * MORADO identifica el puntaje
                 * total obtenido.
                 */
                System.out.println(MORADO
                        + "Puntaje total: "
                        + jugador.getPuntajeCartas()
                        + RESET);

                System.out.println("----------------------------");
            }

            /*
             * Si existen ganadores,
             * los mostramos en VERDE.
             */
            if (ganadores.size() > 0) {

                System.out.println();
                System.out.println(VERDE
                        + "========== GANADOR/ES =========="
                        + RESET);

                /*
                 * Recorremos la lista porque puede
                 * existir más de un ganador.
                 */
                for (Jugador ganador : ganadores) {

                    System.out.println(VERDE
                            + "GANADOR: "
                            + ganador.getNickname()
                            + " con "
                            + ganador.getPuntajeCartas()
                            + " puntos"
                            + RESET);
                }

                /*
                 * Como encontramos ganador,
                 * detenemos el ciclo.
                 */
                break;

            } else {

                /*
                 * Si nadie consiguió 21,
                 * mostramos el mensaje en ROJO.
                 */
                System.out.println();
                System.out.println(ROJO
                        + "No hubo ganador en esta partida."
                        + RESET);
            }

            /*
             * Si todavía quedan intentos,
             * reiniciamos el juego.
             */
            if (i < 9) {

                System.out.println(AMARILLO
                        + "Reiniciando juego..."
                        + RESET);

                juego.reiniciarJuego();
            }
        }
    }
}