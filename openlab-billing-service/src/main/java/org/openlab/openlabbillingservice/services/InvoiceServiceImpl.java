package org.openlab.openlabbillingservice.services;

import lombok.AllArgsConstructor;
import org.openlab.openlabbillingservice.dtos.InvoiceRequestDTO;
import org.openlab.openlabbillingservice.dtos.InvoiceResponseDTO;
import org.openlab.openlabbillingservice.entities.Customer;
import org.openlab.openlabbillingservice.entities.Invoice;
import org.openlab.openlabbillingservice.exceptions.CustomerNotFoundException;
import org.openlab.openlabbillingservice.mappers.InvoiceMapper;
import org.openlab.openlabbillingservice.openfeign.CustomerRestClient;
import org.openlab.openlabbillingservice.repositories.InvoiceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private InvoiceRepository invoiceRepository;
    private InvoiceMapper invoiceMapper;
    private CustomerRestClient customerRestClient;

    @Override
    public InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO) throws CustomerNotFoundException {
        Customer customer=null;
        try {
            customer = customerRestClient.getCustomer(invoiceRequestDTO.getCustomerID());
        } catch (Exception e){
            System.out.println(e.getMessage());
            throw new CustomerNotFoundException("Customer with id:"+invoiceRequestDTO.getCustomerID()+" not found");
        }

        Invoice invoice = invoiceMapper.fromInvoiceRequestDTO(invoiceRequestDTO);
        invoice.setId(UUID.randomUUID().toString());
        invoice.setDate(new Date());
        invoice.setCustomer(customer);
        // verify first if the customer exists
        return invoiceMapper.fromInvoice(invoiceRepository.save(invoice));
    }

    @Override
    public InvoiceResponseDTO getInvoice(String id) {
        Invoice invoice = invoiceRepository.findById(id).orElse(null);
        assert invoice != null;
        Customer customer = customerRestClient.getCustomer(invoice.getCustomerID());
        invoice.setCustomer(customer);
        return invoiceMapper.fromInvoice(invoice);
    }

    @Override
    public List<InvoiceResponseDTO> invoicesByCustomerId(String customerId) {
        List<Invoice> invoiceList = invoiceRepository.findByCustomerID(customerId);
        invoiceList.forEach(invoice -> {
            Customer customer = customerRestClient.getCustomer(invoice.getCustomerID());
            invoice.setCustomer(customer);
        });

        return invoiceList
                .stream()
                .map(invoice -> invoiceMapper.fromInvoice(invoice))
                .toList();
    }

    @Override
    public List<InvoiceResponseDTO> listInvoices() {
        List<Invoice> invoiceList= invoiceRepository.findAll();
        invoiceList.forEach(invoice -> {
            System.out.println(invoice.getCustomerID());
            Customer customer = customerRestClient.getCustomer(invoice.getCustomerID());
            invoice.setCustomer(customer);
        });

        return invoiceList
                .stream()
                .map(invoice -> invoiceMapper.fromInvoice(invoice))
                .toList();

    }
}
