package com.example.demo.Controller;


import com.example.demo.DTO.OrderDTO;
import com.example.demo.DTO.OrderDetailDTO;
import com.example.demo.DTO.PlaceOrderDTO;
import com.example.demo.Service.PlaceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/placeorder")
public class PlaceOrderController {

    @Autowired
    private PlaceOrderService placeOrderService;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean placeOrder(@RequestBody PlaceOrderDTO placeOrderDTO) {
        for(OrderDetailDTO detailDTO:placeOrderDTO.getOrderDetailDTOS()){
            System.out.println(" dto  "+detailDTO.getItem());
        }
       // System.out.println("s   "+placeOrderDTO.getOrderDetailDTOS() );
        return placeOrderService.placeOrder(placeOrderDTO);
        }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<OrderDTO> getAllOrders() {
        return placeOrderService.getAllOders();
    }

    @GetMapping(value = "/count", produces = MediaType.APPLICATION_JSON_VALUE)
    public long getOrdersCount(){

        return placeOrderService.getTotalOrders();
    }

}
