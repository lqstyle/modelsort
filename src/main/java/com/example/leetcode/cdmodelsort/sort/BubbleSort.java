package com.example.cdmodelsort.sort;

/**
 * BubbleSort - bubble  O(n^2)
 *
 * @author 11131329
 * @version 1.0
 * @since 2022/12/16 15:38
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] array = { 3, 8, 1, 2, 0 };
        bubbleSort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void bubbleSort(int[] array) {
        if (null == array || array.length == 0) {
            return;
        }
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

}
