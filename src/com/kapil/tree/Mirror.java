package com.kapil.tree;

/**
 * Created by kapilsharma on 23/06/17.
 */
public class Mirror extends Tree {
    public static void main(String[] args) {
        Node root = init(new int[]{1,2,2,3,4,4,3});
        print(root);
        System.out.println(isMirror(root, root));
    }

    private static boolean isMirror(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 != null && root2 != null && root1.data == root2.data) {
            return isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
        }
        return false;
    }
}
