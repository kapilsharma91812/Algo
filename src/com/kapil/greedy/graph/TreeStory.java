package com.kapil.greedy.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by kapilsharma on 30/07/17.
 */
public class TreeStory {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/com/kapil/input2.txt");
        Scanner in = new Scanner(file);
        int queries = in.nextInt();
        for (int query = 0; query < queries; query++) {
            int numOfNodes = in.nextInt();
            for (int i = 0; i < numOfNodes - 1; i++) {
                in.nextInt(); in.nextInt();
            }
            int guess = in.nextInt();
            in.nextInt();
            HashSet<Integer> mHashSet = new HashSet<>();
            for(int i = 0; i < guess; i++) {
                int u = in.nextInt();
                in.nextInt();
                if(!mHashSet.contains(u)) {
                    mHashSet.add(u);
                }
            }
            if (numOfNodes % mHashSet.size() == 0) {
                System.out.println(1 + "/" + (numOfNodes/ mHashSet.size()));
            } else {
                System.out.println(mHashSet.size() + "/" + numOfNodes);
            }
        }
    }
}
