package org.openlab.openlabcustomerservice.services;

import org.openlab.openlabcustomerservice.dtos.CustomerRequestDTO;
import org.openlab.openlabcustomerservice.dtos.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {
    CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO);
    CustomerResponseDTO getCustomer(String id);
    CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO);
    List<CustomerResponseDTO> listCustomers();
}
