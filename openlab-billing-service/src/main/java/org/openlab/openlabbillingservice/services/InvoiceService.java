package org.openlab.openlabbillingservice.services;

import org.openlab.openlabbillingservice.dtos.InvoiceRequestDTO;
import org.openlab.openlabbillingservice.dtos.InvoiceResponseDTO;
import org.openlab.openlabbillingservice.exceptions.CustomerNotFoundException;

import java.util.List;

public interface InvoiceService {
    InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO) throws CustomerNotFoundException;
    InvoiceResponseDTO getInvoice(String id);
    List<InvoiceResponseDTO> invoicesByCustomerId(String customerId);
    List<InvoiceResponseDTO> listInvoices();
}
