package com.elif.ecommercebackend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("card_no")
    @Column(name = "card_no")
    private String cardNo;

    @JsonProperty("expire_month")
    @Column(name = "expire_month")
    private Integer expireMonth;

    @JsonProperty("expire_year")
    @Column(name = "expire_year")
    private Integer expireYear;

    @JsonProperty("name_on_card")
    @Column(name = "name_on_card")
    private String nameOnCard;

    @Column(name = "user_id")
    private Long userId;
}