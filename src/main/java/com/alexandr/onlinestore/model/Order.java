package com.alexandr.onlinestore.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @OneToMany(mappedBy = "order")
    private List<Item> orderListItems;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "order_price")
    private Integer orderPrice;

    @Column(name = "order_weight")
    private Double orderWeight;

    @Column(name = "order_comment")
    private String orderComment;

}
