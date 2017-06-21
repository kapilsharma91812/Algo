package com.kapil.linklist;

/**
 * Created by kapilsharma on 21/06/17.
 */
public class Replace extends Linklist {
    public static void main(String[] args) {
        Replace instance = new Replace();
        instance.initDefault();
        int i = 7,  j = 1;
        instance.print(instance.getHead());
        Node newHead = replaceNGetHead(instance.getHead(), i, j);
        System.out.println("************ After replacing **************");
        instance.setHead(newHead);
        instance.print(instance.getHead());
    }
}
