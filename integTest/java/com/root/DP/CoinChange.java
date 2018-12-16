package com.root.DP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 *
 You are given coins of different denominations and a total amount of money amount. Write a function to compute the
 fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any
 combination of the coins, return -1.

 Example 1:

 Input: coins = [1, 2, 5], amount = 11
 Output: 3
 Explanation: 11 = 5 + 5 + 1
 Example 2:

 Input: coins = [2], amount = 3
 Output: -1
 */
public class CoinChange {
  public int coinChange(int[] coins, int amount) {
    // f[i]: smallest # of coins for amount i
    // f[i+1] = min{1+f[i-1], 1+f[i-2], ...}

    int[] dp = new int[amount+1];
    Arrays.fill(dp, -1);
    dp[0] = 0;
    for (int i=1; i<=amount; i++) {
      int curMin = Integer.MAX_VALUE;
      for (int coin : coins) {
        if (i >= coin && dp[i-coin] != -1) {
          curMin = Math.min(curMin, dp[i-coin] + 1);
        }
      }
      if (curMin != Integer.MAX_VALUE) {
        dp[i] = curMin;
      }
    }

    return dp[amount];
  }

  // coin change 2
  /*
  You are given coins of different denominations and a total amount of money. Write a function to compute the number of
  combinations that make up that amount. You may assume that you have infinite number of each kind of coin.
   */

  public int change(int amount, int[] coins) {
    // dp[i] = sum{dp[amount-coins[j]]}
    int[] dp = new int[amount + 1];
    dp[0] = 1;
    for (int coin : coins) {
      for (int i=1; i<=amount; i++) {
        if (i - coin >= 0) {
          dp[i] += dp[i-coin];
        }
      }
    }

    return dp[amount];
  }

  // find all combinations
  private void v3() {
    int goal = 50;
    int [] coins = new int [] {25, 10, 5};

    // for formatting the string outputs
    Map<Integer, String> names = new HashMap<Integer, String>();
    names.put(25, "quarter(s)");
    names.put(10, "dime(s)");
    names.put(5, "nickel(s)");

    // to keep track of the current amounts of each type of coin
    Map<String, Integer> curr = new HashMap<String, Integer>();
    curr.put(names.get(25), 0);
    curr.put(names.get(10), 0);
    curr.put(names.get(5), 0);

    findCoins(goal, 0, coins, names, curr);
  }

  /*
      recursive function to print all combinations of coins that sum to goal
      @param left - amount left that we need to sum to with remaining coins
      @param index - index of current coin denomination we are working with
      @param coins - array of coin values
      @param names - map of names for string formatting
      @param curr - current amounts of each type of coin we have
  */
  private static void findCoins(int left, int index, int [] coins, Map<Integer, String> names, Map<String, Integer> curr) {
    // not the last type of coin
    if (index < coins.length - 1) {
      // if we have not reached our goal value yet
      if (left > 0) {
        int coinAmount = coins[index];
        if (coinAmount <= left) {
          // try all possible numbers of current coin given the amount
          // that is left
          for (int i = 0; i <= left / coinAmount; i++) {
            curr.put(names.get(coinAmount), i);
            findCoins(left - coinAmount * i, index + 1, coins, names, curr);
          }
          // reset the current coin amount to zero before recursing
          curr.put(names.get(coinAmount), 0);
        }
        // case when there is a coin whose value is greater than the goal
        else {
          findCoins(left, index + 1, coins, names, curr);
        }
      }
      // we've reached our goal, print out the current coin amounts
      else {
        printCurr(curr);
      }
    }
    // last type of coin
    else {
      // if we have not reached our goal value yet
      if (left > 0) {
        int coinAmount = coins[index];
        if (coinAmount <= left) {
          // if the remainder of our goal is evenly divisble by our last
          // coin value, we can make the goal amount
          if (left % coinAmount == 0) {
            // add last coin amount and print current values out
            curr.put(names.get(coinAmount), left / coinAmount);
            printCurr(curr);

            // reset this coin amount to zero before recursing
            curr.put(names.get(coinAmount), 0);
          }
        }
      }
      // we've reached our goal, print out the current coin amounts
      else {
        printCurr(curr);
      }
    }
  }

  private static void printCurr(Map<String, Integer> curr) {
    Iterator<String> iter = curr.keySet().iterator();
    while (iter.hasNext()) {
      String denom = iter.next();
      System.out.print(curr.get(denom) + " " + denom + " ");
    }
    System.out.println();
  }
}
