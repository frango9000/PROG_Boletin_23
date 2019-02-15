package com.boletin23;

/*
		           BOLETIN 23

Un cinema dun pobo pequeno proponnos facer unha aplicación para controlar
as persoas dunha cola dun cinema nas grandes estreas de películas.

Un conxunto de persoas esperan a cola para sacar unha entrada, teremos que
calcular a entrada segundo a idade da persoa (mínimo 5 anos).

A idade das persoas xéranse aleatoriamente entre 5 e 60 anos.

 Ao final, deberemos mostrar a cantidade total recadada.

 O número de persoas da cola debe ser entre  0 e 50.Se o número non está
 entre estes 2 valores lanza unha excepción (foraDeRangoExcepcion), que
 nos indique que estamos fora do rango requerido


A lista de prezos é :
Entre 5- 10  anos 1 €
Entre 11-17  2,50 €
Maior de 18  3,50 €
 */

import java.sql.SQLOutput;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        int personas = 0;
        do {
            try {
                personas = Metodos.pedirPersonas();
            } catch (FueraDeRangoException e) {
                System.out.println(e.getMessage());
            }
        } while (personas < 1);

        int[] edades = Metodos.randomIntsArray(personas, 5, 60);
        LinkedList<Integer> entradas = new LinkedList<>();

        float caja = 0;
        for (int i = 0; i < edades.length; i++) {
            entradas.add(edades[i]);
            if (entradas.get(i) >= 5 && entradas.get(i) <= 10) {
                caja += 1f;
            } else if (entradas.get(i) <= 17) {
                caja += 2.5f;
            } else if (entradas.get(i) > 17) {
                caja += 3.5f;
            }
        }
        System.out.printf("%.2f € de caja", caja);

    }
}
