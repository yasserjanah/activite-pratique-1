package org.openlab.openlabbillingservice.exceptions;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(String s) {
        super(s);
    }
}
