package com.example.demo.Service.Impl;


import com.example.demo.DTO.*;
import com.example.demo.Entity.*;
import com.example.demo.Repository.ItemRepositry;
import com.example.demo.Repository.ORderRepository;
import com.example.demo.Repository.OrderDetailRepository;
import com.example.demo.Service.PlaceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class PlaceOrderServiceImpl implements PlaceOrderService {
    @Autowired
    private ItemRepositry itemRepositry;

    @Autowired
    private ORderRepository oRderRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean placeOrder(PlaceOrderDTO placeOrderDTO) {

        OrderDTO orderDTO=placeOrderDTO.getOrderDTO();

        CustomerDTO customerDTO=placeOrderDTO.getOrderDTO().getCustomer();

        System.out.println(placeOrderDTO.getOrderDTO().getTotalPric());



        Customer customer=new Customer();
        customer.setId(customerDTO.getId());
        customer.setName(customerDTO.getName());
        customer.setAddress(customerDTO.getAddress());



        Orders orders=new Orders();
        orders.setoId(orderDTO.getoId());
        orders.setCustomer(customer);
        orders.setDate(orderDTO.getDate());
        orders.setTotalPrice(placeOrderDTO.getItemsDTO().getUnicPrice());

        oRderRepository.save(orders);

        List<OrderDetailDTO> orderDetailDTOS=placeOrderDTO.getOrderDetailDTOS();
        System.out.println(orderDetailDTOS.size()+"  Size");
        for (OrderDetailDTO orderDetailDTO : orderDetailDTOS
             ) {

            ItemsDTO itemsDTO=placeOrderDTO.getItemsDTO();

            Items items=new Items();
            items.setCode(itemsDTO.getCode());
            items.setDiscription(itemsDTO.getDiscription());
            items.setUnicPrice(itemsDTO.getUnicPrice());
            items.setQtyOnHand(itemsDTO.getQtyOnHand());

            OrderDetails_PK orderDetails_pk=new OrderDetails_PK();
            orderDetails_pk.setCode(itemsDTO.getCode());
            orderDetails_pk.setoId(orders.getoId());

            OrderDetails orderDetails=new OrderDetails();
            orderDetails.setQuantity((int) orderDetailDTO.getQuantity());
            orderDetails.setUnitprice(orderDetailDTO.getUnitprice());
            orderDetails.setItem(items);
            orderDetails.setOrders(orders);
            orderDetails.setOrderDetail_PK(orderDetails_pk);

            double gap=items.getQtyOnHand()-orderDetailDTO.getQuantity();
            orderDetailRepository.UpdateItem(gap,items.getCode());

            orderDetailRepository.save(orderDetails);


        }
        return true;
    }

    @Override
    public ArrayList<OrderDTO> getAllOders() {
        List<Orders> ordersList = oRderRepository.findAll();

        ArrayList<OrderDTO> allOrders = new ArrayList<>();

        for (Orders orders : ordersList){
            OrderDTO orderDTO=new OrderDTO();
            orderDTO.setoId(orders.getoId());
            orderDTO.setDate(orders.getDate());
            orderDTO.setTotalPric(orders.getTotalPrice());

            allOrders.add(orderDTO);
        }

        return allOrders;

    }

    @Override
    public long getTotalOrders() {
        long totalOrders = oRderRepository.getTotalOrders();
        return totalOrders;
    }
}
