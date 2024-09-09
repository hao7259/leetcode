package leetcode;

import java.util.ArrayList;

public class _2181_ {
    @SuppressWarnings("all")
    public ListNode mergeNodes(ListNode head) {
        ListNode list = new ListNode();
        int cur=0;
        while (head.next != null) {
            if (head.val==0) {
                list.next.val(cur);
                cur=0;
            }
            cur+=head.val;

        }
        return list;

    }

}
