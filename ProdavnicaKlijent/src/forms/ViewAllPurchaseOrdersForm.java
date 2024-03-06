/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forms;

import controller.ControllerUI;
import domain.Customer;
import domain.PurchaseOrder;
import domain.Worker;
import forms.util.FormViewMode;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import tablemodels.TableModelArticle;
import tablemodels.TableModelPurchaseOrder;

/**
 *
 * @author Veljko
 */
public class ViewAllPurchaseOrdersForm extends javax.swing.JFrame {

    private List<PurchaseOrder> purchaseOrders;
    private Worker currentWorker;
    private List<Worker> workers;

    /**
     * Creates new form ViewAllPurchaseOrdersForm
     */
    public ViewAllPurchaseOrdersForm(Worker currentWorker) {
        initComponents();
        try {
            this.purchaseOrders = ControllerUI.getInstance().getAllPurchaseOrders();
            this.workers = ControllerUI.getInstance().getAllWorkers();
            this.currentWorker = currentWorker;
        } catch (Exception ex) {
            Logger.getLogger(ViewAllPurchaseOrdersForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        populateForm();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        btnShowAll = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPurchaseOrders = new javax.swing.JTable();
        btnDetails = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        comboCustomer = new javax.swing.JComboBox<>();
        btnHelp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Porudzbenice");

        btnBack.setText("←");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel1.setText("Kupac:");

        btnSearch.setText("Pretrazi");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnShowAll.setText("Prikazi sve porudzbenice");
        btnShowAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowAllActionPerformed(evt);
            }
        });

        tblPurchaseOrders.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblPurchaseOrders);

        btnDetails.setText("Detalji");
        btnDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailsActionPerformed(evt);
            }
        });

        btnRemove.setText("Izbrisi");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        comboCustomer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnHelp.setText("Pomoc");
        btnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnShowAll)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(comboCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(158, 158, 158))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnHelp)
                                        .addGap(117, 117, 117)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnDetails)
                                    .addGap(42, 42, 42)
                                    .addComponent(btnRemove))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(26, 26, 26)
                                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch)
                    .addComponent(comboCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(btnShowAll)
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnRemove)
                    .addComponent(btnDetails)
                    .addComponent(btnHelp))
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailsActionPerformed
        try {
            int row = tblPurchaseOrders.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Sistem ne moze da uctia porudzbenicu: Nijedana porudzbenica nije izabrana", "Message", JOptionPane.ERROR_MESSAGE);
                return;
            }
            TableModelPurchaseOrder tmpo = (TableModelPurchaseOrder) tblPurchaseOrders.getModel();
            PurchaseOrder purchaseOrder = tmpo.getPurchaseOrder(row);
            PurchaseOrderForm povf = new PurchaseOrderForm(FormViewMode.VIEW_MODE, purchaseOrder, currentWorker);
            this.setVisible(false);
            this.dispose();
            povf.setVisible(true);
            JOptionPane.showMessageDialog(this, "Sistem je ucitao porudzbenicu");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da ucita porudzbenicu: " + ex.getMessage(), "Message", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnDetailsActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        try {
            int row = tblPurchaseOrders.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Nijedna porudzbenica nije izabrana");
                return;
            }
            if (currentWorker.getWorkerID() != purchaseOrders.get(row).getWorkerID()) {
                JOptionPane.showMessageDialog(this, "Niste ovlasceni da brisete ovu porudzbenicu!");
                return;
            }
            TableModelPurchaseOrder tmpo = (TableModelPurchaseOrder) tblPurchaseOrders.getModel();
            tmpo.deletePurchaseOrder(row);
            JOptionPane.showMessageDialog(this, "Sistem je obrisao porudzbenicu");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da obrise porudzbenicu: " + ex.getMessage(), "Message", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(ViewAllPurchaseOrdersForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnShowAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowAllActionPerformed
        tblPurchaseOrders.setModel(new TableModelPurchaseOrder(purchaseOrders));
    }//GEN-LAST:event_btnShowAllActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        Customer customer = (Customer) comboCustomer.getSelectedItem();
        List<PurchaseOrder> purchaseOrdersSearch = new ArrayList<>();
        try {
            purchaseOrdersSearch = ControllerUI.getInstance().getAllPurchaseOrdersByCustomer(customer);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da nadje porudzbenice po unetim vrednostima: " + ex.getMessage(), "Message", JOptionPane.ERROR_MESSAGE);
        }
        tblPurchaseOrders.setModel(new TableModelPurchaseOrder(purchaseOrdersSearch));
        JOptionPane.showMessageDialog(this, "Sistem je nasao porudzbenice po unetim vrednostima");
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpActionPerformed
        JOptionPane.showMessageDialog(this, "Ovo je forma za prikaz svih porudzbenica!\n"
                + "U tabeli su prikazane sve porudzbenice iz sistema. Moguce je filtrirati ih\n"
                + "po kupcima tako sto se izabere kupac iz opadajuceg menija i klikne na\n"
                + "dugme pretrazi. U tabeli ce se prikazati sve porudzbenice vezane za izabranog\n"
                + "kupca. Ukoliko izaberemo neku porudzbenicu i kliknemo na dugme detalji\n"
                + "otvorice se forma za prikaz porudzbenice, a ukoliko se klikne na dugme izbrisi\n"
                + "porudzbenica ce se izbrisati iz sistem. Porudzbenicu moze da izbrise samo radnik koji\n"
                + "ju je i kreirao, ostali nisu ovlasceni za to.");
    }//GEN-LAST:event_btnHelpActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDetails;
    private javax.swing.JButton btnHelp;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnShowAll;
    private javax.swing.JComboBox<String> comboCustomer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPurchaseOrders;
    // End of variables declaration//GEN-END:variables

    private void populateForm() {
        TableModelPurchaseOrder tmpo = new TableModelPurchaseOrder(purchaseOrders);
        tblPurchaseOrders.setModel(tmpo);
        for (Worker worker : workers) {
            for (int i = 0; i < tblPurchaseOrders.getRowCount(); i++) {
                if (worker.getWorkerID() == tmpo.getPurchaseOrder(i).getWorkerID() && worker.isDeleted()) {
                    tblPurchaseOrders.getComponentAt(1, i).setForeground(Color.red);
                }
            }
        }
        try {
            comboCustomer.setModel(new JComboBox(new DefaultComboBoxModel(ControllerUI.getInstance().getAllCustomers().toArray())).getModel());
        } catch (Exception ex) {
            Logger.getLogger(ViewAllPurchaseOrdersForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
