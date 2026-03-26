package com.project.expense_tracker.config;

import com.project.expense_tracker.entity.QDataSchema;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueryDSLConfig {

    @Bean
    public JPAQueryFactory jpaQueryFactory(EntityManager entityManager) {
        return  new JPAQueryFactory(entityManager);
    }

    public static BooleanExpression nameEq(String name){
            return name!= null ? QDataSchema.dataSchema.name.eq(name):null;
    }
    public static BooleanExpression amountEq(float amount){
            return amount != 0 ? QDataSchema.dataSchema.amount.eq(amount):null;
    }
    public static BooleanExpression dateEq(LocalDate date){
            return date!= null ? QDataSchema.dataSchema.date.eq(date):null;
    }
    public static BooleanExpression paymentMethodEq(String paymentMethod){
        return paymentMethod!= null ? QDataSchema.dataSchema.PaymentMethod.eq(paymentMethod):null;  
    }
    

}
