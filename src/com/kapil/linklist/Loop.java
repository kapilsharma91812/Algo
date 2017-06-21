package com.kapil.linklist;

/**
 * Created by kapilsharma on 21/06/17.
 */
public class Loop extends Linklist {

    public static void main(String[] args) {

        Loop loop = new Loop();
        loop.initDefault();
        loop.print(loop.getHead());
        createLoop(loop.getHead());
        Node loopNode = getLoopNode(loop.getHead());
        if (loop != null) {
            System.out.println("Loop detected at node:" + loopNode.data);
            removeLoop(loopNode, loop.getHead());
        } else {
            System.out.println("No Loop detected");
        }
        System.out.println("***** After removing loop ********");
        loop.print(loop.getHead());
    }

    private static void createLoop(Node head) {
        head.next.next.next = head;
    }
}
