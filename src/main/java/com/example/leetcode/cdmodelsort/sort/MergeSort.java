package com.example.cdmodelsort.sort;

/**
 * MergeSort - 归并排序
 *
 * @author 11131329
 * @version 1.0
 * @since 2023/1/11 16:17
 *
 * master 公式  T(N) = a*T(N/b) + O(N^d)
 * d<logb a  O(N^logb a)
 * d>logb a  O(N^d)
 * d= logb a O(n+logn)
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] a = new int[] { 5, 5, 2, 3, 6, 8, 9 };
        mergeSort(a, 0, a.length - 1);

        for (int j : a) {
            System.out.println(j);
        }
    }

    private static void mergeSort(int[] a, int left, int right) {
        if (left == right) {
            return;
        }
        int middle = left + ((right - left) >> 1);
        mergeSort(a, left, middle);
        mergeSort(a, middle + 1, right);
        sort(a, left, middle, right);
    }

    private static void sort(int[] a, int left, int middle, int right) {
        int[] temp = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = middle + 1;
        while (p1 <= middle && p2 <= right) {
            temp[i++] = a[p1] <= a[p2] ? a[p1++] : a[p2++];
        }
        while (p1 <= middle) {
            temp[i++] = a[p1++];
        }
        while (p2 <= right) {
            temp[i++] = a[p2++];
        }

        for (int j = 0; j < temp.length; j++) {
            a[left + j] = temp[j];
        }
    }
}
