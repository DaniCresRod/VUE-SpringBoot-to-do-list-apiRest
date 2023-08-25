package com.example.first.api.repositories;

import com.example.first.api.models.loginModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface loginRepository extends JpaRepository<loginModel, Integer> {
}
