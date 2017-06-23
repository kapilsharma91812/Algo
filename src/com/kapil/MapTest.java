package com.kapil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by kapilsharma on 23/06/17.
 */
public class MapTest {
    public static void main(String[] args) {
        Map<String, Integer> mMap = new HashMap<>(5);
        for(int i = 0; i < 10; i++) {
            mMap.put("kapil" + i , i);
        }

        for(String key: mMap.keySet()) {
            System.out.println("key:" + key + " value:" + mMap.get(key));
        }
    }
}
