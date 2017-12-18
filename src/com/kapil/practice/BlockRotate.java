package com.kapil.practice;

/**
 * Created by kapilsharma on 29/11/17.
 */

public class BlockRotate {


    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node head;

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);


        printList(head);
        //head = rotate(head, 2);
        head = rotateBlock(head, 2);
        System.out.println("****** After Rotation *********");
        printList(head);
    }


    private static Node rotateBlock(Node head, int k) {
        if (head == null) {
            return head;
        }
        Node prev = null;
        Node next;
        Node current = head;
        int count = 0;
        while (current != null && count < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        head.next = rotateBlock(current, k);
        return prev;
    }


    private static Node rotate(Node head, int k) {
        if (head == null) {
            return head;
        }
        Node prev = null;
        Node next;
        Node current = head;
        int count = 0;
         while (current != null && count < k) {
             next = current.next;
             current.next = prev;
             prev = current;
             current = next;
             count++;
         }
         //previous contain head here
        // head = prev;

         count = 1;
        head.next = current;

        while (current != null && count < k) {
            current = current.next;
            count++;
        }
        if (current != null) {
            current.next = rotate(current.next, k);
        }
        return prev;
    }

    private static void printList(Node head) {
        while(head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }
}
