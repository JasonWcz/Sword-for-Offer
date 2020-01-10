package SwordForOffer.Chapter5;

/**
 * @author wcz_j
 * 找两个链表首个公共节点
 */
public class Solution_52 {
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 将长链表的指针同步到短链表相同的相对位置
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }

        ListNode node1 = pHead1;
        ListNode node2 = pHead2;
        int len1 = GetListLength(node1);
        int len2 = GetListLength(node2);
        node1 = pHead1;
        node2 = pHead2;
        /**长链表上的指针提前走，进行同步*/
        if (len1 > len2) {
            for (int i = 0; i < len1 - len2; ++i) {
                node1 = node1.next;
            }
        } else if (len1 < len2) {
            for (int i = 0; i < len2 - len1; ++i) {
                node2 = node2.next;
            }
        }
        /**找相同，最后可以直接返回，即使是同为空*/
        while (node1 != node2) {
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
    }

    /**
     *
     * @param head
     * @return 返回链表的长度
     */
    public int GetListLength(ListNode head) {
        int count = 0;
        while (head != null) {
            ++count;
            head = head.next;
        }
        return count;
    }
}
