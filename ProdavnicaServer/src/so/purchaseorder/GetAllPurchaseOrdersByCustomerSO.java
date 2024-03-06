/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.purchaseorder;

import domain.Customer;
import domain.PurchaseOrder;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Veljko
 */
public class GetAllPurchaseOrdersByCustomerSO extends AbstractSO {
    
    private List<PurchaseOrder> purchaseOrders;
    private Customer filter;

    @Override
    protected void preconditions(Object param) throws Exception {
        //no conditions needed to be checked
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        purchaseOrders=repository.getAllByObject((PurchaseOrder)param, (Customer)filter);
    }

    public List<PurchaseOrder> getPurchaseOrders() {
        return purchaseOrders;
    }

    public void setFilter(Customer filter) {
        this.filter = filter;
    }
    
    
    
}
