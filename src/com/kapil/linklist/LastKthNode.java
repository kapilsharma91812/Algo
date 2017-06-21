package com.kapil.linklist;

import java.util.Scanner;

/**
 * Created by kapilsharma on 21/06/17.
 */
public class LastKthNode extends Linklist {

    public static void main(String[] args) {
        LastKthNode instance = new LastKthNode();
        instance.initDefault();
        int k = 3;
        Node kthNode = findKthNode(instance.getHead(), k);
        if (kthNode != null) {
            System.out.println(k + "th Node is:" + kthNode.data);
        } else {
            System.out.println(k + "th Node not found");
        }
    }
}
