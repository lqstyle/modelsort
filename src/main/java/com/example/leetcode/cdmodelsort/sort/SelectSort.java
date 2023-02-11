package com.example.cdmodelsort.sort;

/**
 * selectSort - select O(n^2)
 *
 * @author 11131329
 * @version 1.0
 * @since 2022/12/16 15:48
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] array = { 3, 8, 1, 2, 0 };
        selectSort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void selectSort(int[] array) {
        if (null == array || array.length == 0) {
            return;
        }

        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }

    }

}
