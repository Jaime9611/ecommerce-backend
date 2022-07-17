package com.example.ecommerce.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;

@Getter
@Setter
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    private UUID id;

    private Double total;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
