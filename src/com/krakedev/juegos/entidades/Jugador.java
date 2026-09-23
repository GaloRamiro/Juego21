package com.krakedev.juegos.entidades;

import java.util.ArrayList;

/*
 * Representa a un jugador dentro del juego 21.
 *
 * Cada jugador tendrá:
 * - un nickname
 * - una lista de cartas recibidas
 */
public class Jugador {

    /*
     * Nombre o apodo que identifica al jugador.
     *
     * Ejemplos:
     * "Galo"
     * "Jugador1"
     * "Pedro"
     */
    private String nickname;

    /*
     * Lista donde se almacenarán las cartas
     * que recibe el jugador durante el juego.
     *
     * El ejercicio indica que debemos inicializar
     * directamente el ArrayList en la declaración.
     */
    private ArrayList<Carta> cartas = new ArrayList<Carta>();

    /*
     * Retorna el nickname del jugador.
     */
    public String getNickname() {
        return nickname;
    }

    /*
     * Permite asignar el nickname del jugador.
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /*
     * Retorna la lista de cartas que tiene
     * actualmente el jugador.
     */
    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    /*
     * Permite reemplazar la lista de cartas
     * del jugador.
     */
    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }

    /*
     * Recibe una carta y la agrega a la lista
     * de cartas del jugador.
     *
     * Este método será utilizado posteriormente
     * por la clase Juego21.
     */
    public void recibirCarta(Carta carta) {

        /*
         * add() agrega el objeto Carta al final
         * del ArrayList.
         */
        cartas.add(carta);
    }
}