/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Veljko
 */
public class PurchaseOrder implements GenericEntity {
    private int purchaseOrderID;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private double totalPrice;
    private int customerID;
    private int workerID;
    private List<PurchaseOrderItem> purchaseOrderItems;

    public PurchaseOrder() {
        this.purchaseOrderItems=new ArrayList<>();
        this.totalPrice=0;
    }

    public PurchaseOrder(int purchaseOrderID, LocalDate dateFrom, LocalDate dateTo, double totalPrice, int customerID, int workerID) {
        this.purchaseOrderID = purchaseOrderID;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.totalPrice = totalPrice;
        this.customerID = customerID;
        this.workerID = workerID;
        this.purchaseOrderItems=new ArrayList<>();
    }


    

    public int getPurchaseOrderID() {
        return purchaseOrderID;
    }

    public void setPurchaseOrderID(int purchaseOrderID) {
        this.purchaseOrderID = purchaseOrderID;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
    
   

    public int getWorkerID() {
        return workerID;
    }

    public void setWorkerID(int workerID) {
        this.workerID = workerID;
    }

    @Override
    public String getTableName() {
        return "porudzbenica";
    }

    @Override
    public String getInsertColumns() {
        return "datumOd, datumDo, ukupnaCena, kupacID_fk, radnikID_fk";
    }

    @Override
    public String getInsertValues() {
        return "'"+dateFrom.toString()+"','"+dateTo.toString()+"',"+totalPrice+","+customerID+","+workerID;
    }

    @Override
    public void setId(int id) {
        this.purchaseOrderID=id;
    }

    @Override
    public String getUpdateQuery() {
        return "datumOd='"+dateFrom.toString()+"', datumDo='"+dateTo.toString()+"', ukupnaCena="+totalPrice;
    }

    @Override
    public String getWhereQuery() {
        return "porudzbenicaID="+purchaseOrderID;
    }

    @Override
    public List<GenericEntity> getAllObjects(ResultSet rs) {
        List<GenericEntity> purchaseOrders=new ArrayList<>();
        try {
            while(rs.next()){
                int purchaseOrderID = rs.getInt("porudzbenicaID");
                LocalDate dateFrom = rs.getDate("datumOd").toLocalDate();
                LocalDate dateTo = rs.getDate("datumDo").toLocalDate();
                Double totalPrice = rs.getDouble("ukupnaCena");
                int customerID = rs.getInt("kupacID_fk");
                int workerID = rs.getInt("radnikID_fk");
                PurchaseOrder purchaseOrder = new PurchaseOrder(purchaseOrderID, dateFrom, dateTo, totalPrice, customerID, workerID);
                purchaseOrders.add(purchaseOrder);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return purchaseOrders;
    }

    @Override
    public String getWhereQueryWithFilter(Object filter) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getWhereQueryWithObject(Object object) {
        return "kupacID_fk="+((Customer)object).getCustomerID();
    }

    public List<PurchaseOrderItem> getPurchaseOrderItems() {
        return purchaseOrderItems;
    }

    public void setPurchaseOrderItems(List<PurchaseOrderItem> purchaseOrderItems) {
        this.purchaseOrderItems = purchaseOrderItems;
    }

    

    

    
    
}
