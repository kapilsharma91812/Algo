package com.kapil.linklist;

/**
 * Created by kapilsharma on 19/06/17.
 */
public class Seggergate extends Linklist {
    public static void main(String[] args) {
        Seggergate seggergate = new Seggergate();
        seggergate.init(new int[]{1, 2, 3, 4, 5});
        seggergate.print(seggergate.getHead());
        seggergate.setHead(seggergate.doSeggregation(seggergate.getHead()));
        System.out.println("******* After Seggregation ******");
        seggergate.print(seggergate.getHead());
    }

    private Node doSeggregationTest(Node list) {
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
