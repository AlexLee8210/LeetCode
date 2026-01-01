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
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // end first half
        ListNode tmp = slow;
        slow = slow.next;
        tmp.next = null;

        ListNode prev = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        
        // len(cur) >= len(prev)
        ListNode cur = head;
        while (prev != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = prev.next;
            cur.next.next = next;
            cur = next;
        }
    }
}