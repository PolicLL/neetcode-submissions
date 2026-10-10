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
        if (lists.length == 1) return lists[0];

        //boolean areAllEmpty = Arrays.stream(lists).allMatch(node -> node == null);
        //if (areAllEmpty) return null;

        return mergeKLists(lists, 0, lists.length - 1);
    }

    public ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];
        if ((end - start) == 1) return merge(lists[start], lists[end]);
        int mid = (start + end) / 2;
        return merge(mergeKLists(lists, start, mid), mergeKLists(lists, mid + 1, end));
    }

    private ListNode merge(ListNode one, ListNode two) {
        if (one == null) return two;
        if (two == null) return one;
        
        ListNode result = null;
        ListNode begin = null;
        if (one.val > two.val) {
            result = two;
            two = two.next;
        } else {
            result = one;
            one = one.next;
        }

        begin = result;

        result.next = null;

        while (one != null || two != null) {
            if (one == null) {
                result.next = two;
                return begin;
            }
            else if (two == null) {
                result.next = one;
                return begin;
            }
            else if (one.val > two.val) {
                result.next = two;
                two = two.next;
                result = result.next;
                result.next = null;
            } else {
                result.next = one;
                one = one.next;
                result = result.next;
                result.next = null;
            }
            
        }

        return begin;
    }
}






