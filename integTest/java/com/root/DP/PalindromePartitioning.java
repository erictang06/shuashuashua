package com.root.DP;

import java.util.ArrayList;
import java.util.List;


public class PalindromePartitioning {

  /**
   * Given a string s, partition s such that every substring of the partition is a palindrome.
   Return all possible palindrome partitioning of s.

   Example:

   Input: "aab"
   Output:
   [
   ["aa","b"],
   ["a","a","b"]
   ]
   */

//  https://leetcode.com/problems/palindrome-partitioning/discuss/41963/Java:-Backtracking-solution
  public List<List<String>> partition(String s) {
    List<List<String>> lists = new ArrayList<>();
    List<String> list = new ArrayList<>();
    helper(lists, list, s, 0);
    return lists;
  }

  private void helper(List<List<String>> lists, List<String> list, String s, int start) {
    if (start >= s.length()) {
      List<String> alist = new ArrayList<>(list);
      lists.add(alist);
    }

    for (int i = start; i < s.length(); i++) {
      if (isPalindrome(s, start, i)) {
        list.add(s.substring(start, i + 1));
        helper(lists, list, s, i + 1);
        list.remove(list.size() - 1);
      }
    }
  }

  private boolean isPalindrome(String s, int start, int end) {
    if (start == end) {
      return true;
    }
    while (start < end) {
      if (s.charAt(start) != s.charAt(end)) {
        return false;
      }
      start++;
      end--;
    }

    return true;
  }

  /******************************************************/
  /*
Given a string s, partition s such that every substring of the partition is a palindrome.
Return the minimum cuts needed for a palindrome partitioning of s.

Example:

Input: "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
   */
  public int minCut(String s) {
    // dp[i] : mincut for string ending in index-i
    // isPalindrome[i][j]: substring(i,j) is palindrome or not
    // dp[i] =
//    https://leetcode.com/problems/palindrome-partitioning-ii/discuss/42199/My-DP-Solution-(-explanation-and-code)

    if (s == null || s.length() < 2) {
      return 0;
    }

    int[] dp = new int[s.length()];
    for (int i = 0; i < dp.length; i++) {
      dp[i] = i;
    }

    boolean[][] isPalindrome = new boolean[s.length()][s.length()];
    for (int right = 0; right < s.length(); right++) {
      isPalindrome[right][right] = true;
      for (int left = 0; left <= right; left++) {
        if (s.charAt(left) == s.charAt(right) && (right - left <= 1 || isPalindrome[left + 1][right - 1])) {
          if (left == 0) {
            dp[right] = 0;
          } else {
            isPalindrome[left][right] = true;
            dp[right] = Math.min(dp[right], dp[left - 1] + 1);
          }
        }
      }
    }

    return dp[s.length() - 1];
  }
}
