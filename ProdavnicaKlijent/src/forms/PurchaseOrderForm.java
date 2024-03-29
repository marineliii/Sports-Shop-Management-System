/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forms;

import controller.ControllerUI;
import domain.Article;
import domain.Customer;
import domain.PurchaseOrder;
import domain.PurchaseOrderItem;
import domain.Worker;
import forms.util.FormViewMode;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import tablemodels.TableModelPurchaseOrder;
import tablemodels.TableModelPurchaseOrderItem;
import forms.validator.Validator;
import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author Veljko
 */
public class PurchaseOrderForm extends javax.swing.JFrame {

    private List<Customer> customers;
    private Worker currentWorker;
    private List<Worker> workers;
    private PurchaseOrder chosenPurchaseOrder;
    private String error;
    private List<Article> articles;
    
    
    /**
     * Creates new form PurchaseOrderForm
     */
    public PurchaseOrderForm(int formMode, Worker currentWorker) {
        initComponents();
        try {
            this.customers=ControllerUI.getInstance().getAllCustomers();
            this.workers=ControllerUI.getInstance().getAllWorkers();
            this.currentWorker=currentWorker;
            this.articles=ControllerUI.getInstance().getAllArticles();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Nisu ucitane liste kupaca i radnika", "Message", JOptionPane.ERROR_MESSAGE);
        }
        lblWorker.setText(currentWorker.getFirstname()+" "+currentWorker.getLastname());
        populateForm();
        prepareView(formMode);
        setLocationRelativeTo(null);
        error="";
    }
    
    public PurchaseOrderForm(int formMode, PurchaseOrder purchaseOrder, Worker currentWorker) {
        chosenPurchaseOrder=purchaseOrder;
        initComponents();
        try {
            this.customers=ControllerUI.getInstance().getAllCustomers();
            this.workers=ControllerUI.getInstance().getAllWorkers();
            this.currentWorker=currentWorker;
            this.articles=ControllerUI.getInstance().getAllArticles();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Nisu ucitane liste kupaca i radnika", "Message", JOptionPane.ERROR_MESSAGE);
        }
        populateForm();
        prepareView(formMode);
        setPurchaseOrder();
        setLocationRelativeTo(null);
        error="";
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        comboCustomers = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblItem = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnChange = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnRemoveItem = new javax.swing.JButton();
        dateFrom = new com.toedter.calendar.JDateChooser();
        dateTo = new com.toedter.calendar.JDateChooser();
        txtTotalPrice = new javax.swing.JTextField();
        btnHelp = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblWorker = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        comboArticle = new javax.swing.JComboBox<>();
        txtQuantity = new javax.swing.JTextField();
        txtPdv = new javax.swing.JTextField();
        txtArticlePrice = new javax.swing.JTextField();
        btnAddItem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Porudzbenica");

        jLabel1.setText("Kupac:");

        comboCustomers.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Datum od:");

        jLabel4.setText("Datum do:");

        jLabel7.setText("Ukupna cena:");

        tblItem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblItem);

        btnBack.setText("←");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnUpdate.setText("Azuriraj");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnChange.setText("Izmeni");
        btnChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeActionPerformed(evt);
            }
        });

        btnDelete.setText("Izbrisi");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnRemoveItem.setText("Obrisi stavku");
        btnRemoveItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveItemActionPerformed(evt);
            }
        });

        dateFrom.setDateFormatString("dd/MM/yyyy");

        dateTo.setDateFormatString("dd/MM/yyyy");

        txtTotalPrice.setEditable(false);

        btnHelp.setText("Pomoc");
        btnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpActionPerformed(evt);
            }
        });

        jLabel2.setText("Radnik:");

        lblWorker.setText("jLabel5");

        btnSave.setText("Sacuvaj");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Stavka"));

        jLabel5.setText("Artikal:");

        jLabel6.setText("Kolicina:");

        jLabel8.setText("PDV:");

        jLabel9.setText("Iznos artikla:");

        comboArticle.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboArticle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboArticleActionPerformed(evt);
            }
        });

        txtPdv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPdvActionPerformed(evt);
            }
        });

        txtArticlePrice.setEditable(false);

        btnAddItem.setText("Dodaj stavku");
        btnAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(txtArticlePrice, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPdv, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboArticle, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboArticle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtPdv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtArticlePrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(btnAddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnHelp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSave)
                                .addGap(53, 53, 53)
                                .addComponent(btnDelete))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnChange)))
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRemoveItem, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(440, 440, 440)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblWorker, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(42, 42, 42)
                                .addComponent(txtTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(comboCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(78, 78, 78)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dateTo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(dateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))))
                        .addGap(538, 538, 538))))
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 891, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(comboCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)))
                            .addComponent(dateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblWorker)
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(txtTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(dateTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(btnRemoveItem, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(btnSave))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnBack)
                    .addComponent(btnChange)
                    .addComponent(btnHelp))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddItemActionPerformed
        error="";
        if(!checkFiledsItem()){
            JOptionPane.showMessageDialog(this, error, "Message", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Article article = (Article)comboArticle.getSelectedItem();
        double price = Double.parseDouble(txtArticlePrice.getText());
        int quantity = Integer.parseInt(txtQuantity.getText());
        double pdv = Double.parseDouble(txtPdv.getText());
        TableModelPurchaseOrderItem tmpoi = (TableModelPurchaseOrderItem) tblItem.getModel();
        tmpoi.addItem(article, price, quantity, pdv);
        double totalPrice=0;
        
        for(int i=0;i<tblItem.getRowCount();i++){
        totalPrice+=((TableModelPurchaseOrderItem)tblItem.getModel()).getItem(i).getItemPrice();
        }
        txtTotalPrice.setText(String.valueOf(totalPrice));
        
    }//GEN-LAST:event_btnAddItemActionPerformed

    private void btnChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeActionPerformed
        if(chosenPurchaseOrder.getWorkerID()!=currentWorker.getWorkerID()){
            JOptionPane.showMessageDialog(this, "Vi niste ovlasceni da menjate ovu porudzbenicu!");
            return;
        }
        prepareView(FormViewMode.EDIT_MODE);
    }//GEN-LAST:event_btnChangeActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
        error="";
        if(!checkFields()){
        JOptionPane.showMessageDialog(this, error, "Message", JOptionPane.ERROR_MESSAGE);
        return;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        PurchaseOrder purchaseOrder = ((TableModelPurchaseOrderItem)tblItem.getModel()).getPurchaseOrder();
        purchaseOrder.setPurchaseOrderID(chosenPurchaseOrder.getPurchaseOrderID());
        purchaseOrder.setDateFrom(LocalDate.parse(sdf.format(dateFrom.getDate())));
        purchaseOrder.setDateTo(LocalDate.parse(sdf.format(dateTo.getDate())));
        purchaseOrder.setTotalPrice(Double.parseDouble(txtTotalPrice.getText()));
        PurchaseOrder returnPurchaseOrder = ControllerUI.getInstance().updatePurchaseOrder(purchaseOrder);
        JOptionPane.showMessageDialog(this, "Sistem je zapamtio porudzbenicu");
        this.dispose();
        } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti porudzbenicu: " + ex.getMessage(), "Message", JOptionPane.ERROR_MESSAGE);
        }
        

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnRemoveItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveItemActionPerformed
        try {
            int row = tblItem.getSelectedRow();
            if(row==-1){
                JOptionPane.showMessageDialog(this, "Nijedna stavka nije izabrana");
                return;
            }
            TableModelPurchaseOrderItem tmpoi = (TableModelPurchaseOrderItem) tblItem.getModel();
            
            if(btnUpdate.isEnabled()){
                tmpoi.deleteItem(row);
            }else{
                tmpoi.removeItem(row);
            }
            TableModelPurchaseOrderItem tableModel = (TableModelPurchaseOrderItem) tblItem.getModel();
            double totalPrice=0;
            if(tblItem.getRowCount()==0){
                txtTotalPrice.setText("0");
            }else{
                for(int i=0;i<tblItem.getRowCount();i++){
                    totalPrice+=tableModel.getItem(i).getItemPrice();
            }
            txtTotalPrice.setText(String.valueOf(totalPrice));
            chosenPurchaseOrder.setTotalPrice(totalPrice);
        }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da obrise stavku: " +ex.getMessage(), "Message", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRemoveItemActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if(chosenPurchaseOrder.getWorkerID()!=currentWorker.getWorkerID()){
            JOptionPane.showMessageDialog(this, "Vi niste ovlasceni da brisete ovu porudzbenicu!");
            return;
        }
        try {
            PurchaseOrder purchaseOrder = chosenPurchaseOrder;
            PurchaseOrder returnPurchaseOrder = ControllerUI.getInstance().deletePurchaseOrder(purchaseOrder);
            JOptionPane.showMessageDialog(this, "Sistem je obrisao porudzbenicu");
            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da obrise porudzbenicu: " + ex.getMessage(), "Message", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpActionPerformed
        JOptionPane.showMessageDialog(this, "Ovo je forma za prikaz i izmenu porudzbenice\n"
                + "Na formi su prikazani podaci porudzbenice u odgovarajuca polja, kao i njene\n"
                + "stavke u tabeli ispod polja. Na dugme izmeni se omogucava izmena podataka i \n"
                + "dodavanje i brisanje stavki. Kupac se bira iz opadajuceg menija, datumi se menjaju\n"
                + "preko klika na desni deo polja gde ce se otvoriti kalendar i na njemu se mogu izabrati\n"
                + "zeljeni datumi, pri uslovu da moraju biti u buducnosti i da datum do ne sme biti pre\n"
                + "datuma od. U polje ukupna cena se automatski upisuje vrednost porudzbenice nakon dodavanja\n"
                + "ili brisanja stavki. Na dugme obrisi stavku se nakon klika na zeljenu stavku u tabeli ta\n"
                + "stavka brise, dok se na dugme dodaj stavku otvara forma za dodavanje stavke. Na dugme\n"
                + "azuriraj se porudzbenica pamti u sistemu. Na dugme obrisi se porudzbenica brise iz sistema\n"
                + "Samo kreator porudzebnice predstavlja lice koje ima ovlascenje da je menja ili brise, ostali\n"
                + " mogu samo da je pregledaju.\n");
    }//GEN-LAST:event_btnHelpActionPerformed

    private void txtPdvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPdvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPdvActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            error="";
            if(!checkFields()){
                JOptionPane.showMessageDialog(this, error, "Messege", JOptionPane.ERROR_MESSAGE);
                return;
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            
            PurchaseOrder purchaseOrder = ((TableModelPurchaseOrderItem)tblItem.getModel()).getPurchaseOrder();
            purchaseOrder.setCustomerID(((Customer)comboCustomers.getSelectedItem()).getCustomerID());
            purchaseOrder.setWorkerID(currentWorker.getWorkerID());
            purchaseOrder.setDateFrom(LocalDate.parse(sdf.format(dateFrom.getDate())));
            purchaseOrder.setDateTo(LocalDate.parse(sdf.format(dateTo.getDate())));
            PurchaseOrder returnPurchaseOrder = ControllerUI.getInstance().savePurchaseOrder(purchaseOrder);
            JOptionPane.showMessageDialog(this, "Sistem je zapamtio porudzbenicu");   
            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti porudzbenicu: " + ex.getMessage(), "Message", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnSaveActionPerformed

    private void comboArticleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboArticleActionPerformed
        if(!(comboArticle.getSelectedItem()==null)){
            txtArticlePrice.setText(String.valueOf(((Article)comboArticle.getSelectedItem()).getPrice()));
        }else{
            txtArticlePrice.setText("0");
        }
    }//GEN-LAST:event_comboArticleActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddItem;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnChange;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnHelp;
    private javax.swing.JButton btnRemoveItem;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> comboArticle;
    private javax.swing.JComboBox<String> comboCustomers;
    private com.toedter.calendar.JDateChooser dateFrom;
    private com.toedter.calendar.JDateChooser dateTo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblWorker;
    private javax.swing.JTable tblItem;
    private javax.swing.JTextField txtArticlePrice;
    private javax.swing.JTextField txtPdv;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtTotalPrice;
    // End of variables declaration//GEN-END:variables

    private void populateForm() {
        TableModelPurchaseOrderItem tmpoi = new TableModelPurchaseOrderItem(new PurchaseOrder());
        tblItem.setModel(tmpoi);
        JComboBox comboBoxCustomer = new JComboBox(new DefaultComboBoxModel(customers.toArray()));
        comboCustomers.setModel(comboBoxCustomer.getModel());
        JComboBox comboBoxArticle = new JComboBox(new DefaultComboBoxModel(articles.toArray()));
        comboArticle.setModel(comboBoxArticle.getModel());
        comboArticle.setSelectedIndex(-1);
        
        TableModelPurchaseOrderItem tableModel = (TableModelPurchaseOrderItem) tblItem.getModel();
        DecimalFormat df = new DecimalFormat("0.00");
        double totalPrice=0;
        if(tblItem.getRowCount()==0){
            txtTotalPrice.setText("0");
        }else{
            for(int i=0;i<tblItem.getRowCount();i++){
                totalPrice+=tableModel.getItem(i).getItemPrice();
            }
            txtTotalPrice.setText(String.valueOf(df.format(totalPrice)));
        }
        LocalDate ld = LocalDate.now();
        dateFrom.setDate(Date.from(ld.atStartOfDay(ZoneId.systemDefault()).toInstant()));
    }
    
    private void prepareView(int formMode) {
        switch (formMode) {
            case FormViewMode.VIEW_MODE:
                btnChange.setEnabled(true);
                btnUpdate.setEnabled(false);
                btnDelete.setEnabled(true);
                dateFrom.setEnabled(false);
                dateTo.setEnabled(false);
                btnAddItem.setEnabled(false);
                btnRemoveItem.setEnabled(false);
                comboCustomers.setEnabled(false);
                jLabel1.setEnabled(false);
                txtPdv.setEditable(false);
                txtQuantity.setEditable(false);
                btnSave.setEnabled(false);
                break;
            case FormViewMode.EDIT_MODE:
                btnChange.setEnabled(false);
                btnUpdate.setEnabled(true);
                btnDelete.setEnabled(false);
                dateFrom.setEnabled(false);
                dateTo.setEnabled(true);
                btnAddItem.setEnabled(true);
                btnRemoveItem.setEnabled(true);
                comboCustomers.setEnabled(false);
                jPanel1.setEnabled(true);
                txtPdv.setEditable(true);
                txtQuantity.setEditable(true);
                btnSave.setEnabled(false);
                break;
            case FormViewMode.ADD_MODE:
                btnChange.setEnabled(false);
                btnUpdate.setEnabled(false);
                btnDelete.setEnabled(false);
                dateFrom.setEnabled(false);
                dateTo.setEnabled(true);
                btnAddItem.setEnabled(true);
                btnRemoveItem.setEnabled(true);
                comboCustomers.setEnabled(true);
                jPanel1.setEnabled(true);
                txtPdv.setEditable(true);
                txtQuantity.setEditable(true);
                btnSave.setEnabled(true);
                break;
            default:
                throw new AssertionError();
        }
    }

    private boolean checkFields() {
        boolean signal=true;
        if(Validator.getInstance().isNull(comboCustomers.getSelectedItem())
                || Validator.getInstance().isNull(dateFrom.getDate())
                || Validator.getInstance().isNull(dateTo.getDate())){
            error+="Nisu popunjena sva polja\n";
            signal= false;
        }  else{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
            if(Validator.getInstance().isDateInFuture(LocalDate.parse(sdf.format(dateTo.getDate())))){
                error+="Datum do nije u buducnosti\n";
                signal= false;
            }
        
            if(Validator.getInstance().isDateInOrder(LocalDate.parse(sdf.format(dateFrom.getDate())), LocalDate.parse(sdf.format(dateTo.getDate())))){
                error+="Datum do roka porudzbenice je kasniji nego datum od kreiranja porudzbenice\n";
                signal= false;
            }
        }      
        
        
        
        return signal;
      
    }

    private void setPurchaseOrder() {
        dateFrom.setDate(Date.from(chosenPurchaseOrder.getDateFrom().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        dateTo.setDate(Date.from(chosenPurchaseOrder.getDateTo().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        for(Customer customer:customers){
            if(customer.getCustomerID()==chosenPurchaseOrder.getCustomerID()){
                comboCustomers.setSelectedItem(customer);
            }
        }
        try {
            List<PurchaseOrderItem> items = ControllerUI.getInstance().getAllItemsByPurchaseOrder(chosenPurchaseOrder);
            List<PurchaseOrderItem> newItems = new ArrayList<>();
            for (PurchaseOrderItem item : items) {
                if(item.getPurchaseOrder().getPurchaseOrderID()==chosenPurchaseOrder.getPurchaseOrderID()){
                    newItems.add(item);
                }
            }
            chosenPurchaseOrder.setPurchaseOrderItems(newItems);
        } catch (Exception ex) {
            Logger.getLogger(PurchaseOrderForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (Worker worker : workers) {
            if(worker.getWorkerID()==chosenPurchaseOrder.getWorkerID()){
                lblWorker.setText(worker.getFirstname()+" "+worker.getLastname());
                if(worker.isDeleted()){
                    lblWorker.setForeground(Color.red);
                }
            }
        }
        txtTotalPrice.setText(String.valueOf(chosenPurchaseOrder.getTotalPrice()));
        tblItem.setModel(new TableModelPurchaseOrderItem(chosenPurchaseOrder));
        
    }

    private boolean checkFiledsItem() {
        boolean signal = true;
        if(Validator.getInstance().isEmpty(txtPdv.getText()) || Validator.getInstance().isEmpty(txtQuantity.getText())
                || comboArticle.getSelectedItem().equals(null)){
            error+="Nisu popunjena sva polja\n";
            signal= false;
        }
        
        if(Validator.getInstance().isDouble(txtPdv.getText())){
        error+="Nije unete numericka vrednost za pdv\n";
        signal= false;
        }else if(Validator.getInstance().isLowerThanZero(Double.parseDouble(txtPdv.getText()))){
        error+="Pdv mora biti vece od 0\n";
        signal= false;
        }
        
        if(Validator.getInstance().isInteger(txtQuantity.getText())){
            error+="Nije unete celoborjna vrednost za kolicinu\n";
            signal= false;
        }else if(Validator.getInstance().isLowerThanZero(Integer.parseInt(txtQuantity.getText()))){
                error+="Kolicina mora biti veca od 0\n";
                signal= false;
        }
        

        return signal;
    }
}
