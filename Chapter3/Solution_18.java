package SwordForOffer.Chapter3;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Solution_18 {
    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead == null) {
            return pHead;
        }
        ListNode preNode = null;
        ListNode pNode = pHead;
        while(pNode != null) {
            ListNode pNext = pNode.next;
            boolean needDel = false;
            if(pNext != null && pNode.val == pNext.val) {
                needDel = true;
            }
            /**当前不是重复的，不用删*/
            if(!needDel) {
                preNode = pNode;
                pNode = pNext;
            }
            /**需要删*/
            else {
                int value = pNode.val;
                /**遍历到不重复的位置，中间都可以删掉*/
                while(pNext != null && pNext.val == value) {
                    pNext = pNext.next;
                }
                /**preNode为空，说明队头就是重复元素
                 * 因此把首个不一样的提上来当队头*/
                if(preNode == null) {
                    pHead= pNext;
                }
                else {
                    preNode.next = pNext;
                }
                pNode = pNext;
            }
        }
        return pHead;
    }
}
