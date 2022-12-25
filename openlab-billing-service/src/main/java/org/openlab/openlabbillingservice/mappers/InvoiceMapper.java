package org.openlab.openlabbillingservice.mappers;

import org.mapstruct.Mapper;
import org.openlab.openlabbillingservice.dtos.InvoiceRequestDTO;
import org.openlab.openlabbillingservice.dtos.InvoiceResponseDTO;
import org.openlab.openlabbillingservice.entities.Invoice;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {
    Invoice fromInvoiceRequestDTO(InvoiceRequestDTO invoiceRequestDTO);
    InvoiceResponseDTO fromInvoice(Invoice invoice);
}
