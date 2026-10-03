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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode temp = head;

        while(temp != null) {
            size++;
            temp = temp.next;
        }

        //System.out.println("sIZE : " + size);

        int goalIndex = size - n;

        if (goalIndex == 0) return head.next;

        ListNode prev = head;
        temp = head.next;
        goalIndex--;

        while(goalIndex != 0) {
            temp = temp.next;
            prev = prev.next;
            --goalIndex;
        }

        prev.next = temp.next;
        return head;
    }
}
