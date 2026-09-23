package com.krakedev.juegos.test;

import com.krakedev.juegos.entidades.Jugador;
import com.krakedev.juegos.servicios.Juego21;

/*
 * Clase de prueba para verificar el funcionamiento
 * inicial del juego de 21.
 *
 * En esta prueba:
 * 1. Creamos el juego.
 * 2. Creamos tres jugadores.
 * 3. Agregamos los jugadores al juego.
 * 4. Inicializamos el Dealer.
 * 5. Repartimos una carta a cada jugador.
 * 6. Imprimimos las cartas de los jugadores.
 * 7. Verificamos las cartas restantes del naipe.
 */
public class TestJuego21 {

    public static void main(String[] args) {

        /*
         * Creamos el objeto principal del juego.
         *
         * En este momento todavía no hemos
         * inicializado el Dealer.
         */
        Juego21 juego = new Juego21();

        /*
         * Creamos el primer jugador.
         */
        Jugador jugador1 = new Jugador();

        /*
         * Asignamos su nickname utilizando
         * el setter que creamos en Jugador.
         */
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
         * Agregamos los tres jugadores
         * al ArrayList de jugadores de Juego21.
         */
        juego.agregarJugador(jugador1);
        juego.agregarJugador(jugador2);
        juego.agregarJugador(jugador3);

        /*
         * Inicializamos el juego.
         *
         * Este método:
         * 1. Crea el Dealer.
         * 2. El Dealer genera las 52 cartas.
         * 3. cargarValores() asigna los valores
         *    correspondientes a cada carta.
         */
        juego.inicializar();

        /*
         * Mostramos la cantidad de cartas
         * antes de repartir.
         *
         * El resultado esperado es 52.
         */
        System.out.println("Cartas antes de repartir: "
                + juego.getDealer().getNaipe().size());

        /*
         * Repartimos una carta a cada jugador.
         *
         * Como tenemos tres jugadores,
         * el Dealer entregará tres cartas.
         */
        juego.repartirRonda();

        /*
         * Mostramos las cartas que recibió
         * cada jugador.
         */
        System.out.println();
        System.out.println("===== CARTAS DE LOS JUGADORES =====");

        jugador1.imprimir();

        System.out.println();

        jugador2.imprimir();

        System.out.println();

        jugador3.imprimir();

        /*
         * Como empezamos con 52 cartas y
         * entregamos una a cada uno de los
         * tres jugadores:
         *
         * 52 - 3 = 49
         *
         * Por lo tanto, deben quedar
         * 49 cartas en el naipe.
         */
        System.out.println();
        System.out.println("Cartas restantes en el naipe: "
                + juego.getDealer().getNaipe().size());

        /*
         * Finalmente imprimimos el naipe restante.
         *
         * Aquí podremos comprobar que las cartas
         * entregadas a los jugadores ya no
         * aparecen dentro del naipe.
         */
        System.out.println();
        System.out.println("===== NAIPE RESTANTE =====");

        juego.getDealer().imprimirNaipe();
    }
}