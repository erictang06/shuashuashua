package com.root.Array;

import com.root.common.Helper;


public class QuickSort {
  private int[] arr;
  private int len;

  public void sort(int[] inputArr) {

    if (inputArr == null || inputArr.length == 0) {
      return;
    }
    arr = inputArr;
    len = inputArr.length;
    quickSort(0, len - 1);
  }

  private void quickSort(int lo, int hi) {
    int i = lo;
    int j = hi;
    int pivot = arr[(lo + hi)/2];

    while (i < j) {
      while (arr[i] < pivot) {
        i++;
      }
      while (arr[j] > pivot) {
        j--;
      }
      if (i <= j) {
        Helper.swap(arr, i, j);
        i++;
        j--;
      }
    }

    if (lo < j) {
      quickSort(lo, j);
    }
    if (i < hi) {
      quickSort(i, hi);
    }
  }
}
