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
	 * Lista de jugadores que participan en el juego.
	 *
	 * La inicializamos directamente para poder agregar jugadores posteriormente.
	 */
	private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();

	/*
	 * Dealer encargado de manejar el naipe y entregar las cartas.
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
	 * A = 11 J = 10 Q = 10 K = 10
	 *
	 * Las cartas numéricas mantienen su propio valor.
	 *
	 * Ejemplo: "8" -> 8
	 */
	public void cargarValores() {

		/*
		 * Recorremos todas las cartas existentes en el naipe del Dealer.
		 */
		for (Carta carta : dealer.getNaipe()) {

			/*
			 * Recuperamos el valor de la carta.
			 *
			 * Ejemplos: "A" "5" "J"
			 */
			String valor = carta.getValor();

			/*
			 * Si es un As, su valor en el juego será 11.
			 */
			if (valor.equals("A")) {

				carta.setValorJuego(11);

				/*
				 * J, Q y K tienen un valor de 10 puntos.
				 */
			} else if (valor.equals("J") || valor.equals("Q") || valor.equals("K")) {

				carta.setValorJuego(10);

			} else {

				/*
				 * Si llegamos aquí significa que tenemos una carta numérica.
				 *
				 * Ejemplo:
				 *
				 * valor = "7"
				 *
				 * Integer.parseInt("7")
				 *
				 * convierte el String "7" en el número entero 7.
				 */
				int numero = Integer.parseInt(valor);

				carta.setValorJuego(numero);
			}
		}
	}

	/*
	 * Inicializa los elementos necesarios para comenzar el juego.
	 */
	public void inicializar() {

		/*
		 * Creamos el Dealer.
		 *
		 * Recuerda que el constructor de Dealer genera automáticamente las 52 cartas.
		 */
		dealer = new Dealer();

		/*
		 * Después de crear el naipe, asignamos el valorJuego de las cartas.
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
		 * entregarCarta() también elimina esa carta del naipe.
		 */
		Carta carta = dealer.entregarCarta();

		/*
		 * Entregamos la carta obtenida al jugador.
		 */
		jugador.recibirCarta(carta);
	}

	/*
	 * Reparte una carta a cada jugador y después actualiza sus puntajes.
	 */
	public void repartirRonda() {

		/*
		 * Entregamos una carta a cada jugador.
		 */
		for (Jugador jugador : jugadores) {

			repartirCarta(jugador);
		}

		/*
		 * Después de que todos recibieron su carta, volvemos a calcular sus puntajes.
		 */
		calcularTotal();
	}

	/*
	 * Calcula el puntaje total de las cartas de cada jugador.
	 *
	 * El método recorre todos los jugadores y suma el valorJuego de sus cartas.
	 */
	public void calcularTotal() {

		/*
		 * Primer for: recorremos todos los jugadores que participan en la partida.
		 */
		for (Jugador jugador : jugadores) {

			/*
			 * Esta variable acumulará los puntos de las cartas del jugador actual.
			 *
			 * IMPORTANTE: debe comenzar en 0 para cada jugador.
			 */
			int total = 0;

			/*
			 * Segundo for: recorremos todas las cartas que tiene el jugador actual.
			 */
			for (Carta carta : jugador.getCartas()) {

				/*
				 * Obtenemos el valorJuego de la carta y lo acumulamos en total.
				 *
				 * Esto:
				 *
				 * total += carta.getValorJuego();
				 *
				 * significa lo mismo que:
				 *
				 * total = total + carta.getValorJuego();
				 */
				total += carta.getValorJuego();
			}

			/*
			 * Cuando terminamos de recorrer todas las cartas del jugador, guardamos el
			 * resultado.
			 */
			jugador.setPuntajeCartas(total);
		}
	}

	/*
	 * Busca los jugadores que tienen exactamente 21 puntos.
	 *
	 * El método retorna un ArrayList<Jugador> porque puede existir:
	 *
	 * - ningún ganador - un ganador - varios ganadores
	 */
	public ArrayList<Jugador> validarGanador() {

		/*
		 * Creamos una lista vacía donde vamos a guardar únicamente a los jugadores que
		 * tengan 21 puntos.
		 */
		ArrayList<Jugador> ganadores = new ArrayList<Jugador>();

		/*
		 * Recorremos todos los jugadores que participan en el juego.
		 */
		for (Jugador jugador : jugadores) {

			/*
			 * Consultamos el puntaje del jugador.
			 *
			 * Si tiene exactamente 21 puntos, significa que es ganador.
			 */
			if (jugador.getPuntajeCartas() == 21) {

				/*
				 * Agregamos el objeto Jugador a la lista de ganadores.
				 */
				ganadores.add(jugador);
			}
		}

		/*
		 * Después de revisar todos los jugadores, retornamos la lista.
		 *
		 * Si nadie tiene 21, la lista estará vacía.
		 */
		return ganadores;
	}

	/*
	 * Ejecuta una partida del juego 21.
	 *
	 * La partida tendrá como máximo 3 rondas.
	 *
	 * En cada ronda: 1. Se reparte una carta a cada jugador. 2. Se calculan
	 * automáticamente los puntajes. 3. Se buscan jugadores con exactamente 21
	 * puntos. 4. Si existe al menos un ganador, el juego se detiene.
	 *
	 * Finalmente retorna la lista de ganadores.
	 */
	public ArrayList<Jugador> jugar() {

		/*
		 * Creamos una lista vacía para almacenar los jugadores que logren llegar a 21.
		 */
		ArrayList<Jugador> ganadores = new ArrayList<Jugador>();

		/*
		 * Ejecutamos como máximo 3 rondas.
		 *
		 * i empieza en 0.
		 *
		 * Las iteraciones serán: i = 0 -> primera ronda i = 1 -> segunda ronda i = 2 ->
		 * tercera ronda
		 */
		for (int i = 0; i < 3; i++) {

			/*
			 * Repartimos una carta a cada jugador.
			 *
			 * Recuerda que repartirRonda() también llama a calcularTotal().
			 */
			repartirRonda();

			/*
			 * Después de repartir las cartas, buscamos jugadores que tengan exactamente 21
			 * puntos.
			 */
			ganadores = validarGanador();

			/*
			 * size() nos indica cuántos elementos existen dentro del ArrayList.
			 *
			 * Si es mayor que 0 significa que encontramos al menos un ganador.
			 */
			if (ganadores.size() > 0) {

				/*
				 * break permite terminar inmediatamente el ciclo for.
				 *
				 * Ya no necesitamos continuar repartiendo porque encontramos un ganador.
				 */
				break;
			}
		}

		/*
		 * Retornamos la lista de ganadores.
		 *
		 * Puede retornar:
		 *
		 * [] -> ningún ganador [Jugador] -> un ganador [Jugador, ...] -> varios
		 * ganadores
		 */
		return ganadores;
	}
	/*
	 * Prepara el juego para comenzar una nueva partida.
	 *
	 * Reinicia las cartas y los puntos de todos
	 * los jugadores y crea nuevamente el naipe.
	 */
	public void reiniciarJuego() {

	    /*
	     * Recorremos todos los jugadores registrados.
	     */
	    for (Jugador jugador : jugadores) {

	        /*
	         * Eliminamos sus cartas y colocamos
	         * su puntaje nuevamente en cero.
	         */
	        jugador.reiniciar();
	    }

	    /*
	     * inicializar() crea un Dealer nuevo.
	     *
	     * Al crear un Dealer nuevo obtenemos
	     * nuevamente las 52 cartas.
	     *
	     * También se vuelven a cargar los valores
	     * de las cartas.
	     */
	    inicializar();
	}
}