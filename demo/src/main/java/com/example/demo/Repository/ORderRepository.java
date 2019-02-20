package com.example.demo.Repository;

import com.example.demo.Entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ORderRepository extends JpaRepository<Orders,String> {

    @Query("SELECT count(o.oId) FROM Orders o")
    long getTotalOrders();
}
