package org.openlab.openlabbillingservice.web;

import lombok.AllArgsConstructor;
import org.openlab.openlabbillingservice.dtos.InvoiceRequestDTO;
import org.openlab.openlabbillingservice.dtos.InvoiceResponseDTO;
import org.openlab.openlabbillingservice.exceptions.CustomerNotFoundException;
import org.openlab.openlabbillingservice.services.InvoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
@AllArgsConstructor
public class InvoiceRestController {
    private InvoiceService invoiceService;

    @GetMapping(path = "/invoices")
    public List<InvoiceResponseDTO> listInvoices(){
        return invoiceService.listInvoices();
    }
    @GetMapping(path = "/invoices/{id}")
    public InvoiceResponseDTO getInvoice(@PathVariable(name = "id") String invoiceId){
        return invoiceService.getInvoice(invoiceId);
    }

    @GetMapping(path = "/invoices/customer/{customerId}")
    public List<InvoiceResponseDTO> getInvoiceByCustomer(@PathVariable(name = "customerId") String customerId){
        return invoiceService.invoicesByCustomerId(customerId);
    }

    @PostMapping(path = "/invoices")
    public InvoiceResponseDTO save(@RequestBody InvoiceRequestDTO invoiceRequestDTO) throws CustomerNotFoundException {
        return invoiceService.save(invoiceRequestDTO);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
