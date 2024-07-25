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
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;
        ListNode even = head;
        ListNode odd = head.next;
        ListNode secondHalfHead = odd;
        while (odd != null) {
            even.next = odd.next;
            if (even == null || even.next == null) break;
            even = even.next;
            odd.next = even.next;
            odd = odd.next;
        }
        if (odd != null)
        odd.next = null;
        even.next = secondHalfHead;
        return head;
    }
}