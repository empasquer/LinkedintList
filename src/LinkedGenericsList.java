public class LinkedGenericsList<T> {

    public class Node {
        Node next;
        T data;

        public Node(T data) {
            this.data = data;
        }
    }

    Node head;

    public void addFirst(T data) {
        Node newHead = new Node(data);
        newHead.next = head;
        head = newHead;
    }

    public void addLast(T data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(data);
    }

    public void addAtIndex(int index, T data) {
        if (index < 0) {
            throw new IllegalArgumentException("The index can't be negative");
        }
        if (index == 0) {
            addFirst(data);
        } else {
            Node newNode = new Node(data);
            Node current = head;
            int i = 0;
            while (current != null && i < index - 1) {
                current = current.next;
                i++;
            }
            if (current == null) {
                throw new IndexOutOfBoundsException("The index is not valid.");
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public void removeFirst() {
        if (head != null) {
            head = head.next;
        }
    }

    public void removeLast() {
        if (head != null) {
            if (head.next == null) {
                head = null;
            } else {
                Node current = head;
                while (current.next.next != null) {
                    current = current.next;
                }
                current.next = null;
            }
        }
    }

    public void removeAtIndex(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("The index can't be negative");
        }
        if (index == 0) {
            removeFirst();
        } else {
            Node current = head;
            int i = 0;
            while (current != null && i < index - 1) {
                current = current.next;
                i++;
            }
            if (current == null || current.next == null) {
                throw new IndexOutOfBoundsException("The index is not valid.");
            }
            current.next = current.next.next;
        }
    }

    public Node get(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Index can't be negative");
        }
        if (index == 0) {
            return head;
        } else {
            Node current = head.next;
            int i = 0;
            while (current != null && i < index) {
                current = current.next;
                i++;
            }
            if (current == null) {
                throw new IndexOutOfBoundsException("Index is out of bounds");
            }
            return current;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        if (head == null) {
            return 0;
        } else {
            Node current = head;
            int index = 1;
            while (current.next != null) {
                current = current.next;
                index++;
            }
            return index;
        }
    }
}
