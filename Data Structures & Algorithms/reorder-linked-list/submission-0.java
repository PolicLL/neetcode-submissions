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

 // 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6

class Solution {
    public void reorderList(ListNode head) {
        ListNode temp = head;
        ListNode next = head.next;

        Deque<ListNode> stack = new ArrayDeque<>();

        while(temp != null) {
            next = temp.next;
            temp.next = null;
            stack.add(temp);
            temp = next;
        }

        System.out.println("si<e: " + stack.size());
        System.out.println("stack.peekLast(): " + stack.peekFirst().val);

        head = stack.removeFirst();
        boolean firstRemoved = true;

 //System.out.println("!stack.isEmpty(): " + !stack.isEmpty());

        while(!stack.isEmpty()) {
            //System.out.println("1");
            if(firstRemoved) {
                head.next = stack.removeLast();
                firstRemoved = false;
            }
            else {
                head.next = stack.removeFirst();
                firstRemoved = true;
            }
            head = head.next;
        }
    }
}
