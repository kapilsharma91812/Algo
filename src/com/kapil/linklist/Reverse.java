package com.kapil.linklist;

/**
 * Created by kapilsharma on 17/01/17.
 */
public class Reverse extends Linklist {

    public static void main(String[] args) {
        int data[] = {1,2,3,4,5};
        Reverse obj = new Reverse();
        obj.init(data);
        obj.print(obj.getHead());
        obj.setHead(reverse(obj.getHead()));
        System.out.println("After reverse:");
        obj.print(obj.getHead());
    }


}
