package com.adSquare.tiktaktoe.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;

import com.adSquare.tiktaktoe.model.TikTakToe;
import com.adSquare.tiktaktoe.repository.MatrixRepository;
import org.springframework.stereotype.Controller;

@Controller
public class MdbController {
    @Autowired
    MatrixRepository matrixItemRepo;

    void saveMatrixData(String id, int[][] matrix) {
        System.out.println("TikTaktoe Data creation started...");
        saveMatrix(id, matrix);
        System.out.println("Data creation complete...");
    }

    public int[][] getMatrixById(String id) {
        System.out.println("Getting item by id: " + id);
        TikTakToe tikTakToe = matrixItemRepo.findItemById(id);
        if(tikTakToe == null) {
            tikTakToe =saveEmptyMatrix(id);
        }
        System.out.println(Arrays.deepToString(tikTakToe.getMatrix()));
        return tikTakToe.getMatrix();
    }

    private TikTakToe saveMatrix(String id, int[][] matrix) {
        TikTakToe tikTakToe = new TikTakToe(id , matrix);
        matrixItemRepo.save(tikTakToe);
        return tikTakToe;
    }

    private TikTakToe saveEmptyMatrix(String id) {
        int[][] matrix = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0},
        };
        return saveMatrix(id, matrix);
    }

}
