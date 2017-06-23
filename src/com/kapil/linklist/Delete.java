package com.kapil.linklist;

/**
 * Created by kapilsharma on 22/06/17.
 */
public class Delete extends Linklist {
    public static void main(String[] args) {
        Delete instance = new Delete();
        instance.initDefault();
        instance.print(instance.getHead());
        int data = 8;
        Node newHead = instance.delete(instance.getHead(), data);
        instance.setHead(newHead);
        System.out.println("***** After Deletion ******");
        instance.print(instance.getHead());

    }
}
