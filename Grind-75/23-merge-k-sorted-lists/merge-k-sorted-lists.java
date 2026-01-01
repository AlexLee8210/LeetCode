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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        return partition(lists, 0, lists.length - 1);
    }

    private ListNode partition(ListNode[] lists, int l, int r) {
        if (r - l == 0) {
            return lists[l];
        } else if (r - l == 1) {
            return merge2Lists(lists[l], lists[r]);
        }
        int m = l + (r - l) / 2;
        return merge2Lists(partition(lists, l, m), partition(lists, m + 1, r));
    }

    private ListNode merge2Lists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode prev = head;
        while (l1 != null && l2 != null) {
            if (l2.val < l1.val) {
                ListNode tmp = l2;
                l2 = l1;
                l1 = tmp;
            }
            prev.next = l1;
            prev = l1;
            l1 = l1.next;
        }
        
        prev.next = l2 == null ? l1 : l2;
        return head.next;
    }
}