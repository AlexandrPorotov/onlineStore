package com.alexandr.onlinestore.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_description")
    private String itemDescription;

    @Column(name = "item_price")
    private Integer itemPrice;

    @Column(name = "item_article_number")
    private String itemArticleNumber;

    @Column(name = "item_weight")
    private Double itemWeight;

    @Column(name = "item_type")
    private String itemType;

    @Column(name = "item_group")
    private String itemGroup;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "shopping_cart_id")
    private ShoppingCart shoppingCart;

}
