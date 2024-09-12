package leetcode;

public class _2181_合并零之间的节点 {
    public ListNode mergeNodes(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head.next;
        int cur = 0;
        while (p2 != null) {
            if (p2.next==null) {
                p1.next = null;
            }
            if (p2.val == 0) {
                p1.val = cur;
                cur = 0;
                p2 = p2.next;
                p1 = p1.next;
            } else {
                cur += p2.val;
                p2 = p2.next;
                p1.next = p2;
            }
        }
        return head;
    }
}
