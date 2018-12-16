package com.root.Array;

import com.root.common.Helper;


public class HeapSort {

  public void heapSort(int[] arr) {
    int len = arr.length;

    // build a heap, i.e., rearrange array
    for (int i=len/2-1; i>=0; i--) {
      heapify(arr, len, i);
    }

    // one by one extract element from heap
    for (int i=len-1; i>=0; i--) {
      // move current root to end
      Helper.swap(arr, i, 0);
      // call heapify on the reduced array
      heapify(arr, i, 0);
    }
  }

  // To heapify a subtree rooted with node i which is an index in arr[]. len is size of heap
  private void heapify(int arr[], int len, int i) {
    int largest = i;
    int left = 2*i + 1;
    int right = 2*i + 2;

    // left child is larger than root
    if (left < len && arr[left] > arr[largest]) {
      largest = left;
    }

    // right child is larger than root
    if (right < len && arr[right] > arr[largest]) {
      largest = right;
    }

    // if root is not largest
    if (largest != i) {
      Helper.swap(arr, i, largest);
      heapify(arr, len, largest);
    }
  }
}
