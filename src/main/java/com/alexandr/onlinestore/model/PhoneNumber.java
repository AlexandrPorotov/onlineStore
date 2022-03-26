package com.alexandr.onlinestore.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "phone_numbers")
public class PhoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phone_number_id")
    private Long phoneNumberId;

    @Column(name = "phone_number_prefix")
    private String phoneNumberPrefix;

    @Column(name = "phone_number_body")
    private String phoneNumberBody;

    @OneToOne(mappedBy = "userPhoneNumber")
    private User user;

}
