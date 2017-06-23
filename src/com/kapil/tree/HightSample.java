package com.kapil.tree;

import java.util.Stack;

/**
 * Created by kapilsharma on 23/01/17.
 */
public class HightSample extends Tree {
    public static void main(String[] args) {
        HightSample obj = new HightSample();
        Node root = obj.initDefault();
        obj.print(root);

        Stack<Node> stack = new Stack<Node>();

    }
}
