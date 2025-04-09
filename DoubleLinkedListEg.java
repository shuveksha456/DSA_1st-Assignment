class DoublyLinkedList {
    private static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;

    // Insert at the end
    public void insertAtLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // Insert at the beginning
    public void insertAtFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // Delete from the beginning
    public void deleteAtFirst() {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }
        if (head == tail) {  // Only one element
            head = tail = null;
            return;
        }
        head = head.next;
        head.prev = null;
    }

    // Delete from the end
    public void deleteAtLast() {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }
        if (head == tail) {  // Only one element
            head = tail = null;
            return;
        }
        tail = tail.prev;
        tail.next = null;
    }
    public void insertAtNth(int data, int position) {
        Node newNode = new Node(data);

        // If list is empty and position is 0, insert as first node
        if (head == null) {
            if (position == 0) {
                head = tail = newNode;
            } else {
                System.out.println("Position out of bounds. List is empty.");
            }
            return;
        }

        // Insert at beginning (position 0)
        if (position == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            return;
        }

        // Traverse to the position
        Node temp = head;
        for (int i = 0; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        // Check if position is out of bounds
        if (temp == null) {
            System.out.println("Position out of bounds.");
            return;
        }

        // Insert at the end if temp is the tail
        if (temp == tail) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            return;
        }

        // Insert in the middle
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
    }
    public void deleteAtNth(int position) {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }

        // Delete at beginning (position 0)
        if (position == 0) {
            deleteAtFirst();
            return;
        }

        // Traverse to the node at the specified position
        Node temp = head;
        for (int i = 0; i < position && temp != null; i++) {
            temp = temp.next;
        }

        // Check if position is out of bounds
        if (temp == null) {
            System.out.println("Position out of bounds.");
            return;
        }

        // Delete at end if temp is tail
        if (temp == tail) {
            deleteAtLast();
            return;
        }

        // Delete in the middle
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }

    // Print the list from head to tail
    public void print() {
        Node temp = head;
        if (temp == null) {
            System.out.println("No elements in linked list");
            return;
        }
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}

public class DoubleLinkedListEg {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.print(); // Empty list
        dll.deleteAtFirst();//Mothing to delete
        dll.insertAtLast(4);
        dll.insertAtLast(2);
        dll.insertAtLast(10);
        dll.insertAtLast(33);
        System.out.println("\nAfter Inserting Elements At Last :");
        dll.print(); // 3 --> 5 --> 7 --> 9 --> NULL

        dll.insertAtFirst(12);
        System.out.println("\nAfter Inserting Element At First :");
        dll.print(); // 1 --> 3 --> 5 --> 7 --> 9 --> NULL

        dll.insertAtNth(4,4);
        System.out.println("\nAfter Inserting Element At 5th Position :");
        dll.print(); // 1 --> 3 --> 5 --> 7 --> 4 --> 9 --> NULL

        dll.deleteAtNth(4);
        System.out.println("\nAfter Deleting Element At 5th Position :");
        dll.print(); // 1 --> 3 --> 5 --> 7 --> 9 --> NULL

        dll.deleteAtFirst();
        System.out.println("\nAfter Deleting Element At First :");
        dll.print(); // 3 --> 5 --> 7 --> 9 --> NULL

        dll.deleteAtLast();
        System.out.println("\nAfter Deleting Element At Last");
        dll.print(); // 3 --> 5 --> 7 --> NULL

        System.out.println();
        dll.deleteAtNth(10);
    }
}

