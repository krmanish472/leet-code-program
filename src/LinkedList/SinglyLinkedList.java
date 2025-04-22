package LinkedList;

public class SinglyLinkedList {
    public Node head; // first node
    public Node tail; // last node

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public void addNode(int data) {
        Node newNode = new Node(data);
        // check if list is empty and add newNode as first/head node
        if (head == null) {
            head = newNode;
        } else {
            // newNode will be added after last/tail node such that tail's next will point to newNode
            tail.next = newNode; // add newNode as last node
        }
        tail = newNode; // now newNode is our last node
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        // pointer to first/head node
        System.out.println("Nodes of singly linked list: ");
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next; // move pointer to next node
        }
        System.out.println();
    }

    public void deleteByKey(int key) {
        Node current = head; // pointer to first/head node
        Node prev = null;

        // CASE 1: list: 1 -> 2 -> 3 -> 4 -> 5 | key: 1
        if (current != null && current.data == key) {
            head = current.next; // Changed head to next node
            return;
        }

        // CASE 2: list: 1 -> 2 -> 3 -> 4 -> 5 | key: 3
        while (current != null && current.data != key) {
            prev = current;
            current = current.next; // move pointer to next node
        }

        // key is found as the above condition was falsy
        if (current != null) {
            prev.next = current.next;
        } else {
            System.out.println("Key " + key + " not found");
        }
    }

    public void deleteAtPosition(int index) {
        Node current = head; // pointer to first/head node
        Node prev = null;

        // CASE 1: list: 1 -> 2 -> 3 -> 4 -> 5 | index: 0
        if (index == 0 && current != null) {
            head = current.next; // Changed head to next node
            return;
        }

        // CASE 2: list: 1 -> 2 -> 3 -> 4 -> 5 | index: 3
        int counter = 0;
        while (current != null && counter != index) {
            prev = current;
            current = current.next; // move pointer to next node
            counter++;
        }

        // key is found as the above condition was falsy
        if (current != null) {
            prev.next = current.next;
        } else {
            System.out.println("No Key at provided index");
        }
    }

    public static Node reverseList(Node head) {
        Node curr = head;
        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;

            // Move Pointers one position ahead
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        SinglyLinkedList sList = new SinglyLinkedList();

        sList.addNode(1);
        sList.addNode(2);
        sList.addNode(3);
        sList.addNode(4);
        sList.addNode(5);
        sList.display();

        sList.head = sList.reverseList(sList.head);
        sList.display();

        sList.deleteByKey(6);
        sList.display();

        sList.deleteAtPosition(3);
        sList.display();


    }
}
