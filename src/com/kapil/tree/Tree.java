package com.kapil.tree;

/**
 * Created by kapilsharma on 23/01/17.
 */
public abstract class Tree {

    public static Node initDefault() {
        int data[] = new int[] {1,2, 3, 4, 5, 6};
        return initUtil(data, 0);
    }

    private static Node initUtil(int[] data, int index) {
        if (index < data.length ) {
            Node newNode = new Node(data[index]);
            newNode.left = null;
            newNode.right = null;
            newNode.left = initUtil(data, (index * 2) +1);
            newNode.right = initUtil(data, (index * 2)+2);
            return newNode;
        }
        return null;

    }

    public static Node init (int data[]) {
        return initUtil(data, 0);
    }

    public static void print (Node root) {
        if (root != null) {
            System.out.println(" " + root.data + ",");
            print(root.left);
            print(root.right);
        }
    }

}
