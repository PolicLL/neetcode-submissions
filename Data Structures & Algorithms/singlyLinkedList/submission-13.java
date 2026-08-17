class LinkedList {

    private Node start;
    private int size = 0;

    public LinkedList() {
        this.start = null;
    }

    public int get(int index) {
        if (index >= size) return -1;
        Node temp = start;
        int counter = 0;
        while(counter != index) {
            temp = temp.next;
            ++counter;
        }

        System.out.println("index size " + index + " " + size);

        return temp.value;
    }

    public void insertHead(int val) {
        Node newNode = new Node(val, start);
        this.start = newNode;
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

        if (index == 0) {
            this.start = this.start.next;
            --size;
            return true;
        }

        // counter = 1
        // 7 10 1
        //   p
        //.     d
        int counter = 1;

        Node previous = start;
        Node delete = start.next;

        while(counter != index) {
            System.out.println(index + " " + size + " ");
            previous = previous.next;
            delete = delete.next;
            ++counter;
        }

        previous.next = delete.next;
        --size;
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
