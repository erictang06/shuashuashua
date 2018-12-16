package com.root.Array;

import com.root.common.Helper;


/**
 *
 Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order,
 not the kth distinct element.

 Example 1:
 Input: [3,2,1,5,6,4] and k = 2
 Output: 5
 Example 2:

 Input: [3,2,3,1,2,4,5,5,6] and k = 4
 Output: 4
 Note:
 You may assume k is always valid, 1 ≤ k ≤ array's length.
 */

public class FindKthLargestInUnsortedArray {
  //  https://leetcode.com/problems/kth-largest-element-in-an-array/discuss/60312/AC-Clean-QuickSelect-Java-solution-avg.-O(n)-time

  public int findKthLargest(int[] a, int k) {
    int n = a.length;
    int p = quickSelect(a, 0, n - 1, n - k + 1);
    return a[p];
  }

  // return the index of the kth smallest number
  int quickSelect(int[] a, int lo, int hi, int k) {
    // use quick sort's idea
    // put nums that are <= pivot to the left
    // put nums that are  > pivot to the right
    int i = lo;
    int j = hi;
    int pivot = a[hi];

    while (i < j) {
      if (a[i] > pivot) {
        Helper.swap(a, i, j-1);
        j--;
      } else {
        i++;
      }
    }
    Helper.swap(a, i, hi);

    // count the nums that are <= pivot from lo
    int m = i - lo + 1;
    if (m == k) {
      return i;
    } else if (m > k) {  // too big, target on the left side
      return quickSelect(a, lo, i-1, k);
    } else {  // too small, target on the right side
      return quickSelect(a, i+1, hi, k);
    }
  }
}
