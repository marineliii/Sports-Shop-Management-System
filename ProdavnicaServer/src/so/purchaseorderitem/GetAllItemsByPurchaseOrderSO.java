/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.purchaseorderitem;

import domain.PurchaseOrder;
import domain.PurchaseOrderItem;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Veljko
 */
public class GetAllItemsByPurchaseOrderSO extends AbstractSO {
    
    private List<PurchaseOrderItem> purchaseOrderItems;
    
    private PurchaseOrder filter;

    @Override
    protected void preconditions(Object param) throws Exception {
        //no precoditions needed to be checked
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        purchaseOrderItems=repository.getAllByObject((PurchaseOrderItem)param, (PurchaseOrder)filter);
    }

    public List<PurchaseOrderItem> getPurchaseOrderItems() {
        return purchaseOrderItems;
    }

    public void setFilter(PurchaseOrder filter) {
        this.filter = filter;
    }
    
    
    
}
