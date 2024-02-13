public class DoublyLinkedList<T> {
    public class Node {
        Node previous, next;
        T data;

        public Node(T data) {
            this.data = data;
        }
    }

    Node head;

    public void addFirst(T data) {
        Node newNode = new Node(data);
        if (head != null) {
            newNode.next = head;
            head.previous = newNode;
        }
        head = newNode;
    }

    public void addLast(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        newNode.previous = current;
    }

    public void addAtIndex(int index, T data) {
        if (index < 0) {
            throw new IllegalArgumentException("Index can't be negative");
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        Node current = head;
        int i = 0;
        while (current != null && i < index - 1) {
            current = current.next;
            i++;
        }
        if (current == null) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        newNode.next = current.next;
        newNode.previous = current;
        if (current.next != null) {
            current.next.previous = newNode;
        }
        current.next = newNode;
    }

    public void removeFirst() {
        if (head != null) {
            head = head.next;
            if (head != null) {
                head.previous = null;
            }
        }
    }

    public void removeLast() {
        // Check if the list is empty
        if (head == null) {
            return; // List is empty, nothing to remove
        }

        // Check if there's only one node in the list
        if (head.next == null) {
            head = null; // Only one node in the list, remove it
            return;
        }

        // Loop list to find the node before the last node
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }

        // Remove the last node
        current.next = null;

        // Update the previous reference of the new last node to null
        current.next.previous = null;
    }


    public void removeAtIndex(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Index can't be negative");
        }

        if (index == 0) {
            removeFirst(); // Special case, index is 0, then remove first node
            return;
        }

        Node current = head;
        int i = 0;

        // Loop list until the node before the one to remove
        while (current != null && i < index - 1) {
            current = current.next;
            i++;
        }

        // Check if the index is out of bounds
        if (current == null) {
            throw new IndexOutOfBoundsException("Index is not valid.");
        }

        // If the node to remove is the last node, call removeLast() method
        if (current.next == null) {
            removeLast();
            return;
        }

        // Remove the node at the specified index
        Node nodeToRemove = current.next;
        current.next = nodeToRemove.next;
        if (nodeToRemove.next != null) {
            nodeToRemove.next.previous = current;
        }
    }

    public Node get(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Index canøt be negative");
        }

        if (index == 0) {
            return head;
        }
        Node current = head;
        int i = 0;
        while (current != null && i < index ) {
            current = current.next;
            i++;
        }
        if (current == null) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return current;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        if (head == null) {
            return 0;
        } else {
            Node current = head;
            int index = 0;
            while (current.next != null) {
                current = current.next;
                index++;
            }
            return index;
        }
    }


}
