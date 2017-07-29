package com.kapil.greedy.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by kapilsharma on 26/07/17.
 */
public class RoadnLib {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/com/kapil/input.txt");
        Scanner scanner = new Scanner(file);
        int queries = scanner.nextInt();
        for (int i = 0; i < queries; i++) {
            System.out.println("Min cost:" + getMinCost(scanner, scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
        }
    }

    private static int getMinCost(Scanner scanner, int cities, int roads, int libCost, int repairCost) {
        int adjMat[][] = new int[cities][cities];
        for (int i = 0; i < roads; i++) {
            int src = scanner.nextInt();
            int dest = scanner.nextInt();
            adjMat[src - 1][dest - 1] = repairCost;
            adjMat[dest - 1][src - 1] = repairCost;
        }

        return getMinCostUtil(adjMat, cities, libCost, repairCost);
    }

    private static int getMinCostUtil(int[][] adjMat, int cities, int libCost, int repairCost) {
        int cost[] = new int[cities];
        boolean status[] = new boolean[cities];
        boolean isLib[] = new boolean[cities];
        for (int i = 0; i < cities; i++) {
            cost[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < cities; i++) {
            if (cost[i] == Integer.MAX_VALUE) {
                cost[i] = libCost;
                isLib[i] = true;
            }
            int currentCost = cost[i];
            if (isLib[i]) {
                currentCost = 0;
            }

            //visit all adj cities
            for (int j = 0; j < cities; j++) {
                if (adjMat[i][j] > 0 && !status[j]) {
                    int newCost = currentCost + repairCost;
                    if (adjMat[i][j] < cost[j]) {
                        cost[j] = newCost;
                        isLib[j] = false;
                    }
                    if (cost[j] >= libCost) {
                        cost[j] = libCost;
                        isLib[j] = true;
                    }

                }
            }
            status[i] = true;
        }
        int sum = 0;
        for (int i = 0; i < cities; i++) {
            sum = sum + cost[i];
        }

        return sum;
    }

}
