package org.openlab.openlabcustomerservice.mappers;

import org.mapstruct.Mapper;
import org.openlab.openlabcustomerservice.dtos.CustomerRequestDTO;
import org.openlab.openlabcustomerservice.dtos.CustomerResponseDTO;
import org.openlab.openlabcustomerservice.entities.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerResponseDTO customerToCustomerResponseDTO(Customer customer);
    Customer customerRequestDTOToCustomer(CustomerRequestDTO customerRequestDTO);
}
