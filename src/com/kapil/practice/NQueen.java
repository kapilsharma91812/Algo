package com.kapil.practice;

import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kapilsharma on 28/11/17.
 */
public class NQueen {

    public static class Position {
        int row;
        int col;
        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }


    public static void main(String[] args) {
        List<Position> positionsList = new ArrayList<>();
        placeQueen(4, 0, positionsList);
        for (Position position: positionsList) {
            System.out.println("placed:" + position.row + "," + position.col);
        }




    }

    private static boolean placeQueen(int queenCount, int queen, List<Position> positionsList) {

        if (queenCount == queen) {
            return true;
        }

        for (int col = 0;  col < queenCount; col++) {
            if (!isUnderAttack(queen, col, positionsList)) {
                positionsList.add(new Position(queen, col));
                if (!placeQueen(queenCount, queen + 1, positionsList)) {
                    positionsList.remove(queen);
                } else {
                    return true;
                }
            }

        }
        return false;
    }

    private static boolean isUnderAttack(int row, int col, List<Position> positionsList) {

        for (Position position: positionsList) {
            //case row
            if (position.row == row) {
                return true;
            } else if (position.col == col) { //case col
                return true;
            } else if (position.row + position.col == row + col) { //case row+col
                return true;
            } else if (position.row - position.col == row - col) { //case row -col
                return true;
            }
        }

        return false;
    }


}
