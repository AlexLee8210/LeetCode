/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode root = new ListNode(-1);
        ListNode cur = head, prev = root;

        while (cur != null) {
            ListNode r = cur;
            int count = 0;
            while (r != null && count < k) {
                r = r.next;
                ++count;
            }

            if (count == k) {
                prev.next = reverse(cur, k);
            } else {
                prev.next = cur;
            }

            prev = cur;
            cur = r;
        }

        return root.next;
    }

    private ListNode reverse(ListNode head, int k) {
        ListNode cur = head, prev = null;
        for (int i = 0; i < k; ++i) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}