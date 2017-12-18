package com.kapil.practice;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by kapilsharma on 30/11/17.
 */
public class BogglePr {
    Set<String> dictionary = new HashSet<>();

    public static void main(String[] args) {
        BogglePr pr = new BogglePr();
        pr.setDictionary();
        char boggle[][]   = {{'G','I','Z'},
            {'U','E','K'},
            {'Q','S','E'}};

        printWords(boggle);

    }

    private static void printWords(char[][] boggle) {
        for (int i =0; i< boggle.length; i++) {
            for (int j=0; j < boggle[i].length; j++) {
                System.out.println(boggle[i][j]);
            }
        }
    }

    private void setDictionary() {
        dictionary.add("GEEKS");
        dictionary.add("FOR");
        dictionary.add("QUIZ");
        dictionary.add("GO");
    }
}
