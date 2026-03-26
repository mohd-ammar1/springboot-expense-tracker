package com.project.expense_tracker.repositry;

import com.project.expense_tracker.entity.DataSchema;
import com.project.expense_tracker.entity.UserSchema;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DataRepositry extends JpaRepository<DataSchema,Integer> {
    List<DataSchema> findByUserSchema(UserSchema userSchema);
    
}
