/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.customer;

import domain.Customer;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Veljko
 */
public class GetAllCustomersSO extends AbstractSO {
    
    private List<Customer> customers;

    @Override
    protected void preconditions(Object param) throws Exception {
        //no preconditions needed to be checked
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        customers=repository.getAll((Customer)param);
    }

    public List<Customer> getCustomers() {
        return customers;
    }
    
    
    
}
