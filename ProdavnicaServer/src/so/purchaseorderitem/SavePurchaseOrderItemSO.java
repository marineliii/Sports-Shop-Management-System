/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.purchaseorderitem;

import controller.Controller;
import domain.PurchaseOrder;
import domain.PurchaseOrderItem;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import so.AbstractSO;
import so.purchaseorder.SavePurchaseOrderSO;

/**
 *
 * @author Veljko
 */
public class SavePurchaseOrderItemSO extends AbstractSO {

    @Override
    protected void preconditions(Object param) throws Exception {
        if(param == null || !(param instanceof PurchaseOrderItem)){
            throw new Exception("Objekat nije stavka");
        }
        PurchaseOrderItem purchaseOrderItem = (PurchaseOrderItem) param;
        if(doesExist(purchaseOrderItem)){
            throw new Exception("Stavka za izabrani artikal vec postoji u izabranoj porudzbenici");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.save((PurchaseOrderItem)param);
    }

    private boolean doesExist(PurchaseOrderItem purchaseOrderItem) {
        List<PurchaseOrder> orders = new ArrayList<>();
        List<PurchaseOrderItem> items = new ArrayList<>();
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        try {
            orders=Controller.getInstance().getAllPurchaseOrders();
            for (PurchaseOrder order : orders) {
                if(order.getPurchaseOrderID()==purchaseOrderItem.getPurchaseOrder().getPurchaseOrderID()){
                    purchaseOrder=order;
                }
            }
            items=Controller.getInstance().getAllItemsByPurchaseOrder(purchaseOrder);
        } catch (Exception ex) {
            Logger.getLogger(SavePurchaseOrderSO.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (PurchaseOrderItem item : items) {
            if(item.getArticleID()==purchaseOrderItem.getArticleID()
                    && item.getPurchaseOrder().getPurchaseOrderID()==purchaseOrderItem.getPurchaseOrder().getPurchaseOrderID()){
                return true;
            }
        }
        return false;
    }
    
}
