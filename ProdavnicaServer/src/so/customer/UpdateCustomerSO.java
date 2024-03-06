/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.customer;

import controller.Controller;
import domain.Customer;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import so.AbstractSO;

/**
 *
 * @author Veljko
 */
public class UpdateCustomerSO extends AbstractSO {

    @Override
    protected void preconditions(Object param) throws Exception {
        if(param == null || !(param instanceof Customer)){
            throw new Exception("Objekat nije kupac");
        }
        Customer customer = (Customer) param;
        if(!isInBase(customer)){
            throw new Exception("Kupac ne postoji u bazi");
        }
        String error=doesExist(customer);
        if(error!=null){
            throw new Exception(error);
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.update((Customer)param);        
    }

    private boolean isInBase(Customer customer) {
        List<Customer> customers = new ArrayList<>();
        try {
            customers=Controller.getInstance().getAllCustomers();
        } catch (Exception ex) {
            Logger.getLogger(SaveCustomerSO.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Customer customerHelp : customers) {
            if(customerHelp.getCustomerID()==customer.getCustomerID()){
                return true;
            }
        }
        return false;
    }
    
    private String doesExist(Customer customer) {
        List<Customer> customers = new ArrayList<>();
        try {
            customers=Controller.getInstance().getAllCustomers();
        } catch (Exception ex) {
            Logger.getLogger(SaveCustomerSO.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Customer customerHelp : customers) {
            if(customerHelp.getEmail().equals(customer.getEmail())){
                return "Kupac sa unetim emailom vec postoji";
            }
            if(customerHelp.getPhoneNumber().equals(customer.getPhoneNumber())){
                return "Kupac sa unetim brojem telefona vec postoji";
            }
        }
        return null;
    }
    
}
