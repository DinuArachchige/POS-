package com.example.demo.Service;


import com.example.demo.DTO.CustomerDTO;

import java.util.ArrayList;


public interface CustomerService {

    public ArrayList<CustomerDTO> getAllCustomers();

    public CustomerDTO getCustomer(String customerId);

    public boolean deleteCustomer(String customerId);

    public boolean saveCustomer(CustomerDTO customer);

    public long getTotalCustomers();

    public CustomerDTO searchCustomer(String id);

}
