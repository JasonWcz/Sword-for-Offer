package SwordForOffer.Chapter3;

public class Solution_25 {
    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 非递归写法
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null) {
            return list2;
        }
        if(list2 == null) {
            return list1;
        }
        ListNode head = new ListNode(0);
        ListNode pNode = head;
        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                pNode.next = list1;
                list1 = list1.next;
            }
            else {
                pNode.next = list2;
                list2 = list2.next;
            }
            pNode = pNode.next;
        }
        if(list1 != null) {
            pNode.next = list1;
        }
        if(list2 != null) {
            pNode.next = list2;
        }
        return head.next;
    }

    /**
     * 递归写法
     * 代码更简练，直观，也不容易犯错
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode RecursionMerge(ListNode list1,ListNode list2) {
        if(list1 == null) {
            return list2;
        }
        if(list2 == null) {
            return list1;
        }
        ListNode mergeHead = null;
        if(list1.val <= list2.val) {
            mergeHead = list1;
            mergeHead.next = RecursionMerge(list1.next, list2);
        }
        else {
            mergeHead = list2;
            mergeHead.next = RecursionMerge(list1, list2.next);
        }
        return mergeHead;
    }
}
