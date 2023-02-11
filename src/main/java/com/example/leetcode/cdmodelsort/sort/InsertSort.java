package com.example.cdmodelsort.sort;

/**
 * InsertSort - insert
 *
 * @author 11131329
 * @version 1.0
 * @since 2022/12/16 16:05
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] array = { 3, 8, 1, 2, 0 };
        insertSort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void insertSort(int[] array) {
        if (null == array || array.length == 0) {
            return;
        }

        int insertIndex = 0;
        int insertValue = 0;

        for (int i = 1; i < array.length; i++) {
            insertIndex = i - 1;
            insertValue = array[i];
            while (insertIndex >= 0 && insertValue < array[insertIndex]) {
                array[insertIndex + 1] = array[insertIndex];
                insertIndex--;
            }

            array[insertIndex + 1] = insertValue;
        }

    }
}
