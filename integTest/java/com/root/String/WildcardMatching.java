package com.root.String;

/**
 *
 Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.

 '?' Matches any single character.
 '*' Matches any sequence of characters (including the empty sequence).
 The matching should cover the entire input string (not partial).

 Note:

 s could be empty and contains only lowercase letters a-z.
 p could be empty and contains only lowercase letters a-z, and characters like ? or *.
 */
public class WildcardMatching {
  /*
  For each element in s
    If *s==*p or *p == ? which means this is a match, then goes to next element s++ p++.
    If p=='*', this is also a match, but one or many chars may be available, so let us save this *'s position and the matched s position.
    If not match, then we check if there is a * previously showed up,
       if there is no *,  return false;
       if there is an *,  we set current p to the next element of *, and set current s to the next saved s position.
   */
  public boolean comparison(String str, String pattern) {
    int s = 0, p = 0, match = 0, starIdx = -1;
    while (s < str.length()) {
      // advancing both pointers
      if (p < pattern.length() && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))) {
        s++;
        p++;
      } // * found, only advancing pattern pointer
      else if (p < pattern.length() && pattern.charAt(p) == '*') {
        starIdx = p;
        match = s;
        p++;
      } // last pattern pointer was *, advancing string pointer
      else if (starIdx != -1) {
        p = starIdx + 1;
        match++;
        s = match;
      } //current pattern pointer is not star, last patter pointer was not *
      //characters do not match
      else {
        return false;
      }
    }

    //check for remaining characters in pattern
    while (p < pattern.length() && pattern.charAt(p) == '*') {
      p++;
    }

    return p == pattern.length();
  }
}
