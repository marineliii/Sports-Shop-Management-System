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
public class UpdatePurchaseOrderSO extends AbstractSO {

    @Override
    protected void preconditions(Object param) throws Exception {
        if(param == null || !(param instanceof PurchaseOrder)){
            throw new Exception("Objekat nije porudzbenica");
        }   
        PurchaseOrder purchaseOrder = (PurchaseOrder) param;
        if(!isInBase(purchaseOrder)){
            throw new Exception("Porudzbenica ne postoji u bazi");
        }
        if(doesExist(purchaseOrder)){
            throw new Exception("Porudzbenica sa unetim vrednostima vec postoji");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        List<PurchaseOrderItem> items = ((PurchaseOrder)param).getPurchaseOrderItems();
        List<PurchaseOrderItem> itemsDB = repository.getAllByObject(new PurchaseOrderItem(), (PurchaseOrder)param);
        for(int i=0;i<itemsDB.size();i++){
            for (int j = 0; j<items.size();j++) {
                if(items.get(j).getItemID()==itemsDB.get(i).getItemID()){
                    items.remove(items.get(j));
                }
            }
        }
        for (PurchaseOrderItem item : items) {
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
            if((purchaseOrderHelp.getDateFrom().equals(purchaseOrder.getDateFrom())
                    && purchaseOrderHelp.getDateTo().equals(purchaseOrder.getDateTo())
                    && purchaseOrderHelp.getCustomerID()==purchaseOrder.getCustomerID())
                    && purchaseOrder.getPurchaseOrderID()!=purchaseOrderHelp.getPurchaseOrderID()){
                return true;
            }
        }
        return false;
    }

    private boolean isInBase(PurchaseOrder purchaseOrder) {
        List<PurchaseOrder> purchaseOrders = new ArrayList<>();
        try {
            purchaseOrders=Controller.getInstance().getAllPurchaseOrders();
        } catch (Exception ex) {
            Logger.getLogger(UpdatePurchaseOrderSO.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (PurchaseOrder purchaseOrderHelp : purchaseOrders) {
            if(purchaseOrderHelp.getPurchaseOrderID()==purchaseOrder.getPurchaseOrderID()){
                return true;
            }
        }
        return false;
    }
    
}
