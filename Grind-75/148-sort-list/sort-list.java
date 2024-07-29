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
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode node = head;
        while (node != null) {
            pq.offer(node);
            node = node.next;
        }
        head = pq.poll();
        node = head;
        while (!pq.isEmpty()) {
            node.next = pq.poll();
            node = node.next;
        }
        if (node != null) {
            node.next = null;
        }
        return head;
    }
}