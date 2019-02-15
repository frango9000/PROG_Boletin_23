package com.boletin23;

import java.util.Random;
import java.util.Scanner;

public class Metodos {

    public static Scanner scanner() {
        return new Scanner(System.in);
    }

    public static Random random() {
        return new Random();
    }

    public static int randomInt(int bound) {
        return random().nextInt(bound);
    }

    public static int randomInt() {
        return random().nextInt();
    }


    public static int[] randomIntsArray(int elements, int lowBound, int highBound) {
        int range = highBound - lowBound + 1;
        int[] randoms = new int[elements];
        for (int i = 0; i < randoms.length; i++) {
            randoms[i] = randomInt(range) + lowBound;
        }
        return randoms;
    }

    public static int[] randomIntsArray(int elements, int highBound) {
        return randomIntsArray(elements, 0, highBound);
    }

    public static int[] randomIntsArray(int elements) {
        return randomIntsArray(elements, elements);
    }

    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static int pedirPersonas() throws FueraDeRangoException {
        String personas;
        do {
            System.out.print("Cuantas personas? ");
            personas = scanner().next();
        } while (!isInteger(personas));
        int p = Integer.parseInt(personas);
        if (p > 50 || p < 0)
            throw new FueraDeRangoException("Numero de personas fuera de rango");
        return p;
    }
}
