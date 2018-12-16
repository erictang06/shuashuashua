package com.root.DP;

/**
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 You have the following 3 operations permitted on a word:

 Insert a character
 Delete a character
 Replace a character
 */
public class WordDistance {

  // f[i][j]: distance for word1 at index i and word2 at index j
  // f[i][j] = f[i-1][j-1] if word1.charAt(i) == word2.charAt(j)
  // f[i][j] = 1 + min(f[i][j-1], f[i-1][j], f[i-1][j-1])
  public int minDistance(String word1, String word2) {
    if (word1.length() == 0 || word2.length() == 0) {
      return Math.max(word1.length(), word2.length());
    }

    int len1 = word1.length();
    int len2 = word2.length();
    int[][] cost = new int[len1 + 1][len2 + 1];
    for (int i = 0; i <= len2; i++) {
      cost[0][i] = i;
    }
    for (int j = 0; j <= len1; j++) {
      cost[j][0] = j;
    }

    for (int i = 1; i < len2 + 1; i++) {
      for (int j = 1; j < len1 + 1; j++) {
        if (word1.charAt(i) == word2.charAt(j)) {
          cost[i][j] = cost[i - 1][j - 1];
        } else {
          int insert = cost[i][j - 1];
          int delete = cost[i - 1][j];
          int replace = cost[i - 1][j - 1];
          cost[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
        }
      }
    }

    return cost[len1][len2];
  }
}
