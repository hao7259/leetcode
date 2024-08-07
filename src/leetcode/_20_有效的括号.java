package leetcode;

import java.util.Stack;

public class _20_有效的括号 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            switch (c) {
                case ')':
                    if (stack.peek() == '(') {
                        stack.pop();
                        continue;
                    } else return false;
                case ']':
                    if (stack.peek() == '[') {
                        stack.pop();
                        continue;
                    } else return false;
                case '}':
                    if (stack.peek() == '{') {
                        stack.pop();
                        continue;
                    } else return false;

                default:
                    return false;
            }


        }
        return stack.empty();

    }
}