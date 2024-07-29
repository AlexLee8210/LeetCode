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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow = head, fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        ListNode n1 = sortList(head);
        ListNode n2 = sortList(slow);

        return merge(n1, n2);
    }

    private ListNode merge(ListNode n1, ListNode n2) {
        ListNode node = new ListNode();
        ListNode header = node;
        while (n1 != null || n2 != null) {
            if (n1 == null) {
                node.next = n2;
                n2 = n2.next;
            } else if (n2 == null) {
                node.next = n1;
                n1 = n1.next;
            } else if (n2.val < n1.val) {
                node.next = n2;
                n2 = n2.next;
            } else {
                node.next = n1;
                n1 = n1.next;
            }
            node = node.next;
        }
        return header.next;
    }
}