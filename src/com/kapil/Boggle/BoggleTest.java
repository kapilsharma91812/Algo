package com.kapil.Boggle;

/**
 * Created by kapilsharma on 17/06/17.
 */
public class BoggleTest {
    private static final int ROW = 3;
    private static final int COL = 3;
    private static boolean visited[][] = new boolean[ROW][COL];
    private static final String dictonary[] = {"GEEKS", "FOR", "QUIZ", "GO"};

    private static boolean isWord(String str) {
        for (String word : dictonary) {
            if (word.compareTo(str) == 0) {
                return true;
            }
        }
        return false;
    }

    private static void findWords(char boggle[][]) {
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                findWordUtil(boggle, visited, i, j, str);
            }
        }
    }

    private static void findWordUtil(char[][] boggle, boolean[][] visited, int currentRow, int currentCol, StringBuffer str) {
        visited[currentRow][currentCol] = true;
        str.append(boggle[currentRow][currentCol]);
        if (isWord(str.toString())) {
            System.out.println(str);
        }
        for (int row = currentRow - 1; row <= currentRow + 1; row++) {
            for (int col = currentCol - 1; col <= currentCol + 1; col++) {
                if (row >= 0 && col >= 0 && row < ROW && col < COL && !visited[row][col]) {
                    findWordUtil(boggle, visited, row, col, str);
                }
            }
        }
        str.deleteCharAt(str.length() - 1);
        visited[currentRow][currentCol] = false;
    }

    public static void main(String[] args) {
        char boggle[][] = {
                            {'G', 'I', 'Z'},
                            {'U', 'E', 'K'},
                            {'Q', 'S', 'E'}
                          };
        findWords(boggle);
    }
}
