package com.customer.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @Author: Md. Tanver Ahammed,
 * ICT, MBSTU
 */

@Entity
@Table(name = "invalid_customers",
        indexes = {
                @Index(columnList = "contact", name = "contact_index"),
                @Index(columnList = "email", name = "email_index")
        }
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvalidCustomer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;

    private String lastName;

    private String city;

    private String country;

    private String postCode;

    @Column(unique = true)
    private String contact;

    @Column(unique = true)
    private String email;

    private String ip;

}
