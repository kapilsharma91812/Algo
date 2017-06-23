package com.kapil;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by kapilsharma on 23/06/17.
 */
public class SetTest {
    public static void main(String[] args) {
        Set<Integer> mSet = new HashSet<>(5);
        for(int i = 0; i < 10; i++) {
            mSet.add(i);
        }

        for(Integer aInt: mSet) {
            System.out.println(aInt);
        }
    }
}
