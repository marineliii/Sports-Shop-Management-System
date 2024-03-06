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
public class SavePurchaseOrderSO extends AbstractSO {

    @Override
    protected void preconditions(Object param) throws Exception {
        if(param == null || !(param instanceof PurchaseOrder)){
            throw new Exception("Objekat nije porudzbenica");
        }
        PurchaseOrder purchaseOrder = (PurchaseOrder) param;
        if(doesExist(purchaseOrder)){
            throw new Exception("Porudzbenica vec postoji");
        }
        if(((PurchaseOrder)param).getPurchaseOrderItems().isEmpty()){
            throw new Exception("Lista stavki je prazna");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.save((PurchaseOrder)param);
        for (PurchaseOrderItem item : ((PurchaseOrder)param).getPurchaseOrderItems()) {
            item.setPurchaseOrder((PurchaseOrder)param);
            repository.save(item);
        }
        repository.update((PurchaseOrder)param);
    }

    private boolean doesExist(PurchaseOrder purchaseOrder) {
        List<PurchaseOrder> purchaseOrders = new ArrayList<>();
        try {
            purchaseOrders=Controller.getInstance().getAllPurchaseOrders();
        } catch (Exception ex) {
            Logger.getLogger(SavePurchaseOrderSO.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (PurchaseOrder purchaseOrderHelp : purchaseOrders) {
            if(purchaseOrderHelp.getDateFrom().equals(purchaseOrder.getDateFrom())
                    && purchaseOrderHelp.getDateTo().equals(purchaseOrder.getDateTo())
                    && purchaseOrderHelp.getCustomerID()==purchaseOrder.getCustomerID()){
                return true;
            }
        }
        return false;
    }
    
}
