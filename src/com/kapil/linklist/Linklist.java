package com.kapil.linklist;

/**
 * Created by kapilsharma on 17/01/17.
 */
public abstract class Linklist {
    private Node head;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void init(int data[]) {
        Node list = null;
        for (int i = 0; i < data.length; i++) {
            Node node = new Node();
            if (head == null) {
                head = node;
                list = node;
            } else {
                list.next = node;
                list = list.next;
            }
            node.data = data[i];
            node.next = null;
        }
    }

    public void print(Node list) {
        while (null != list) {
            System.out.print(list.data + ", ");
            list = list.next;
        }
    }

    public static Node reverse(Node head) {
        return reverseUtil(head, null);
    }

    public static Node reverseUtil(Node current, Node prev) {
        if (current.next == null) {
            current.next = prev;
            return current;
        } else {
            Node next = current.next;
            current.next = prev;
            return reverseUtil(next, current);
        }
    }

    public static Node doSeggregation(Node list) {
        Node evenHead = null, evenList = null;
        Node oddHead = null, oddList = null;
        while (list != null) {
            if (list.data % 2 == 0) { //even case
                if (evenHead == null) {
                    evenHead = list;
                    evenList = list;
                } else {
                    evenList.next = list;
                    evenList = evenList.next;
                }
            } else { //odd case
                if (oddHead == null) {
                    oddHead = list;
                    oddList = list;
                } else {
                    oddList.next = list;
                    oddList = oddList.next;
                }
            }
            list = list.next;
        }

        // ending both the list with null
        if (evenList != null) {
            evenList.next = null;
        }
        if (oddList != null) {
            oddList.next = null;
        }


        //Mergin both the list
        if (evenHead != null) {
            evenList.next = oddHead;
            return evenHead;
        } else if (oddHead != null) {
            oddList.next = evenHead;
            return oddHead;
        } else {
            return list; //empty or null head
        }
    }

}
