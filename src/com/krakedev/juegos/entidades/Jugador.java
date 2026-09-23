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
	 * Ejemplos: "Galo" "Jugador1" "Pedro"
	 */
	private String nickname;
	/*
	 * Guarda la suma total de los puntos de las cartas que tiene el jugador.
	 *
	 * Ejemplo: A = 11 J = 10
	 *
	 * puntajeCartas = 21
	 */
	private int puntajeCartas;

	/*
	 * Retorna el puntaje total que tiene actualmente el jugador.
	 */
	public int getPuntajeCartas() {
		return puntajeCartas;
	}

	/*
	 * Permite asignar el puntaje total de las cartas del jugador.
	 */
	public void setPuntajeCartas(int puntajeCartas) {
		this.puntajeCartas = puntajeCartas;
	}

	/*
	 * Lista donde se almacenarán las cartas que recibe el jugador durante el juego.
	 *
	 * El ejercicio indica que debemos inicializar directamente el ArrayList en la
	 * declaración.
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
	 * Retorna la lista de cartas que tiene actualmente el jugador.
	 */
	public ArrayList<Carta> getCartas() {
		return cartas;
	}

	/*
	 * Permite reemplazar la lista de cartas del jugador.
	 */
	public void setCartas(ArrayList<Carta> cartas) {
		this.cartas = cartas;
	}

	/*
	 * Recibe una carta y la agrega a la lista de cartas del jugador.
	 *
	 * Este método será utilizado posteriormente por la clase Juego21.
	 */
	public void recibirCarta(Carta carta) {

		/*
		 * add() agrega el objeto Carta al final del ArrayList.
		 */
		cartas.add(carta);
	}

	/*
	 * Imprime el nickname, las cartas y el puntaje actual del jugador.
	 */
	public void imprimir() {

		/*
		 * Mostramos el nickname.
		 */
		System.out.println("Jugador: " + nickname);

		/*
		 * Recorremos e imprimimos las cartas que tiene el jugador.
		 */
		for (Carta carta : cartas) {

			carta.imprimir();
		}

		/*
		 * Finalmente mostramos el puntaje total calculado.
		 */
		System.out.println("Puntaje total: " + puntajeCartas);
	}

	/*
	 * Reinicia los datos del jugador para comenzar una nueva partida.
	 *
	 * Se eliminan todas sus cartas y su puntaje vuelve a cero.
	 */
	public void reiniciar() {

		/*
		 * clear() elimina todos los elementos almacenados en el ArrayList.
		 *
		 * El jugador conserva su nickname, pero se queda sin cartas.
		 */
		cartas.clear();

		/*
		 * Reiniciamos el puntaje para que la nueva partida comience desde cero.
		 */
		puntajeCartas = 0;
	}
}