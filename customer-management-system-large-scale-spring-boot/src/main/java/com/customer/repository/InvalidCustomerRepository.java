package com.customer.repository;

import com.customer.entities.InvalidCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: Md. Tanver Ahammed,
 * ICT, MBSTU
 */

public interface InvalidCustomerRepository extends JpaRepository<InvalidCustomer, Long> {

    boolean existsByContactOrEmail(String contact, String email);

}
