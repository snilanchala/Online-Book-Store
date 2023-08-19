package com.bookStore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "MyBooks")
public class MyBookList {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String name;
    private String author;
    private String price;
}
