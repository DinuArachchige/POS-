package com.example.demo.Repository;


import com.example.demo.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CustomerRepository extends JpaRepository<Customer, String> {

    @Query("SELECT count(c.id) FROM Customer c")
    long getTotalCustomers();


}
