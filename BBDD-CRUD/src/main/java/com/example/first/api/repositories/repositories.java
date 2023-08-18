package com.example.first.api.repositories;

import com.example.first.api.models.models;
import org.springframework.data.repository.CrudRepository;

public interface repositories extends CrudRepository<models, Integer> {
}
