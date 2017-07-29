package com.kapil.greedy.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by kapilsharma on 27/07/17.
 */
public class JourneyToMoon {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/com/kapil/input1.txt");
        Scanner in = new Scanner(file);
        int numOfAstr = in.nextInt();
        int queries = in.nextInt();
        AstSet arr[] = new AstSet[numOfAstr];
        for (int i = 0; i < numOfAstr; i++) {
            arr[i] = new AstSet(i);
        }

        for (int query = 0; query < queries; query++) {
            int firstAst = in.nextInt();
            int secondAst = in.nextInt();
            int firstParent = find(arr, firstAst);
            int secondParent = find(arr, secondAst);
            if (firstParent != secondParent) {
                union(arr, firstParent, secondParent);
            }
        }
        long ways = 0;
        /*for (int i = 0; i < numOfAstr; i++) {
            if (arr[i].isParent) {
                for (int j = i + 1; j < numOfAstr; j++) {
                    if (arr[j].isParent) {
                        ways = ways + (arr[i].numOfAstr * arr[j].numOfAstr);
                    }
                }
            }
        }

        */

        int sum = 0;
        for (int i = 0; i < numOfAstr; i++) {
            if (arr[i].isParent) {
                sum = sum + arr[i].numOfAstr;
            }
        }

        for (int i = 0; i < numOfAstr; i++) {
            if (arr[i].isParent) {
                sum -= arr[i].numOfAstr;
                ways += arr[i].numOfAstr * sum;
            }
        }
     

        System.out.println(ways);

    }

    public static class AstSet {
        int astr;
        int parent;
        int numOfAstr;
        boolean isParent;
        AstSet(int astr) {
            this.astr = astr;
            parent = astr;
            numOfAstr = 1;
            isParent = true;
        }
    }

    private static void union(AstSet[] arr, int firstParent, int secondParent) {
        arr[firstParent].parent = secondParent;
        arr[firstParent].isParent = false;

        arr[secondParent].isParent = true;
        arr[secondParent].numOfAstr = arr[secondParent].numOfAstr + arr[firstParent].numOfAstr;
        arr[firstParent].numOfAstr = 1;
    }

    private static int find(AstSet[] arr, int ast) {
        if (arr[ast].parent != ast) {
            arr[ast].parent = find(arr, arr[ast].parent);
        }
        return arr[ast].parent;
    }
}
