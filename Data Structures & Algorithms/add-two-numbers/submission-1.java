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

    private boolean plusOne = false;
    private int result = 0;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode resultNode = new ListNode(updateResult(l1, l2));
        ListNode temp = resultNode;

        l1 = l1.next;
        l2 = l2.next;

        while (l1 != null || l2 != null) {
            ListNode newNode = new ListNode(updateResult(l1, l2));
            temp.next = newNode;
            temp = newNode;

            if (l1 == null) l2 = l2.next;
            else if (l2 == null) l1 = l1.next;
            else {
                l1 = l1.next;
                l2 = l2.next;
            }
        }

        if (plusOne) {
            ListNode newNode = new ListNode(updateResult(l1, l2));
            temp.next = newNode;
            temp = temp.next;
        }

        return resultNode;
    }

    private int updateResult(ListNode l1, ListNode l2) {
        int val1 = l1 == null ? 0 : l1.val;
        int val2 = l2 == null ? 0 : l2.val;

        result = val1 + val2;

        if (plusOne) result++;
        
        if (result >= 10) {
            plusOne = true;
            result %= 10;
        } 
        else plusOne = false;
        
        return result;
    }
}
