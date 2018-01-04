package com.kapil;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

class Ma {
    int i =4;
    Ma() {
i =2;
    }
    public  void  badMethod() {

    }
}
public class Main  extends Ma{
    public static void main(String[] args) {

        try {
            //badMethod();
            System.out.println("A");
        }catch (Exception e) {
            System.out.println("B");
        } finally {
            System.out.println("C");
    }
        System.out.println("D");
}
public  int badMethod1() {
    throw new RuntimeException();
}

}
