package com.kapil.backtracking;

/**
 * Created by kapilsharma on 18/07/17.
 */
public class RatInMaze {
   static int mat[][] = new int[][]{
            {1, 1, 1, 1},
            {1, 1, 0, 1},
            {1, 0, 0, 1},
            {1, 0, 1, 1}
    };

    static int rowMoves[] = new int[]{1, 0, -1, 0};
    static int colMoves[] = new int[]{0, 1, 0, -1};
    public static void main(String[] args) {

       System.out.println("Solution:" +  findPath(0, 0));
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println("\n");
        }

    }

    private static boolean findPath(int i, int j) {
        if (!isValidMove(i, j)) {
            return false;
        }
        if (i == mat.length - 1 && j == mat.length - 1) {
            mat[i][j] = 2;
            return true;
        }
        if (mat[i][j] == 1) {
            for (int move = 0; move < rowMoves.length; move++) {
                mat[i][j] = -1;
               boolean isPossible = findPath(i + rowMoves[move], j + colMoves[move]);
                if (isPossible) {
                    mat[i][j] = 2;
                    return true;
                } else {
                    mat[i][j] = 1;
                }
            }
        }
            return  false;
    }

    private static boolean isValidMove(int i, int j) {
        if (i < mat.length && j < mat.length && i >= 0 && j >= 0) {
            return true;
        }
        return false;
    }
}
