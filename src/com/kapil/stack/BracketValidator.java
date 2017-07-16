package com.kapil.stack;

import java.util.Stack;

/**
 * Created by kapilsharma on 16/07/17.
 */
public class BracketValidator {
    private static boolean closing;

    public static void main(String[] args) {
        String str = "{()}[]";
            System.out.println(isValid(str));
    }

    private static boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        try {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            switch (ch) {
                case '}':
                    if (stack.pop() != '{') {
                        return false;
                    }
                    break;
                case ')':
                    if (stack.pop() != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.pop() != '[') {
                        return false;
                    }
                    break;
                default:
                    stack.push(ch);
            }
        }
        } catch (Exception e) {
            return false;
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }


}
