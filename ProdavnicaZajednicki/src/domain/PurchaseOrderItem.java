/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Veljko
 */
public class PurchaseOrderItem implements GenericEntity {
    private int itemID;
    private PurchaseOrder purchaseOrder;
    private double itemPrice;
    private double articalPrice;
    private double pdv;
    private int quantity;
    private int articleID;
    

    public PurchaseOrderItem() {
    }

    public PurchaseOrderItem(int itemID, PurchaseOrder purchaseOrder, double itemPrice, double articalPrice, double pdv, int quantity, int articleID) {
        this.itemID = itemID;
        this.purchaseOrder = purchaseOrder;
        this.itemPrice = itemPrice;
        this.articalPrice = articalPrice;
        this.pdv = pdv;
        this.quantity = quantity;
        this.articleID = articleID;
    }

    

    
    
    

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public double getArticalPrice() {
        return articalPrice;
    }

    public void setArticalPrice(double articalPrice) {
        this.articalPrice = articalPrice;
    }

    public double getPdv() {
        return pdv;
    }

    public void setPdv(double pdv) {
        this.pdv = pdv;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public int getArticleID() {
        return articleID;
    }

    public void setArticleID(int articleID) {
        this.articleID = articleID;
    }

   
    
    @Override
    public String getTableName() {
        return "stavkaporudzbenice";
    }

    @Override
    public String getInsertColumns() {
        return "porudzbenicaID, iznosStavke, cenaArtikla, pdv, kolicina, artikalID_fk";
    }

    @Override
    public String getInsertValues() {
        return purchaseOrder.getPurchaseOrderID()+","+itemPrice+","+articalPrice+","+pdv+","+quantity+","+articleID;
    }

    @Override
    public void setId(int id) {
        this.itemID=id;
    }

    @Override
    public String getUpdateQuery() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getWhereQuery() {
        return "stavkaID="+itemID;
    }

    @Override
    public List<GenericEntity> getAllObjects(ResultSet rs) {
        List<GenericEntity> purchaseOrderItems = new ArrayList<>();
        try {
            while(rs.next()){
                int itemID = rs.getInt("stavkaID");
                int purchaseOrderID = rs.getInt("porudzbenicaID");
                double itemPrice = rs.getInt("iznosStavke");
                double articlePrice = rs.getInt("cenaArtikla");
                double pdv = rs.getInt("pdv");
                int quantity = rs.getInt("kolicina");
                int articleID = rs.getInt("artikalID_fk");

                PurchaseOrder purchaseOrder = new PurchaseOrder();
                purchaseOrder.setPurchaseOrderID(purchaseOrderID);
                PurchaseOrderItem purchaseOrderItem = new PurchaseOrderItem(itemID, purchaseOrder, itemPrice, articlePrice, pdv, quantity, articleID);
                purchaseOrderItems.add(purchaseOrderItem);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseOrderItem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return purchaseOrderItems;
    }

    @Override
    public String getWhereQueryWithFilter(Object filter) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getWhereQueryWithObject(Object object) {
        return "porudzbenicaID="+((PurchaseOrder)object).getPurchaseOrderID();
    }

    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    

   

    
    
}
