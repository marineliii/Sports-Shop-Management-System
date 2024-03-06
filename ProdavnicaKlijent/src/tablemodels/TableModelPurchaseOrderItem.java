/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablemodels;

import controller.ControllerUI;
import domain.Article;
import domain.PurchaseOrder;
import domain.PurchaseOrderItem;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Veljko
 */
public class TableModelPurchaseOrderItem extends AbstractTableModel {
    
    private PurchaseOrder purchaseOrder;
    private List<Article> articles;
    private String[] columns = {"StavkaID","IznosStavke","CenaArtikla","PDV","Kolicina", "Artikal"};

    public TableModelPurchaseOrderItem(PurchaseOrder purchaseOrder) {
        this.purchaseOrder=purchaseOrder;
        try {
            this.articles=ControllerUI.getInstance().getAllArticles();
        } catch (Exception ex) {
            Logger.getLogger(TableModelPurchaseOrderItem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    public int getRowCount() {
        if(purchaseOrder.getPurchaseOrderItems()==null){
            return  0;
        }
        return purchaseOrder.getPurchaseOrderItems().size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PurchaseOrderItem purchaseOrderItem = purchaseOrder.getPurchaseOrderItems().get(rowIndex);
        switch (columnIndex) {
            case 0:
                return purchaseOrderItem.getItemID();
            case 1:
                return purchaseOrderItem.getItemPrice();
            case 2:
                return purchaseOrderItem.getArticalPrice();
            case 3:
                return purchaseOrderItem.getPdv();
            case 4:
                return purchaseOrderItem.getQuantity();
            case 5:
                for(Article article:articles){
                    if(article.getArticleID()==purchaseOrderItem.getArticleID()){
                        return article.getName();
                    }
                }
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    public void removeItem(int index) throws Exception {         
        purchaseOrder.getPurchaseOrderItems().remove(index);
        fireTableDataChanged();
    }
    
    public void deleteItem(int index) throws Exception {
        ControllerUI.getInstance().deletePurchaseOrderItem(purchaseOrder.getPurchaseOrderItems().get(index));
        purchaseOrder.getPurchaseOrderItems().remove(index);
        fireTableDataChanged();
    }
    
    public PurchaseOrderItem getItem(int row){
        return purchaseOrder.getPurchaseOrderItems().get(row);
    }

    public void addItem(Article article, double price, int quantity, double pdv) {
        PurchaseOrderItem item = new PurchaseOrderItem();
        item.setArticleID(article.getArticleID());
        item.setArticalPrice(price);
        item.setPdv(pdv);
        item.setQuantity(quantity);
        item.setItemPrice(price*quantity*(1+pdv/100.0));
        purchaseOrder.getPurchaseOrderItems().add(item);
        purchaseOrder.setTotalPrice(purchaseOrder.getTotalPrice()+item.getItemPrice());
        fireTableDataChanged();
    }

    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    
    
}
