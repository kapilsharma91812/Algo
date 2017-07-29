package com.kapil.greedy.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


/**
 * Created by kapilsharma on 29/07/17.
 */

//Found solution on youtube https://www.youtube.com/watch?v=19tY6Y90TP0
public class SnakeLadder {

    static class QueueEntry {
        int vertex; // Vertex number
        int distance; // distance of this vertex from source
    }

    static int MinimumDiceThrows(int board[], int N) {

        boolean[] visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            visited[i] = false;
        }

        Queue<QueueEntry> q = new LinkedList<>();

        visited[0] = true;
        QueueEntry s = new QueueEntry();
        s.distance = 0;
        s.vertex = 0;
        q.add(s);

        QueueEntry qe = new QueueEntry();
        int i = 0;

        while (!q.isEmpty()) {

            qe = q.peek();
            int vertex = qe.vertex;

            if (vertex == N - 1) {
                return qe.distance;
            }

            q.remove();
            for (i = vertex + 1; i <= (vertex + 6) && i < N; ++i) {

                if (visited[i] == false) {

                    QueueEntry cell = new QueueEntry();
                    cell.distance = (qe.distance + 1);
                    visited[i] = true;
                    if (board[i] != -1) {

                        cell.vertex = board[i];

                    } else {

                        cell.vertex = i;

                    }
                    q.add(cell);

                }
            }
        }
        return -1;

    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/com/kapil/input2.txt");
        Scanner in = new Scanner(file);
        int queries = in.nextInt();
        for (int query = 0; query < queries; query++) {
            int N = 100; // number of cells
            int[] board = new int[N];
            for (int i = 0; i < N; i++)
                board[i] = -1;

            scanLadderSnakes(in, board);
            scanLadderSnakes(in, board);
            System.out.println(MinimumDiceThrows(board, N));
        }

    }


    private static void scanLadderSnakes(Scanner in, int[] board) {
        int ladderCount = in.nextInt();
        for (int i = 0; i < ladderCount; i++) {
            board[in.nextInt() - 1] = in.nextInt() - 1;
        }
    }
}
