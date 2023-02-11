package com.example.cdmodelsort;

/**
 * ArrayTest - TODO
 *
 * @author 11131329
 * @version 1.0
 * @since 2023/1/19 16:02
 */

public class ArrayTest {

  public static void main(String[] args) {
     int[] a = new int[10];
    for (int i = 0; i <a.length; i++) {
      System.out.println(a[i]);
//      a[i]++;
      a[i] =a[i]+1;
      System.out.println(a[i]);
    }
  }

}
