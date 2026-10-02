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
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode prev = head, temp = head.next;

        while(true) {
            if (prev == temp) return true;
            if (temp == null) return false;
            if (temp.next == null) return false;

            prev = prev.next;
            temp = temp.next.next;
        }
    }
}
