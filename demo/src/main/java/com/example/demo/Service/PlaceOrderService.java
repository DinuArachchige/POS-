package com.example.demo.Service;


import com.example.demo.DTO.OrderDTO;
import com.example.demo.DTO.PlaceOrderDTO;

import java.util.ArrayList;

public interface PlaceOrderService {

    public boolean placeOrder(PlaceOrderDTO placeOrderDTO);

    public ArrayList<OrderDTO> getAllOders() ;

    public long getTotalOrders();
}
