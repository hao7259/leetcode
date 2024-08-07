package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class _232_用栈实现队列 {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();


    public void push(int x) {
        stack.push(x);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack.isEmpty()) {
                stack2.push(stack.pop());
            }
        }
        return stack2.pop();

    }

    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack.isEmpty()) {
                stack2.push(stack.pop());
            }
        }
        return stack2.peek();

    }

    public boolean empty() {
        return stack2.isEmpty()&&stack.isEmpty();

    }
    List list = new LinkedList();
    
}
