package com.root.String;

/*
Given two strings s and t, determine if they are both one edit distance apart.

Note:

There are 3 possiblities to satisify one edit distance apart:

Insert a character into s to get t
Delete a character from s to get t
Replace a character of s to get t
 */
public class OneEditDistance {
  public boolean isOneEditDistance(String s, String t) {
    // error/null checking

    if (Math.abs(s.length() - t.length()) > 1) {
      return false;
    }

    for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
      if (s.charAt(i) != t.charAt(i)) {
        if (s.length() == t.length()) {
          return s.substring(i + 1).equals(t.substring(i + 1));
        } else if (s.length() < t.length()) {
          return s.substring(i).equals(t.substring(i + 1));
        } else {
          return s.substring(i + 1).equals(t.substring(i));
        }
      }
    }

    return Math.abs(s.length() - t.length()) == 1;
  }

}
