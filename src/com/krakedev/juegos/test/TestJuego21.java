package com.krakedev.juegos.test;

import java.util.ArrayList;

import com.krakedev.juegos.entidades.Jugador;
import com.krakedev.juegos.servicios.Juego21;

/*
 * Prueba final del juego de 21.
 *
 * Se ejecutan varias partidas para comprobar
 * el comportamiento aleatorio del juego.
 */
public class TestJuego21 {

    public static void main(String[] args) {

        /*
         * Creamos el objeto principal del juego.
         */
        Juego21 juego = new Juego21();

        /*
         * Creamos el primer jugador.
         */
        Jugador jugador1 = new Jugador();
        jugador1.setNickname("Galo");

        /*
         * Creamos el segundo jugador.
         */
        Jugador jugador2 = new Jugador();
        jugador2.setNickname("Carlos");

        /*
         * Creamos el tercer jugador.
         */
        Jugador jugador3 = new Jugador();
        jugador3.setNickname("Ana");

        /*
         * Agregamos los tres jugadores al juego.
         *
         * Esto solamente se hace una vez.
         */
        juego.agregarJugador(jugador1);
        juego.agregarJugador(jugador2);
        juego.agregarJugador(jugador3);

        /*
         * Inicializamos el juego por primera vez.
         *
         * Esto crea el Dealer, genera las 52 cartas
         * y asigna los valores de juego.
         */
        juego.inicializar();

        /*
         * Ejecutaremos como máximo 10 partidas.
         *
         * Esto nos ayuda a comprobar el comportamiento
         * aleatorio del juego.
         */
        for (int i = 0; i < 10; i++) {

            System.out.println();
            System.out.println("============================");
            System.out.println("PARTIDA " + (i + 1));
            System.out.println("============================");

            /*
             * Ejecutamos la partida.
             *
             * jugar() realiza como máximo 3 rondas
             * y retorna los jugadores que llegaron
             * exactamente a 21 puntos.
             */
            ArrayList<Jugador> ganadores = juego.jugar();

            /*
             * Mostramos la información final
             * de todos los jugadores.
             */
            System.out.println();
            System.out.println("RESULTADOS:");

            for (Jugador jugador : juego.getJugadores()) {

                jugador.imprimir();

                System.out.println("--------------------");
            }

            /*
             * Comprobamos si encontramos
             * al menos un ganador.
             */
            if (ganadores.size() > 0) {

                System.out.println();
                System.out.println("GANADOR/ES:");

                /*
                 * Puede existir más de un ganador,
                 * por eso recorremos el ArrayList.
                 */
                for (Jugador ganador : ganadores) {

                    System.out.println(
                            ganador.getNickname()
                            + " con "
                            + ganador.getPuntajeCartas()
                            + " puntos"
                    );
                }

                /*
                 * Encontramos ganador, por lo tanto
                 * ya no necesitamos continuar
                 * ejecutando más partidas.
                 */
                break;
            }

            /*
             * Si no hubo ganador y todavía quedan
             * partidas por probar, reiniciamos.
             *
             * Los jugadores vuelven a:
             *
             * cartas = []
             * puntajeCartas = 0
             *
             * y el Dealer vuelve a tener 52 cartas.
             */
            if (i < 9) {

                System.out.println();
                System.out.println(
                        "No hubo ganador. Reiniciando juego..."
                );

                juego.reiniciarJuego();
            }
        }
    }
}