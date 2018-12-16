package com.root.String;

public class CountAndSay {

  public String countAndSay(int n) {
    String result = "1";
    for (int i=1; i<=n; i++) {
      result = helper(result);
    }
    return result;
  }

  private String helper(String numString) {
    String resultStr = "";
    int i = 0;
    while (i < numString.length()) {
      int j = 0;
      while (i + j < numString.length() && numString.charAt(i + j) == numString.charAt(i)) {
        j++;
      }
      resultStr += String.valueOf(j) + numString.charAt(i);
      i += j;
    }
    return resultStr;
  }
}
