package SwordForOffer.Chapter3;

public class Solution_24 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode ReverseList(ListNode head) {
        ListNode reverseHead = null;
        ListNode pNode = head;
        ListNode preNode = null;
        while(pNode != null) {
            ListNode nextNode = pNode.next;
            if(nextNode == null) {
                reverseHead = pNode;
            }
            pNode.next = preNode;
            preNode = pNode;
            pNode = nextNode;
        }
        return reverseHead;
    }
}
