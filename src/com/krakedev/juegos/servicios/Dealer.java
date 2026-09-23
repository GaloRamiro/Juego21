package com.krakedev.juegos.servicios;

import java.util.ArrayList;

import com.krakedev.juegos.entidades.Carta;

/*
 * La clase Dealer representa al repartidor del juego.
 * 
 * El Dealer será responsable de manejar el naipe
 * que contiene todas las cartas.
 */
public class Dealer {

    /*
     * ArrayList que almacena las cartas del naipe.
     * 
     * Como usamos <Carta>, significa que esta lista
     * solamente puede guardar objetos de tipo Carta.
     */
    private ArrayList<Carta> naipe;

    /*
     * Constructor de Dealer.
     * 
     * Este código se ejecuta automáticamente
     * cuando hacemos:
     *
     * Dealer dealer = new Dealer();
     */
    public Dealer() {

        // Creamos el ArrayList vacío donde estarán las cartas.
        naipe = new ArrayList<Carta>();

        // Generamos automáticamente las 52 cartas.
        generarNaipe();
    }

    /*
     * Retorna el ArrayList que contiene el naipe.
     */
    public ArrayList<Carta> getNaipe() {
        return naipe;
    }

    /*
     * Permite reemplazar el ArrayList del naipe.
     */
    public void setNaipe(ArrayList<Carta> naipe) {
        this.naipe = naipe;
    }

    /*
     * Genera las 52 cartas del naipe.
     *
     * Tenemos:
     * 13 valores diferentes
     * 4 palos diferentes
     *
     * 13 x 4 = 52 cartas.
     */
    public void generarNaipe() {

        /*
         * Creamos una lista auxiliar para guardar
         * los cuatro palos.
         */
        ArrayList<String> palos = new ArrayList<String>();

        palos.add("T");
        palos.add("CN");
        palos.add("CR");
        palos.add("D");

        /*
         * Creamos otra lista auxiliar para guardar
         * los 13 posibles valores de una carta.
         */
        ArrayList<String> valores = new ArrayList<String>();

        valores.add("A");
        valores.add("2");
        valores.add("3");
        valores.add("4");
        valores.add("5");
        valores.add("6");
        valores.add("7");
        valores.add("8");
        valores.add("9");
        valores.add("10");
        valores.add("J");
        valores.add("Q");
        valores.add("K");

        /*
         * Primer for:
         * recorre cada palo.
         *
         * Primero T, después CN, después CR y finalmente D.
         */
        for (String palo : palos) {

            /*
             * Segundo for:
             * por cada palo recorremos los 13 valores.
             */
            for (String valor : valores) {

                /*
                 * Creamos una carta nueva.
                 */
                Carta carta = new Carta();

                /*
                 * Asignamos el valor.
                 * Ejemplos:
                 * A, 2, 3, ..., J, Q, K
                 */
                carta.setValor(valor);

                /*
                 * Asignamos el palo correspondiente.
                 */
                carta.setPalo(palo);

                /*
                 * IMPORTANTE:
                 * todavía NO asignamos valorJuego.
                 *
                 * Eso se hará posteriormente en Juego21.
                 */

                /*
                 * Finalmente agregamos la carta
                 * al naipe del Dealer.
                 */
                naipe.add(carta);
            }
        }
    }

    /*
     * Recorre todas las cartas que existen
     * actualmente en el naipe.
     */
    public void imprimirNaipe() {

        /*
         * Foreach:
         * en cada vuelta obtenemos una Carta
         * almacenada en el ArrayList.
         */
        for (Carta carta : naipe) {

            /*
             * Utilizamos el método imprimir()
             * que creamos en la clase Carta.
             */
            carta.imprimir();
        }
    }
}