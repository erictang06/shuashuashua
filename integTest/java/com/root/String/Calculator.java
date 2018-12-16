package com.root.String;

import java.util.Stack;


public class Calculator {

  /**
   * Implement a basic calculator to evaluate a simple expression string.

   The expression string contains only non-negative integers, +, -, *, / operators and empty spaces .
   The integer division should truncate toward zero.

   Example 1:
   Input: "3+2*2"
   Output: 7

   Example 2:
   Input: " 3/2 "
   Output: 1

   Example 3:
   Input: " 3+5 / 2 "
   Output: 5

   Note:
   You may assume that the given expression is always valid.
   Do not use the eval built-in library function.
   */

  public int basicCalc(String str) {
    int len = str.length();
    Stack<Integer> stack = new Stack<>();
    int num = 0;
    char sign = '+';
    for (int i = 0; i < len; i++) {
      if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
        num = num * 10 + str.charAt(i) - '0';
      }
      if (((str.charAt(i) < '0' || str.charAt(i) > '9') && str.charAt(i) != ' ') || i == len - 1) {
        if (sign == '-') {
          stack.push(-num);
        }
        if (sign == '+') {
          stack.push(num);
        }
        if (sign == '*') {
          stack.push(stack.pop() * num);
        }
        if (sign == '/') {
          stack.push(stack.pop() / num);
        }
        sign = str.charAt(i);
        num = 0;
      }
    }

    int result = 0;
    for (int val : stack) {
      result += val;
    }

    return result;
  }


  /*
  Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -,
non-negative integers and empty spaces .

Example 1:

Input: "1 + 1"
Output: 2
Example 2:

Input: " 2-1 + 2 "
Output: 3
Example 3:

Input: "(1+(4+5+2)-3)+(6+8)"
Output: 23
   */

  public int calcWithParenthesis(String str) {
    /*
    Simple iterative solution by identifying characters one by one. One important thing is that the input is valid,
    which means the parentheses are always paired and in order.

    Only 5 possible input we need to pay attention:
      digit: it should be one digit from the current number
      '+': number is over, we can add the previous number and start a new number
      '-': same as above
      '(': push the previous result and the sign into the stack, set result to 0, just calculate the new result within the parenthesis.
      ')': pop out the top two numbers from stack, first one is the sign before this pair of parenthesis,
           second is the temporary result before this pair of parenthesis. We add them together.
     Finally if there is only one number, from the above solution, we haven't add the number to the result, so we do a check see if the number is zero.
     */

    int result = 0;
    int num = 0;
    int sign = 1;
    int len = str.length();
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < len; i++) {
      if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
        num = num * 10 + str.charAt(i) - '0';
      } else if (str.charAt(i) == '+') {
          result += sign * num;
          num = 0;
          sign = 1;
      } else if (str.charAt(i) == '-') {
          result += sign * num;
          num = 0;
          sign = -1;
      } else if (str.charAt(i) == '(') {
          stack.push(result);
          stack.push(sign);
          result = 0;
          sign = 1;
      } else if (str.charAt(i) == ')') {
          result += sign * num;
          num = 0;
          result *= stack.pop();
          result += stack.pop();
      }
    }

    return result + sign * num;
  }
}
