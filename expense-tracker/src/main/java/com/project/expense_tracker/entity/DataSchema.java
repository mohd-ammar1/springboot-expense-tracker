package com.project.expense_tracker.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Transactions")
public class DataSchema {


    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;


    private float amount;
    private LocalDate date;
    private String type;
    private String note;
    private String PaymentMethod;
    private String Category;

    @ManyToOne
    @JoinColumn(name="Userid", referencedColumnName = "id")
    private UserSchema userSchema;


    @Override
    public String toString() {
        return "DataSchema{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                ", type='" + type + '\'' +
                ", note='" + note + '\'' +
                ", PaymentMethod='" + PaymentMethod + '\'' +
                ", Category='" + Category + '\'' +
                ", userSchema=" + userSchema +
                '}';
    }


}
