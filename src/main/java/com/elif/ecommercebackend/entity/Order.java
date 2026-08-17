package com.elif.ecommercebackend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("order_date")
    @Column(name = "order_date")
    private LocalDateTime orderDate = LocalDateTime.now();

    @JsonProperty("card_no")
    @Column(name = "card_no")
    private String cardNo;

    @JsonProperty("card_name")
    @Column(name = "card_name")
    private String cardName;

    @JsonProperty("card_expire_month")
    @Column(name = "card_expire_month")
    private Integer cardExpireMonth;

    @JsonProperty("card_expire_year")
    @Column(name = "card_expire_year")
    private Integer cardExpireYear;

    private Double price;

    @JsonProperty("address_id")
    @Column(name = "address_id")
    private Long addressId;

    @Column(name = "user_id")
    private Long userId;
}