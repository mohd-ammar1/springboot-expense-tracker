package com.project.expense_tracker.repositry;

import com.project.expense_tracker.entity.UserSchema;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepositry extends JpaRepository<UserSchema,Long> {

    UserSchema findByEmailAndPassword(String email, String password);
    boolean existsByEmailAndPassword(String email, String password);
}
