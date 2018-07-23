package datastructures;

public class LinkedList {

    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public Node head;
    private int size;

    public void addFront(int data) {//O(1)

        // Create new node
        Node newNode = new Node(data);

        // if head...
        if (head == null) {
            head = newNode;
            size++;
            return;
        }

        // Set it's next to current head
        newNode.next = head;

        // Set current head equal to this new head
        head = newNode;
        size++;
    }

    public int getFirst() {//O(1)
        if (head == null) {
            throw new IllegalStateException("Empty list!");
        }
        return head.data;
    }

    public int getLast() {//O(n0
        if (head == null) {
            throw new IllegalStateException("Empty list!");
        }

        Node current = head;

        // while we are not at the tail
        while (current.next != null) {
            current = current.next; // O(n)
        }

        // We are at the tail
        return current.data;
    }

    public void addBack(int data) {//O(n)
        Node newNode = new Node(data);

        // if head... set and return
        if (head == null) {
            head = newNode;
            size++;
            return;
        }

        // Else starting at head...
        Node current = head;

        // Walk until to hit tail
        while (current.next != null) {
            current = current.next;
        }

        // Set current node to equal newNode
        current.next = newNode;
        size++;
    }

    public int size() {//O(1)
        return size;
//        if (head == null) {
//            return 0;
//        }
//
//        int count = 1;
//        Node current = head;
//
//        while (current.next != null) {
//            current = current.next;
//            count++;
//        }
//
//        return count;
    }

    public void clear() {//O(1)
        head = null;
        size = 0;
    }

    public void deleteValue(int data) {//O(n)

        // if head
        if (head == null) {
            return;
        }
        if (head.data == data) {
            head = head.next;
            size--;
            return;
        }

        // else walk the list
        Node current = head;

        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                size--;
                return;
            }
            current = current.next;
        }
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println("");
    }

}
