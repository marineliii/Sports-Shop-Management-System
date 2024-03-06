/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.purchaseorderitem;

import domain.PurchaseOrderItem;
import so.AbstractSO;

/**
 *
 * @author Veljko
 */
public class DeletePurchaseOrderItemSO extends AbstractSO{

    @Override
    protected void preconditions(Object param) throws Exception {
        if(param == null || !(param instanceof PurchaseOrderItem)){
            throw new Exception("Objekat nije stavka");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.delete((PurchaseOrderItem)param);
    }

    
    
}
