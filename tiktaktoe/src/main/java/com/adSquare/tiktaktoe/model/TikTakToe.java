package com.adSquare.tiktaktoe.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("TikTakToe")
public class TikTakToe {

    @Id
    private String id;

    public int[][] getMatrix() {
        return matrix;
    }

    int[][] matrix;

    public TikTakToe(String id, int[][] matrix) {
        super();
        this.id = id;
        this.matrix = matrix;
    }
}