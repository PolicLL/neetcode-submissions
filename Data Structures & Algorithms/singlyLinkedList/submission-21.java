class LinkedList {

    private Node start;
    private int size = 0;

    public int get(int index) {
        if (index >= size) return -1;
        Node temp = start;
        while(index-- != 0) {
            temp = temp.next;
        }

        return temp.value;
    }

    public void insertHead(int val) {
        this.start = new Node(val, start);
        ++size;
    }

    public void insertTail(int val) {
        if (size == 0) {
            start = new Node(val, null);
            ++size;
            return;
        }

        Node temp = start;
        while(temp.next != null) {
            temp = temp.next;
        }

        temp.next = new Node(val, null);
        ++size;
    }

    public boolean remove(int index) {
        if (index >= size) return false;

        --size;

        if (index == 0) {
            this.start = this.start.next;
            return true;
        }

        Node previous = start;
        Node delete = start.next;

        while(index-- != 1) {
            previous = previous.next;
            delete = delete.next;
        }

        previous.next = delete.next;
        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> values = new ArrayList<Integer>();
        Node temp = start;

        while(temp != null) {
            values.add(temp.value);
            temp = temp.next;
        }

        return values;
    }
}

class Node {
    int value;
    Node next;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}