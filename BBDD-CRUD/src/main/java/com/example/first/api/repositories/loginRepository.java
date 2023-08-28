package com.example.first.api.repositories;

import com.example.first.api.models.loginModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface loginRepository extends JpaRepository<loginModel, Integer> {

    @Query(value = "SELECT * FROM login_model WHERE user_email = :userEmail AND user_password = :userPassword", nativeQuery = true)
//  @Query(value = "SELECT user_email FROM login_model WHERE user_email = :userEmail AND user_password = :userPassword", nativeQuery = true)
    loginModel findByUserEmailAndUserPassword(@Param("userEmail") String userEmail, @Param("userPassword") String userPassword);

    @Query(value = "SELECT * FROM login_model WHERE user_email = :userEmail", nativeQuery = true)
    loginModel findByUserEmail(String userEmail);
}
