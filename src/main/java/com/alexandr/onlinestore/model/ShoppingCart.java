package com.alexandr.onlinestore.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "shopping_carts")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shopping_cart_id")
    private Long shoppingCatId;

    @OneToMany(mappedBy = "shoppingCart")
    private List<Item> itemList;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
