package com.root.common;

public class Helper {

  /**
   * Helper to swap two numbers in array
   * @param arr
   * @param i
   * @param j
   */
  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  /**
   * Helper to print an array
   * @param arr
   */
  public static void printArray(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n; ++i) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }
}
