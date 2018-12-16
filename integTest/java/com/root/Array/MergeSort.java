package com.root.Array;

public class MergeSort {
  private int[] arr;
  private int[] tempArr;
  private int len;

  public void mergeSort(int[] nums) {
    arr = nums;
    len = nums.length;
    tempArr = new int[len];

    doMergeSort(0, len - 1);
  }

  private void doMergeSort(int lo, int hi) {
    if (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      doMergeSort(lo, mid);
      doMergeSort(mid+1, hi);
      merge(lo, mid, hi);
    }
  }

  private void merge(int lo, int mid, int hi) {
    for (int i=lo; i<= hi; i++) {
      tempArr[i] = arr[i];
    }
    int i=lo;
    int j = mid+1;
    int k = lo;
    while (i<=j && j<=hi) {
      if (tempArr[i] <= tempArr[j]) {
        arr[k] = tempArr[i];
        i++;
      } else {
        arr[k] = tempArr[j];
        j++;
      }
      k++;
    }

    while (i <= mid) {
      arr[k] = tempArr[i];
      k++;
      i++;
    }
  }
}
