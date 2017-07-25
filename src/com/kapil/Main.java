package com.kapil;

public class Main {

    public static void main(String[] args) {
        System.out.println(xyz());
    }

    private static int xyz() {
        try{
            int a = 5/1;
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 2;
        } finally {
            return 3;
        }
    }
}
