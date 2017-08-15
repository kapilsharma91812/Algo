package com.kapil.linklist;

/**
 * Created by kapilsharma on 15/08/17.
 */
public class IntersectionList extends Linklist{
    public static void main(String[] args) {
        int arr1[] = new int[]{1,2,3,4,5,6};
        int arr2[] = new int[]{2,4,6};
        IntersectionList iList = new IntersectionList();

        Node head1 = iList.initNGetHead(arr1);
        System.out.println("\n ******* 1st List ******");
        iList.print(head1);
        Node head2 = iList.initNGetHead(arr2);
        System.out.println("\n ******* 2nd List ******");
        iList.print(head2);
        Node head3 = iList.createInterSectionList(head1, head2);
        System.out.println("\n ******* New List ******");
        iList.print(head3);

    }

    private Node createInterSectionList(Node head1, Node head2) {
        Node newHead = null;
        Node list3 = null;
        while (head1 != null && head2 != null) {
            if(head1.data == head2.data) {
                if (newHead == null) {
                    list3 = new Node();
                    list3.data = head1.data;
                    newHead = list3;
                } else {
                    list3.next = new Node();
                    list3.next.data = head1.data;
                    list3 = list3.next;
                }
                head1 = head1.next;
                head2 = head2.next;
            } else if (head1.data > head2.data) {
                head2 = head2.next;
            } else {
                head1 = head1.next;
            }
        }
        return newHead;
    }
}
