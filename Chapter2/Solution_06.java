package SwordForOffer.Chapter2;

import java.util.ArrayList;
import java.util.Stack;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution_06 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        //递归写法
        if(listNode == null) return new ArrayList<Integer>();
        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(this.printListFromTailToHead(listNode.next)); //此处注意addAll添加在前面
        list.add(listNode.val);
        return list;

        //栈写法
//        Stack<Integer> stack = new Stack<>();
//        while(listNode != null){
//            stack.add(listNode.val);
//            listNode = listNode.next;
//        }
//        ArrayList<Integer> list = new ArrayList<>();
//        while(!stack.empty()){
//            list.add(stack.pop());
//        }
//        return list;
    }
}
