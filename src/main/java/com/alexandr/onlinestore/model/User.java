package com.alexandr.onlinestore.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_last_name")
    private String userLastName;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_login")
    private String userLogin;

    @Column(name = "user_password")
    private String userPassword;

    @OneToOne
    @JoinColumn(name = "phone_id")
    private PhoneNumber userPhoneNumber;

    @Column(name = "user_b_day")
    private LocalDateTime userBDay;

    @OneToMany(mappedBy = "user")
    private List<ShoppingCart> shoppingCartUser;

    @OneToMany(mappedBy = "user")
    private List<Order> userOrdersHistory;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address userAddress;

}
