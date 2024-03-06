/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.purchaseorder;

import domain.PurchaseOrder;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Veljko
 */
public class GetAllPurchaseOrdersSO extends AbstractSO {
    
    private List<PurchaseOrder> purchaseOrders;

    @Override
    protected void preconditions(Object param) throws Exception {
        //no precoditions needed to be checked
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        purchaseOrders=repository.getAll((PurchaseOrder)param);
    }

    public List<PurchaseOrder> getPurchaseOrders() {
        return purchaseOrders;
    }
    
    
    
}
