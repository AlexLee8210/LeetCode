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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        ListNode prev = new ListNode();
        prev.next = head;

        while (cur != null) {
            cur = cur.next;
            if (n == 0) {
                prev = prev.next;
            } else {
                n--;
            }
        }
        if (prev.next == head) {
            if (head.next == null) return null;
            return head.next;
        }
        prev.next = prev.next.next;
        // if (prev.next == null)
        // if (prev != null)
        // System.out.println(prev.val);
        return head;
    }
}