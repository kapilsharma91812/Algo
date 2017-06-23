package com.kapil.tree;

/**
 * Created by kapilsharma on 23/06/17.
 */
public class Test extends Tree {
    public static void main(String[] args) {
        Test instance = new Test();
       Node root = instance.initDefault();
        instance.print(root);
    }
}
