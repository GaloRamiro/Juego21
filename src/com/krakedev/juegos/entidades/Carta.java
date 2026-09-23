package com.krakedev.juegos.entidades;

/*
 * Representa una carta del juego 21.
 * Cada carta tiene un valor, un valor para el juego
 * y un palo.
 */
public class Carta {

    // Valor visible de la carta.
    // Ejemplos: "A", "2", "10", "J", "Q", "K".
    private String valor;

    // Valor numérico que tendrá la carta durante el juego.
    // En este punto todavía NO lo asignamos.
    private int valorJuego;

    // Palo de la carta:
    // T  = Trébol
    // CN = Corazón Negro
    // CR = Corazón Rojo
    // D  = Diamante
    private String palo;

    /*
     * Retorna el valor de la carta.
     */
    public String getValor() {
        return valor;
    }

    /*
     * Asigna el valor de la carta.
     */
    public void setValor(String valor) {
        this.valor = valor;
    }

    /*
     * Retorna el valor numérico de la carta
     * utilizado en el juego 21.
     */
    public int getValorJuego() {
        return valorJuego;
    }

    /*
     * Asigna el valor numérico de la carta.
     */
    public void setValorJuego(int valorJuego) {
        this.valorJuego = valorJuego;
    }

    /*
     * Retorna el palo de la carta.
     */
    public String getPalo() {
        return palo;
    }

    /*
     * Asigna el palo de la carta.
     */
    public void setPalo(String palo) {
        this.palo = palo;
    }

    /*
     * Muestra en consola todos los atributos de la carta.
     */
    public void imprimir() {
        System.out.println(
                "Valor: " + valor
                + " | Valor Juego: " + valorJuego
                + " | Palo: " + palo
        );
    }
}