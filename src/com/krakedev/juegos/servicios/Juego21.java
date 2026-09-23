package com.krakedev.juegos.servicios;

import java.util.ArrayList;

import com.krakedev.juegos.entidades.Carta;
import com.krakedev.juegos.entidades.Jugador;

/*
 * Clase principal que contiene la lógica
 * del juego de 21.
 *
 * Esta clase administra:
 * - Los jugadores
 * - El Dealer
 * - Los valores de las cartas
 * - El reparto de cartas
 */
public class Juego21 {

    /*
     * Lista de jugadores que participan
     * en el juego.
     *
     * La inicializamos directamente para
     * poder agregar jugadores posteriormente.
     */
    private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();

    /*
     * Dealer encargado de manejar el naipe
     * y entregar las cartas.
     */
    private Dealer dealer;

    /*
     * Retorna la lista de jugadores.
     */
    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    /*
     * Permite reemplazar la lista de jugadores.
     */
    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    /*
     * Retorna el Dealer del juego.
     */
    public Dealer getDealer() {
        return dealer;
    }

    /*
     * Permite asignar un Dealer.
     */
    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    /*
     * Asigna el valorJuego de cada carta.
     *
     * Reglas:
     *
     * A = 11
     * J = 10
     * Q = 10
     * K = 10
     *
     * Las cartas numéricas mantienen
     * su propio valor.
     *
     * Ejemplo:
     * "8" -> 8
     */
    public void cargarValores() {

        /*
         * Recorremos todas las cartas
         * existentes en el naipe del Dealer.
         */
        for (Carta carta : dealer.getNaipe()) {

            /*
             * Recuperamos el valor de la carta.
             *
             * Ejemplos:
             * "A"
             * "5"
             * "J"
             */
            String valor = carta.getValor();

            /*
             * Si es un As, su valor en
             * el juego será 11.
             */
            if (valor.equals("A")) {

                carta.setValorJuego(11);

            /*
             * J, Q y K tienen un valor
             * de 10 puntos.
             */
            } else if (valor.equals("J")
                    || valor.equals("Q")
                    || valor.equals("K")) {

                carta.setValorJuego(10);

            } else {

                /*
                 * Si llegamos aquí significa
                 * que tenemos una carta numérica.
                 *
                 * Ejemplo:
                 *
                 * valor = "7"
                 *
                 * Integer.parseInt("7")
                 *
                 * convierte el String "7"
                 * en el número entero 7.
                 */
                int numero = Integer.parseInt(valor);

                carta.setValorJuego(numero);
            }
        }
    }

    /*
     * Inicializa los elementos necesarios
     * para comenzar el juego.
     */
    public void inicializar() {

        /*
         * Creamos el Dealer.
         *
         * Recuerda que el constructor de Dealer
         * genera automáticamente las 52 cartas.
         */
        dealer = new Dealer();

        /*
         * Después de crear el naipe,
         * asignamos el valorJuego de las cartas.
         */
        cargarValores();
    }

    /*
     * Agrega un jugador a la partida.
     */
    public void agregarJugador(Jugador jugador) {

        jugadores.add(jugador);
    }

    /*
     * Reparte una carta a un jugador específico.
     */
    public void repartirCarta(Jugador jugador) {

        /*
         * Pedimos una carta aleatoria al Dealer.
         *
         * entregarCarta() también elimina
         * esa carta del naipe.
         */
        Carta carta = dealer.entregarCarta();

        /*
         * Entregamos la carta obtenida
         * al jugador.
         */
        jugador.recibirCarta(carta);
    }

    /*
     * Reparte una carta a cada jugador
     * que participa en la partida.
     */
    public void repartirRonda() {

        /*
         * Recorremos todos los jugadores.
         */
        for (Jugador jugador : jugadores) {

            /*
             * A cada jugador le entregamos
             * exactamente una carta.
             */
            repartirCarta(jugador);
        }
    }
}