public class LinkedIntList {
    public class Node {
        Node next;
        int data;

        public Node (int data) {
            this.data = data;
        }
    }

    Node head;
    /*public void append(int data) {
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

    public void prepend(int data) {
        Node newHead = new Node(data);
        newHead.next = head;
        head = newHead;
    }

    public void deleteWithValue(int data) {
        if (head == null) return;
        if (head.data == data){
            head = head.next;
            return;
        }

        Node current = head;
        while(current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }*/

    // Exercise

    public void addFirst(int data) {
        Node newHead = new Node(data);
        newHead.next = head;
        head = newHead;
    }

    public void addLast(int data) {
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

    public void addAtIndex(int index, int data) {
        // index under 0 is not possible
        if (index < 0 ) {
            throw new IllegalArgumentException("The index can't be negative");
        }
        // index == 0 -> node we want tot access is head Node
        if (index == 0) {
            addFirst(data);
        } else {
            // all positive ints over 0
            // create a new node to put at int index
            Node newNode = new Node(data);
            // keep track of current node -> which is the forst after 0, so loop
            Node current = head;

            int i = 0;
            // loop number until int index - 1 to get node befotre node to access
            while (current != null && i < index - 1) {
                current = current.next;
                i++;
            }

            // if current Node is null then index out of bounds
            if (current == null) {
                throw new IndexOutOfBoundsException("The index is not valid.");
            }

            // So in the end
            // the node after the newNode is the current node, the one we landed on with the loop
            // the one before the index we want to access, so newNode.next -> currentNode
            newNode.next = current;
            // Aaaaaaaaaand the current Node gets the newNode data
            current.next = newNode;
        }
    }

    public void removeFirst() {
        if (head != null) {
            head = head.next;
        }
    }

    public void removeLast() {
        // if head node null the nothing happens
        if (head != null) {
            // If there is only one node in the list then head is null ergo list is null
            if (head.next == null) {
                head = null;
            } else {
                // else (more than one node) -> loop through to find last node before null node
                Node current = head;
                // Traverse the list until the second-to-last node
                while (current.next.next != null) {
                    current = current.next;
                }
                // when last node NOT null found, make node null to remove
                current.next = null;
            }
        }
    }

    public void removeAtIndex(int index) {
        if (index < 0 ) {
            throw new IllegalArgumentException("The index can't be negative");
        }

        if (index == 0) {
            removeFirst(); // Special case, index is first node, then remove first node
        } else {
            Node current = head;
            int i = 0;

            // Loop list until the node before the one to remove
            while (current != null && i < index - 1) {
                current = current.next;
                i++;
            }

            // Check if the index is out of bounds
            if (current == null || current.next == null) {
                throw new IndexOutOfBoundsException("The index is not valid.");
            }

            // Remove the node at the specified index
            current.next = current.next.next;
        }
    }

    public Node get(int index) {
        if (index <0) {
            throw new IllegalArgumentException("Index can't benegative int");
        }
        if (index == 0) {
            return head;
        } else {
            Node current  = head.next;

            int i = 0;
            while (current != null && i < index) {
                current = current.next;
                i++;
            }

            if (current == null) {
                throw  new IndexOutOfBoundsException("Index is out of bounds");
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
            while (current.next != null){
                current = current.next;
                index++;
            }
            return index;
        }
    }

}

