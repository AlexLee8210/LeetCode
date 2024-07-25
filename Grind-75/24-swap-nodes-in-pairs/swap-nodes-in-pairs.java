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
    public ListNode swapPairs(ListNode head) {
        if (head == null) return head;
        ListNode prev = new ListNode(0, head);
        ListNode before = prev;
        ListNode second = head.next;
        while (second != null) {
            swap(prev, second);
            // now prev.next is second
            prev = prev.next.next;
            if (prev.next == null) break;
            second = prev.next.next;
        }
        return before.next;
    }

    // prev is node before first node to swap
    // ex. prev -> first -> second -> ...
    //     prev -> second -> first -> ...
    private void swap(ListNode prev, ListNode second) {
        ListNode first = prev.next;
        first.next = second.next;
        second.next = first;
        prev.next = second;
    }
}