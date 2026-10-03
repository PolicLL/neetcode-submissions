/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return head;
        
        Node newList = new Node(head.val);
        Node newListTemp = newList;
        Node temp = head.next;

        Map<Node, Node> map = new HashMap<>();
        map.put(head, newList);

        while (temp != null) {
            Node newNode = new Node(temp.val);
            newListTemp.next = newNode;
            newListTemp = newNode;
            map.put(temp, newNode);
            temp = temp.next;
        }

        //System.out.print("Start ");    

        //while (newList != null)
            //System.out.print(newList.val + " ");

        temp = head;
        newListTemp = newList;

        while (temp != null) {
            newListTemp.random = map.get(temp.random);
            temp = temp.next;
            newListTemp = newListTemp.next;
        }

        return newList;
    }
}
