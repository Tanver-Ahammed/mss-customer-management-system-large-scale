package com.customer.dto;

import lombok.*;

/**
 * @Author: Md. Tanver Ahammed,
 * ICT, MBSTU
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerDTO {

    private long id;

    private String firstName;

    private String lastName;

    private String city;

    private String country;

    private String postCode;

    private String contact;

    private String email;

    private String ip;

}
