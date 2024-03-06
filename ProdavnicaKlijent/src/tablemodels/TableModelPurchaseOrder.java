/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablemodels;

import controller.ControllerUI;
import domain.Customer;
import domain.PurchaseOrder;
import domain.Worker;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Veljko
 */
public class TableModelPurchaseOrder extends AbstractTableModel {
    
    private List<PurchaseOrder> purchaseOrders;
    private List<Customer> customers;
    private List<Worker> workers;
    private String[] columns = {"ID","Datum od","Datum do","Ukupna cena","Kupac","Radnik"};
    
    public TableModelPurchaseOrder(List<PurchaseOrder> purchaseOrders) {
        this.purchaseOrders=purchaseOrders;
        try {
            this.customers=ControllerUI.getInstance().getAllCustomers();
            this.workers=ControllerUI.getInstance().getAllWorkers();
        } catch (Exception ex) {
            Logger.getLogger(TableModelPurchaseOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }


    @Override
    public int getRowCount() {
        if(purchaseOrders==null){
            return 0;
        }
        return purchaseOrders.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PurchaseOrder purchaseOrder = purchaseOrders.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return purchaseOrder.getPurchaseOrderID();
            case 1:
                return purchaseOrder.getDateFrom();
            case 2:
                return purchaseOrder.getDateTo();
            case 3:
                return purchaseOrder.getTotalPrice();
            case 4:
                for(Customer customer:customers){
                    if(customer.getCustomerID()==purchaseOrder.getCustomerID()){
                        return customer.getFullName();
                    }
                }
            case 5:
                for(Worker worker:workers){
                    if(worker.getWorkerID()==purchaseOrder.getWorkerID()){
                        return worker.getUsername();
                    }
                }
            default:
                return "n/a";
        }
    }

    public List<PurchaseOrder> getPurchaseOrders() {
        return purchaseOrders;
    }

    public PurchaseOrder getPurchaseOrder(int index) {
        return purchaseOrders.get(index);
    }
    
    public void remove(int index){
        purchaseOrders.remove(index);
        fireTableDataChanged();
    }
    
    public void deletePurchaseOrder(int index) throws Exception{
        PurchaseOrder returnPurchaseOrder = ControllerUI.getInstance().deletePurchaseOrder(purchaseOrders.get(index));
        purchaseOrders.remove(index);
        fireTableDataChanged();
    }
    
}
