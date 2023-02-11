package com.example.cdmodelsort.sort;

/**
 * quickSort -
 * 
 * 快速排序算法通过多次比较和交换来实现排序，其排序流程如下： [2] (1)首先设定一个分界值，通过该分界值将数组分成左右两部分。 [2]
 * (2)将大于或等于分界值的数据集中到数组右边，小于分界值的数据集中到数组的左边。此时，左边部分中各元素都小于分界值，而右边部分中各元素都大于或等于分界值。
 * [2]
 * (3)然后，左边和右边的数据可以独立排序。对于左侧的数组数据，又可以取一个分界值，将该部分数据分成左右两部分，同样在左边放置较小值，右边放置较大值。右侧的数组数据也可以做类似处理。
 * [2]
 * (4)重复上述过程，可以看出，这是一个递归定义。通过递归将左侧部分排好序后，再递归排好右侧部分的顺序。当左、右两个部分各数据排序完成后，整个数组的排序也就完成了。
 *
 * @author 11131329
 * @version 1.0
 * @since 2023/1/5 9:24
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] a = new int[] { 5, 5, 2, 3, 6, 8, 9 };
        quickSort(a, 0, a.length - 1);

        for (int j : a) {
            System.out.println(j);
        }
    }

    public static void quickSort(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        final int partionPos = partion(a, low, high);
        // 向左递归
        quickSort(a, low, partionPos - 1);
        // 向右递归
        quickSort(a, partionPos + 1, high);

    }

    public static int partion(int[] a, int low, int high) {
        int privot = a[low];
        while (low < high) {
            while (low < high && a[high] >= privot) {
                high--;
            }
            a[low] = a[high];

            while (low < high & a[low] <= privot) {
                low++;
            }
            a[high] = a[low];
        }
        a[low] = privot;
        return low;
    }
}
