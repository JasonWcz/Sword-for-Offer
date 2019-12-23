package SwordForOffer.Chapter4;

import java.util.Stack;

/**
 * @author wcz_j
 * 需要一个辅助栈来记录每次push后栈中的最小值
 */
public class Solution_30 {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> min = new Stack<Integer>();
    public void push(int node) {
        stack.push(node);
        if(!min.empty()) {
            if(min.peek() > node) {
                min.push(node);
            }
            else {
                min.push(min.peek());
            }
        }
        else {
            min.push(node);
        }
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min.peek();
    }
}
