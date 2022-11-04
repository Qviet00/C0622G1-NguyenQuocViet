package com.example.repository.customer;


import com.example.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(
            value = "select * from furama.customer where customer_name like %:nameSearch% " +
                    "and email like %:email% " +
                    "and customer_type_id like %:customer_type_id% ",
            nativeQuery = true)
    Page<Customer> findAllByNameAndAdress(@Param("nameSearch") String nameSearch,
                                          @Param("email")String email,
                                          @Param("customer_type_id")String customer_type_id, Pageable pageable);
}