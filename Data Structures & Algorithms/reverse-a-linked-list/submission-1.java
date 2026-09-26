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

// 0  1 -> 2 -> 3
// p 0
// c 1
// n 2

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode previous = head;
        ListNode current = head.next;
        ListNode next = head.next.next;
        
        previous.next = null;

        while(true) {
            current.next = previous;
            previous = current;
            current = next;

            if (current == null) return previous;

            next = next.next;
        }
    }
}

