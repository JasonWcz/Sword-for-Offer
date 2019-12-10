package SwordForOffer.Chapter2;

import java.util.Stack;

public class Solution_09 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        if(stack2.empty()) try {
            throw new Exception("no node");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stack2.pop();
    }
}
