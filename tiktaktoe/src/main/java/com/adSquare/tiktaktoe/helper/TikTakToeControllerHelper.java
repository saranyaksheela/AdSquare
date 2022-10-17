package com.adSquare.tiktaktoe.helper;

public class TikTakToeControllerHelper {

    public static boolean checkWinConditions(int id, String gamerId, int[][] matrix) {
        if (
                (matrix[0][0] == id) && (matrix[0][1] == id) && (matrix[0][2] == id)
        ) {
            return setGameFinished(gamerId);
        }
        if (
                (matrix[1][0] == id) &&
                        (matrix[1][1] == id) &&
                        (matrix[1][2] == id)
        ) {
            return setGameFinished(gamerId);
        }
        if (
                (matrix[2][0] == id) &&
                        (matrix[2][1] == id) &&
                        (matrix[2][2] == id)
        ) {
            return setGameFinished(gamerId);
        }
        if (
                (matrix[0][0] == id) &&
                        (matrix[1][0] == id) &&
                        (matrix[2][0] == id)
        ) {
            return setGameFinished(gamerId);
        }
        if (
                (matrix[0][1] == id) &&
                        (matrix[1][1] == id) &&
                        (matrix[2][1] == id)
        ) {
            return setGameFinished(gamerId);
        }
        if (
                (matrix[0][2] == id) &&
                        (matrix[1][2] == id) &&
                        (matrix[2][2] == id)
        ) {
            return setGameFinished(gamerId);
        }
        if (
                (matrix[0][0] == id) &&
                        (matrix[1][1] == id) &&
                        (matrix[2][2] == id)
        ) {
            return setGameFinished(gamerId);
        }
        if (
                (matrix[0][2] == id) &&
                        (matrix[1][1] == id) &&
                        (matrix[2][0] == id)
        ) {
            return setGameFinished(gamerId);
        }
        if (
                (matrix[2][2] == id) &&
                        (matrix[1][1] == id) &&
                        (matrix[0][0] == id)
        ) {
            return setGameFinished(gamerId);
        }
        return false;
    }

    private static boolean setGameFinished(String gamer) {
        System.out.println(gamer + " wins!!!");
        return true;
    }
}
