package com.adSquare.tiktaktoe.controller;

import com.adSquare.tiktaktoe.helper.TikTakToeControllerHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TikTakToeController {

    @Autowired
    MdbController dbController;

    private static int[][] matrix = new int[3][3];
    private static boolean gameFinished;
    private static String gameId = "";
    private static Map<String, Integer> gamerIdToNumMap = new HashMap<>();


    @GetMapping("/tiktaktoe/startGame")
    public boolean startGame(@RequestParam(value = "player1") String player1, @RequestParam(value = "player2") String player2) {
        createGamerConfigs(player1, player2);
        dbController.saveMatrixData(gameId, matrix);
        return true;
    }

    private void createGamerConfigs(String player1, String player2) {
        gamerIdToNumMap.put(player1, 1);
        gamerIdToNumMap.put(player2, 2);
        gameId = player1 + player2;
    }

    /*
    Assume the UI is taking care of the symbol X and O, since API response is number 1 and 2.
     */
    @GetMapping("/tiktaktoe/player/{id}")
    public int[][] playGame(@PathVariable("id") String id, @RequestParam(value = "row") int row, @RequestParam(value = "column") int column) {
        if (gameFinished)
            return matrix;
        int gamerNum = retrieveGamerNum(id);
        matrix = dbController.getMatrixById(gameId);
        updateMatrixCell(row, column, gamerNum, id);
        return matrix;
    }

    private void updateMatrixCell(int row, int column, int gamerNum, String id) {
        if (matrix[row][column] == 0) {
            matrix[row][column] = gamerNum;
            dbController.saveMatrixData(gameId, matrix);
            gameFinished = TikTakToeControllerHelper.checkWinConditions(gamerNum, id, matrix);
        }
    }

    private int retrieveGamerNum(String id) {
        return gamerIdToNumMap.get(id);
    }

}
