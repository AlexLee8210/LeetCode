/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head.equals(head.next) ? head : null;

        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null && !slow.equals(fast)) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast == null || fast.next == null) return null;

        slow = head;
        while (!slow.equals(fast)) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}