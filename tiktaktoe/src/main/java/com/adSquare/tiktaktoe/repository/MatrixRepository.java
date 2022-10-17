package com.adSquare.tiktaktoe.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.adSquare.tiktaktoe.model.TikTakToe;

public interface MatrixRepository extends MongoRepository<TikTakToe, String> {
    @Query("{id:'?0'}")
    TikTakToe findItemById(String id);

}
