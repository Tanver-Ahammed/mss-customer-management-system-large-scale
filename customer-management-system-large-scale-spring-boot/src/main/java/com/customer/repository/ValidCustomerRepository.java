package com.customer.repository;

import com.customer.entities.ValidCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: Md. Tanver Ahammed,
 * ICT, MBSTU
 */

public interface ValidCustomerRepository extends JpaRepository<ValidCustomer, Long> {

    boolean existsByContactOrEmail(String contact, String email);

}
