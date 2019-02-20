package com.example.demo.Repository;

import com.example.demo.Entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ItemRepositry extends JpaRepository<Items,String> {

    @Query("SELECT count(i.code) FROM Items i")
    long getTotalItems();

}
