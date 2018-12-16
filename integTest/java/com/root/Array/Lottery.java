package com.root.Array;

import java.util.Random;


/**
 * 题目是给一个lottery system和若干互不重叠的interval，求落在interval之间的一个随机数。
 比如[5, 10], [20, 36], ... 返回落在区间内的随机数，且他们出现的概率相等。
 */
public class Lottery {
  int getRandom(int[][] intervals) {
    int res = 0;
    int len = 0;
    Random rand = new Random();
    for (int i = 0; i < intervals.length; i++) {
      int[] interval = intervals[i];
      int range = interval[1] - interval[0] + 1;
      int index = rand.nextInt(range + len);
      if (index >= len) {
        res = interval[0] + rand.nextInt(range);
      }
      len += range;
    }
    return res;
  }
}
