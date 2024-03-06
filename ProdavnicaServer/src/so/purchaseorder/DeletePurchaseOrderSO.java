/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.purchaseorder;

import controller.Controller;
import domain.PurchaseOrder;
import domain.PurchaseOrderItem;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import so.AbstractSO;

/**
 *
 * @author Veljko
 */
public class DeletePurchaseOrderSO extends AbstractSO {

    @Override
    protected void preconditions(Object param) throws Exception {
        if(param == null || !(param instanceof PurchaseOrder)){
            throw new Exception("Objekat nije porudzbenica");
        }   
        PurchaseOrder purchaseOrder = (PurchaseOrder) param;
        if(!isInBase(purchaseOrder)){
            throw new Exception("Porudzbenica ne postoji u bazi");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        List<PurchaseOrderItem> items = Controller.getInstance().getAllItemsByPurchaseOrder((PurchaseOrder) param);
        for (PurchaseOrderItem item : items) {
            repository.delete(item);
        }
        repository.delete((PurchaseOrder)param);
    }
    
    private boolean isInBase(PurchaseOrder purchaseOrder) {
        List<PurchaseOrder> purchaseOrders = new ArrayList<>();
        try {
            purchaseOrders=Controller.getInstance().getAllPurchaseOrders();
        } catch (Exception ex) {
            Logger.getLogger(DeletePurchaseOrderSO.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (PurchaseOrder purchaseOrderHelp : purchaseOrders) {
            if(purchaseOrderHelp.getPurchaseOrderID()==purchaseOrder.getPurchaseOrderID()){
                return true;
            }
        }
        return false;
    }
    
}
