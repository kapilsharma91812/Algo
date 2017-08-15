package com.kapil.set2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by kapilsharma on 15/08/17.
 */
public class Platform {
    static class Info implements Comparable<Info>{
        int hour;
        int min;
        boolean isArrival;
        Info(String time, boolean isArrival) {
            hour = Integer.parseInt(time.split(":")[0]);
            min = Integer.parseInt(time.split(":")[1]);
            this.isArrival = isArrival;
        }

        @Override
        public int compareTo(Info obj) {
            int hourDiff =  hour - obj.hour;
            int minDiff = min - obj.min;
            return (hourDiff != 0)? hourDiff : minDiff;
        }
    }

    public static void main(String[] args) {
        String arr[] = new String[]{"9:00", "09:05"};
        String dept[] = new String[]{"9:10", "09:50"};
        List<Info> list = new ArrayList();
        for (int i = 0; i < arr.length; i++) {
            list.add(new Info(arr[i], true));
        }

        for (int i = 0; i < dept.length; i++) {
            list.add(new Info(dept[i], false));
        }
        Collections.sort(list);
        int count = 0;
        int maxCount = 0;
        for(Info info:list) {
            if (info.isArrival) {
                count++;
                if (maxCount < count) {
                    maxCount = count;
                }
            } else {
                count--;
            }
        }
        System.out.println(maxCount);

    }
}
