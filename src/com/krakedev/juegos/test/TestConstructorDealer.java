package com.krakedev.juegos.test;

import com.krakedev.juegos.servicios.Dealer;

/*
 * Clase de prueba para verificar que el constructor
 * de Dealer genera correctamente el naipe.
 */
public class TestConstructorDealer {

    public static void main(String[] args) {

        /*
         * Creamos un objeto Dealer.
         *
         * Cuando hacemos new Dealer(), automáticamente
         * se ejecuta el constructor de Dealer.
         *
         * El constructor:
         * 1. Crea el ArrayList del naipe.
         * 2. Llama a generarNaipe().
         * 3. Genera las 52 cartas.
         */
        Dealer dealer = new Dealer();

        /*
         * Imprimimos todas las cartas que existen
         * actualmente dentro del naipe.
         */
        dealer.imprimirNaipe();

        /*
         * getNaipe() retorna el ArrayList de cartas.
         *
         * size() nos permite saber cuántos elementos
         * existen dentro del ArrayList.
         *
         * El resultado esperado es 52.
         */
        System.out.println("Cantidad de cartas: " + dealer.getNaipe().size());
    }
}