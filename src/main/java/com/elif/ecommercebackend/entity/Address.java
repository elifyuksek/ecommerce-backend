package  com.elif.ecommercebackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String name;
    private String surname;
    private String phone;
    private String city;
    private String district;

    @Column(name = "address_detail")
    private String address;

    @Column(name = "user_id")
    private Long userId;
}