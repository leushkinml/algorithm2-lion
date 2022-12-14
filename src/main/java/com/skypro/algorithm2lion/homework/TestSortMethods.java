package com.skypro.algorithm2lion.homework;

import java.lang.reflect.Array;
import java.util.Random;

public class TestSortMethods {
    public static void main(String[] args) {

        Integer[] insertionIntegers1 = toRandomArray();
        Integer[] insertionIntegers2 = toRandomArray();
        Integer[] insertionIntegers3 = toRandomArray();

        Integer[] selectionIntegers1 = toRandomArray();
        Integer[] selectionIntegers2 = toRandomArray();
        Integer[] selectionIntegers3 = toRandomArray();

        Integer[] bubbleIntegers1 = toRandomArray();
        Integer[] bubbleIntegers2 = toRandomArray();
        Integer[] bubbleIntegers3 = toRandomArray();

        long start1 = System.currentTimeMillis();
        sortInsertion(insertionIntegers1);
        long result1 = System.currentTimeMillis() - start1;
        long start2 = System.currentTimeMillis();
        sortInsertion(insertionIntegers2);
        long result2 = System.currentTimeMillis() - start2;
        long start3 = System.currentTimeMillis();
        sortInsertion(insertionIntegers3);
        long result3 = System.currentTimeMillis() - start3;
        long insertionAverage = (result1 + result2 + result3)/3;
        System.out.println("Сортировка вставкой 1-ый тест: " + result1 +
                "\nСортировка вставкой 2-ой тест: " + result2 +
                "\nСортировка вставкой 3-ий тест: " + result3 +
                "\nСортировка вставкой усреднённое значение: " + insertionAverage);

        long start4 = System.currentTimeMillis();
        sortSelection(selectionIntegers1);
        long result4 = System.currentTimeMillis() - start4;
        long start5 = System.currentTimeMillis();
        sortSelection(selectionIntegers2);
        long result5 = System.currentTimeMillis() - start5;
        long start6 = System.currentTimeMillis();
        sortSelection(selectionIntegers3);
        long result6 = System.currentTimeMillis() - start6;
        long selectionAverage = (result4 + result5 + result6)/3;
        System.out.println("Сортировка выбором 1-ый тест: " + result4 +
                "\nСортировка выбором 2-ой тест: " + result5 +
                "\nСортировка выбором 3-ий тест: " + result6 +
                "\nСортировка выбором усреднённое значение: " + selectionAverage);

        long start7 = System.currentTimeMillis();
        sortBubble(bubbleIntegers1);
        long result7 = System.currentTimeMillis() - start7;
        long start8 = System.currentTimeMillis();
        sortBubble(bubbleIntegers2);
        long result8 = System.currentTimeMillis() - start8;
        long start9 = System.currentTimeMillis();
        sortBubble(bubbleIntegers3);
        long result9 = System.currentTimeMillis() - start9;
        long bubbleAverage = (result7 + result8 + result9)/3;
        System.out.println("Сортировка пузырьком 1-ый тест: " + result7 +
                "\nСортировка пузырьком 2-ой тест: " + result8 +
                "\nСортировка пузырьком 3-ий тест: " + result9 +
                "\nСортировка пузырьком усреднённое значение: " + bubbleAverage);
    }

    public static Integer[] toRandomArray() {
        Integer[] integers = new Integer[100000];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = new Random().nextInt(1000);
        }
        return integers;
    }
    private static void swapElements(Integer[] integers, Integer indexA, Integer indexB) {
        int tmp = integers[indexA];
        integers[indexA] = integers[indexB];
        integers[indexB] = tmp;
    }
    public static void sortBubble(Integer[] integers) {
        for (int i = 0; i < integers.length - 1; i++) {
            for (int j = 0; j < integers.length - 1 - i; j++) {
                if (integers[j] > integers[j + 1]) {
                    swapElements(integers, j, j + 1);
                }
            }
        }
    }

    public static void sortInsertion(Integer[] integers) {
        for (int i = 1; i < integers.length; i++) {
            int temp = integers[i];
            int j = i;
            while (j > 0 && integers[j - 1] >= temp) {
                integers[j] = integers[j - 1];
                j--;
            }
            integers[j] = temp;
        }
    }

    public static void sortSelection(Integer[] integers) {
        for (int i = 0; i < integers.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < integers.length; j++) {
                if (integers[j] < integers[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(integers, i, minElementIndex);
        }
    }
}
