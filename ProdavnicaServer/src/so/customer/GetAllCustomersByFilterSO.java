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
public class GetAllCustomersByFilterSO extends AbstractSO {
    
    private List<Customer> customers;
    private String filter;

    @Override
    protected void preconditions(Object param) throws Exception {
        //no preconditions needed to be cheked
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        customers=repository.getAllByFilter((Customer)param, (String)filter);
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }
    
    
}
