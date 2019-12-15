package SwordForOffer.Chapter3;


import java.text.ParsePosition;

public class Solution_22 {
    static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode FindKthToTail(ListNode head,int k) {
        if(head == null || k == 0) {
            return null;
        }
        ListNode tNode = head;
        ListNode pNode = null;
        /**pNode和tNode之间的差值为（k-1）*/
        for(int i = 0; i < k-1; ++i) {
            if(tNode.next != null) {
                tNode = tNode.next;
            }
            /**下一个为空，则链表节点少于k*/
            else {
                return null;
            }
        }
        pNode = head;
        while(tNode.next != null) {
            tNode = tNode.next;
            pNode = pNode.next;
        }
        return pNode;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode res = FindKthToTail(head,3);
        System.out.println(res.val);
    }
}
