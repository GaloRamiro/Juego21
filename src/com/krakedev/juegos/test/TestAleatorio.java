package com.krakedev.juegos.test;

import com.krakedev.juegos.servicios.Dealer;

/*
 * Clase utilizada para probar el método
 * generarAleatorio() de Dealer.
 */
public class TestAleatorio {

    public static void main(String[] args) {

        /*
         * Creamos un Dealer para poder utilizar
         * su método generarAleatorio().
         */
        Dealer dealer = new Dealer();

        /*
         * Este será el valor máximo permitido
         * para nuestra prueba.
         *
         * Los números deberán estar entre
         * 0 y 10.
         */
        int maximo = 10;

        /*
         * Estas variables nos permitirán comprobar
         * si durante las 100 pruebas apareció:
         *
         * - al menos un 0
         * - al menos un número igual al máximo
         */
        boolean aparecioCero = false;
        boolean aparecioMaximo = false;

        /*
         * Ejecutamos 100 veces el método
         * generarAleatorio().
         *
         * i comienza en 0.
         * El ciclo termina cuando i llega a 100.
         */
        for (int i = 0; i < 100; i++) {

            /*
             * Generamos un número aleatorio
             * entre 0 y maximo.
             */
            int numero = dealer.generarAleatorio(maximo);

            /*
             * Mostramos el número generado
             * para poder observar los resultados.
             */
            System.out.println("Número generado: " + numero);

            /*
             * Si encontramos un cero,
             * guardamos true.
             */
            if (numero == 0) {
                aparecioCero = true;
            }

            /*
             * Si encontramos el valor máximo,
             * guardamos true.
             */
            if (numero == maximo) {
                aparecioMaximo = true;
            }

            /*
             * Esta validación comprueba que nunca
             * se genere un número menor que 0
             * o mayor que el máximo permitido.
             */
            if (numero < 0 || numero > maximo) {
                System.out.println("ERROR: número fuera del rango");
            }
        }

        /*
         * Después de las 100 iteraciones mostramos
         * los resultados de las comprobaciones.
         */
        System.out.println("-------------------------");
        System.out.println("¿Apareció el 0?: " + aparecioCero);
        System.out.println("¿Apareció el máximo?: " + aparecioMaximo);
    }
}