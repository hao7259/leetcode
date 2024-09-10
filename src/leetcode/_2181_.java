package leetcode;

public class _2181_ {
    public ListNode mergeNodes(ListNode head) {
        head = head.next;
        ListNode res = head;
        int cur = 0;
        while (head != null && head.next != null) {
            ListNode backup = head;
            if (head.next.val == 0) {
                head.val = cur;
                cur = 0;
                head.next = head.next.next;
            } else {
                cur += head.next.val;
                head = head.next;
            }
        }
        return res;
    }
}
