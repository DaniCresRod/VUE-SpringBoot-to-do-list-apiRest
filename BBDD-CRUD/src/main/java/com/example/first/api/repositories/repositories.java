package com.example.first.api.repositories;

import com.example.first.api.models.models;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface repositories extends CrudRepository<models, Integer> {
    List<models> findByProdType(String type);
}
