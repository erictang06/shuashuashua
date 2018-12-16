package com.root.String;

import java.util.Stack;


/**
 * Given an encoded string, return it's decoded string.

 The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly
 k times. Note that k is guaranteed to be a positive integer.

 You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

 Furthermore, you may assume that the original data does not contain any digits and that digits are only for
 those repeat numbers, k. For example, there won't be input like 3a or 2[4].

 Examples:
 s = "3[a]2[bc]", return "aaabcbc".
 s = "3[a2[c]]", return "accaccacc".
 s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */

public class DecodeCountString {
  public String decodeString(String s) {
    Stack<String> resultStack = new Stack<>();
    Stack<Integer> countStack = new Stack<>();

    int i = 0;
    resultStack.push("");
    while (i < s.length()) {
      char ch = s.charAt(i);
      if (ch >='0' && ch <= '9') {
        int start = i;
        while (s.charAt(i+1) >= '0' && s.charAt(i+1) <= '9') {
          i++;
        }
        countStack.push(Integer.parseInt(s.substring(start, i+1)));
      } else if (s.charAt(i) == '[') {
        resultStack.push("");
      } else if (s.charAt(i) == ']') {
        StringBuilder sb = new StringBuilder();
        String str = resultStack.pop();
        int times = countStack.pop();
        for (int j=0; j<times; j++) {
          sb.append(str);
        }
        resultStack.push(resultStack.pop() + sb.toString());
      } else {
        resultStack.push(resultStack.pop() + ch);
      }
      i++;
    }

    return resultStack.pop();
  }
}
