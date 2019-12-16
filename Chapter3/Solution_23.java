package SwordForOffer.Chapter3;

public class Solution_23 {
    class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode nodeInLoop = findLoop(pHead);
        if(nodeInLoop == null) {
            return null;
        }
        ListNode temp = nodeInLoop.next;
        /**计算环长度*/
        int n = 1;
        while(temp != nodeInLoop) {
            temp = temp.next;
            ++n;
        }
        ListNode p1 = pHead;
        ListNode p2 = pHead;
        /**先将一个指针提前走n步，当他们再次相遇时该节点就是环入口
         * （简单理解即当后面的指针走到环入口时，提前走的刚好走完了环
         * 因为提前走了n步）*/
        for(int i = 0; i < n; ++i) {
            p2 = p2.next;
        }
        while(p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    /**设置两个指针：一个快指针fNode（每次2步），一个慢指针sNode（每次走1步）
     * 1.两个指针相遇时，则该节点一定在环中
     * 2.不相遇则无环
     * @param pHead
     * @return 如果有环则返回两个指针相遇时指向的节点，无环返回null
     */
    public static ListNode findLoop(ListNode pHead) {
        if(pHead == null) {
            return null;
        }
        ListNode sNode = pHead.next;
        if(sNode == null) {
            return null;
        }
        ListNode fNode = sNode.next;
        while(fNode != null && sNode != null) {
            if(fNode == sNode) {
                return fNode;
            }
            sNode = sNode.next;
            fNode = fNode.next;
            if(fNode.next != null) {
                fNode = fNode.next;
            }
        }
        return null;
    }
}
