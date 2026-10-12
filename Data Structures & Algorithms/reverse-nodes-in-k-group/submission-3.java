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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        int size = 0;

        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        int times = size / k;

        if (times == 0) return head;

        //print(head);

        ListNode[] result = reverseN(head, k);
        ListNode resultNode = result[0];
        ListNode resulNextStart = result[1];
        ListNode resulOriginalStart = result[2];

        times--;

        for (int i = 0; i < times; ++i) {
            result = reverseN(resulNextStart, k);
        
            resulOriginalStart.next = result[0];
            resulNextStart = result[1];
            resulOriginalStart = result[2]; 
        }

        return resultNode;
    }

    private ListNode[] reverseN(ListNode start, int n) {
        ListNode originalStart = start;
        ListNode prev = start;
        ListNode temp = start.next;
        ListNode next = start.next.next;

        for (int i = 0; i < (n - 1); ++i) {
            temp.next = prev;
            prev = temp;
            temp = next;

            if (next != null)
                next = next.next;
        }

        originalStart.next = temp;

        return new ListNode[] { prev, temp, originalStart };
    }
}
