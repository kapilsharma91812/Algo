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

    public void initDefault() {
        int data[] = {1, 2, 3, 4, 5, 6, 7};
        init(data);
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

    public Node initNGetHead(int data[]) {
        Node list = null;
        Node newHead = null;
        for (int i = 0; i < data.length; i++) {
            Node node = new Node();
            if (newHead == null) {
                newHead = node;
                list = node;
            } else {
                list.next = node;
                list = list.next;
            }
            node.data = data[i];
            node.next = null;
        }
        return newHead;
    }

    public static void print(Node list) {
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

    public static Node findKthNode(Node head, int k) {
        int counter = 0;
        Node start = head;
        while (head != null && counter != k) {
            head = head.next;
            counter++;
        }
        if (counter != k) {
            return null;
        }

        while (head != null) {
            head = head.next;
            start = start.next;
        }
        return start;
    }

    public static void removeLoop(Node loopPoint, Node head) {
        Node list = head;
        Node loopNode;

        while (true) {
            /* Now start a pointer from loop_node and check if it ever
             reaches loopNode */
            loopNode = loopPoint;
            while (loopNode.next != loopPoint && loopNode.next != list) {
                loopNode = loopNode.next;
            }

            /* If loopNode reahced list then there is a loop. So break the
             loop */
            if (loopNode.next == list) {
                break;
            }

            /* If loopNode did't reach ptr1 then try the next node after list */
            list = list.next;
        }

        loopNode.next = null;
    }


    public static Node getLoopNode(Node head) {
        Node slowPointer = head;
        Node fastPointer = head;

        while (slowPointer != null && fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            if (slowPointer == fastPointer) {
                return fastPointer;
            }
        }

        return null;
    }

    public static Node replaceNGetHead(Node head, int data1, int data2) {
        Node newHead = head;
        Node currentX = head;
        Node prevX = null ;
        Node currentY = head;
        Node prevY = null;

        while (currentX != null && currentX.data != data1) {
            prevX = currentX;
            currentX = currentX.next;
        }

        while (currentY != null && currentY.data != data2) {
            prevY = currentY;
            currentY = currentY.next;
        }

        if (currentX == null || currentY == null) {
            return newHead;
        }

        if (prevX != null) {
            prevX.next = currentY;
        } else {
            newHead = currentY;
        }


        if (prevY != null) {
            prevY.next = currentX;
        } else {
            newHead = currentX;
        }

        Node temp = currentX.next;
        currentX.next = currentY.next;
        currentY.next = temp;
        return newHead;

    }

    public static Node delete(Node head, int data) {
        Node pre = null;
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                break;
            }
            pre = current;
            current = current.next;
        }
        if (pre != null && current != null) {
            pre.next = current.next;
        } else if (current != null) {
            return current.next;
        }
        return head;

    }

    public static Node reverseGroup(Node head, int k)
    {
        Node current = head;
        Node next = null;
        Node prev = null;

        int count = 0;

       /* Reverse first k nodes of linked list */
        while (count < k && current != null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

       /* next is now a pointer to (k+1)th node
          Recursively call for the list starting from current.
          And make rest of the list as next of first node */
        if (next != null)
            head.next = reverseGroup(next, k);

        // prev is now head of input list
        return prev;
    }

}
