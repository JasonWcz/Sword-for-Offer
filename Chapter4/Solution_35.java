package SwordForOffer.Chapter4;

public class Solution_35 {
    /**
     * random随机指向链表中的任意一个节点或者null
     */
    private class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead) {
        CloneNodes(pHead);
        ConnectRandom(pHead);
        return SplitList(pHead);
    }

    /**
     * 在原有链表中每个节点后面，复制该节点，并插入母节点后面
     * @param pHead
     */
    public void CloneNodes(RandomListNode pHead) {
        RandomListNode node = pHead;
        while (node != null) {
            RandomListNode cloneNode = new RandomListNode(node.label);
            cloneNode.next = node.next;
            node.next = cloneNode;
            node = cloneNode.next;
        }
    }

    /**
     * 母节点random有指向则节点S
     * 子节点random则指向S的子节点S'
     * @param pHead
     */
    public void ConnectRandom(RandomListNode pHead) {
        RandomListNode node = pHead;
        while(node != null) {
            if(node.random != null) {
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }
    }

    /**
     * 将复制的节点从原链表中抽出，连成最终需要的复制链表
     * @param pHead
     * @return
     */
    public RandomListNode SplitList(RandomListNode pHead) {
        RandomListNode node = pHead;
        RandomListNode cloneHead = null;
        RandomListNode cloneNode = null;
        if(node != null) {
            cloneHead = node.next;
            cloneNode = cloneHead;
            node.next = cloneHead.next;
            node = node.next;
        }
        while (node != null) {
            cloneNode.next = node.next;
            cloneNode = cloneNode.next;
            node.next = cloneNode.next;
            node = node.next;
        }
        return cloneHead;
    }
}
