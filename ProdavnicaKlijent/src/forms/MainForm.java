/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forms;

import communication.Communication;
import controller.ControllerUI;
import domain.Worker;
import forms.util.FormViewMode;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Veljko
 */
public class MainForm extends javax.swing.JFrame {
    
    private Worker currentWorker;

    /**
     * Creates new form MainForm
     */
    public MainForm(Worker worker) {
        initComponents();
        this.currentWorker=worker;
        lblUser.setText(currentWorker.getUsername());
        setExtendedState(JFrame.MAXIMIZED_BOTH);
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
        lblUser = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        meniNewCustomer = new javax.swing.JMenuItem();
        meniViewCustomers = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        meniNewArticle = new javax.swing.JMenuItem();
        meniViewArticles = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        meniNewOrder = new javax.swing.JMenuItem();
        meniViewOrders = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        meniNewRecommendation = new javax.swing.JMenuItem();
        meniViewAllRecommendation = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        meniHelp = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("Ulogovani korisnik:");

        lblUser.setText("jLabel2");

        btnLogout.setText("Odjava");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photo/Klijent_logo.jpg"))); // NOI18N

        jMenu1.setText("Kupac");

        meniNewCustomer.setText("Novi kupac");
        meniNewCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meniNewCustomerActionPerformed(evt);
            }
        });
        jMenu1.add(meniNewCustomer);

        meniViewCustomers.setText("Prikazi kupce");
        meniViewCustomers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meniViewCustomersActionPerformed(evt);
            }
        });
        jMenu1.add(meniViewCustomers);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Artikal");

        meniNewArticle.setText("Novi artikal");
        meniNewArticle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meniNewArticleActionPerformed(evt);
            }
        });
        jMenu2.add(meniNewArticle);

        meniViewArticles.setText("Prikazi artkle");
        meniViewArticles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meniViewArticlesActionPerformed(evt);
            }
        });
        jMenu2.add(meniViewArticles);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Porudzbenica");

        meniNewOrder.setText("Nova porudzbenica");
        meniNewOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meniNewOrderActionPerformed(evt);
            }
        });
        jMenu3.add(meniNewOrder);

        meniViewOrders.setText("Prikazi porudzbenice");
        meniViewOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meniViewOrdersActionPerformed(evt);
            }
        });
        jMenu3.add(meniViewOrders);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Preporuka");

        meniNewRecommendation.setText("Nova preporuka");
        meniNewRecommendation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meniNewRecommendationActionPerformed(evt);
            }
        });
        jMenu4.add(meniNewRecommendation);

        meniViewAllRecommendation.setText("Prikazi preporuke");
        meniViewAllRecommendation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meniViewAllRecommendationActionPerformed(evt);
            }
        });
        jMenu4.add(meniViewAllRecommendation);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Pomoc");

        meniHelp.setText("Pomoc");
        meniHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meniHelpActionPerformed(evt);
            }
        });
        jMenu5.add(meniHelp);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 452, Short.MAX_VALUE)
                .addComponent(btnLogout)
                .addGap(35, 35, 35))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblUser)
                    .addComponent(btnLogout))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void meniNewCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meniNewCustomerActionPerformed
        new CustomerForm(FormViewMode.ADD_MODE).setVisible(true);
    }//GEN-LAST:event_meniNewCustomerActionPerformed

    private void meniViewCustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meniViewCustomersActionPerformed
        new ViewAllCustomersForm().setVisible(true);
    }//GEN-LAST:event_meniViewCustomersActionPerformed

    private void meniViewOrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meniViewOrdersActionPerformed
        new ViewAllPurchaseOrdersForm(currentWorker).setVisible(true);
    }//GEN-LAST:event_meniViewOrdersActionPerformed

    private void meniNewOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meniNewOrderActionPerformed
        new PurchaseOrderForm(FormViewMode.ADD_MODE, currentWorker).setVisible(true);
    }//GEN-LAST:event_meniNewOrderActionPerformed

    private void meniNewArticleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meniNewArticleActionPerformed
        new ArticleForm(FormViewMode.ADD_MODE).setVisible(true);
    }//GEN-LAST:event_meniNewArticleActionPerformed

    private void meniViewArticlesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meniViewArticlesActionPerformed
        new ViewAllArticlesForm().setVisible(true);
    }//GEN-LAST:event_meniViewArticlesActionPerformed

    private void meniNewRecommendationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meniNewRecommendationActionPerformed
        new RecommendationForm(FormViewMode.ADD_MODE, currentWorker).setVisible(true);
    }//GEN-LAST:event_meniNewRecommendationActionPerformed

    private void meniViewAllRecommendationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meniViewAllRecommendationActionPerformed
        new ViewAllRecommendationsForm(currentWorker).setVisible(true);
    }//GEN-LAST:event_meniViewAllRecommendationActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        Worker worker = null;
        try {
            worker=ControllerUI.getInstance().logout(currentWorker);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Nije moguce odjaviti se");
        }
        if(worker!=null){
            int result = JOptionPane.showConfirmDialog(this, "Da li ste sigurni da zelite da se odjavite?");
            if(result==JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(this, "Dovidjenja, "+currentWorker.getFirstname());
                try {
                    Communication.getInstance().getSocket().close();
                } catch (IOException ex) {
                    Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.dispose();
                System.exit(0);
            }            
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void meniHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meniHelpActionPerformed
        JOptionPane.showMessageDialog(this, "Ovo je glavna forma aplikacije!\n"
                + "U meniju aplikacije se nalaze opcije za artikle, kupce, porudzebenice i preporuke.\n"
                + "Izborom bilo koje od ovih stavka menija omogucava se ili ubacivanje novog objekta ili prikaz\n"
                + "svih objekata zeljene stavke. Na dugme odjava se korisnik odjavljuje sa aplikacije i gasi program.");
    }//GEN-LAST:event_meniHelpActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        try {
            ControllerUI.getInstance().logout(currentWorker);
        } catch (Exception ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblUser;
    private javax.swing.JMenuItem meniHelp;
    private javax.swing.JMenuItem meniNewArticle;
    private javax.swing.JMenuItem meniNewCustomer;
    private javax.swing.JMenuItem meniNewOrder;
    private javax.swing.JMenuItem meniNewRecommendation;
    private javax.swing.JMenuItem meniViewAllRecommendation;
    private javax.swing.JMenuItem meniViewArticles;
    private javax.swing.JMenuItem meniViewCustomers;
    private javax.swing.JMenuItem meniViewOrders;
    // End of variables declaration//GEN-END:variables
}
