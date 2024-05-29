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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // ignore middle
        if (fast != null) slow = slow.next;
        ListNode rev = reverse(slow);
        // slow at middle
        while (rev != null) {
            if (rev.val != head.val) return false;
            rev = rev.next;
            head = head.next;
        }
        return true;
    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode cur = node;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}