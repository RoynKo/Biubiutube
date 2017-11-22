/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.network.advertisementEnterprise.adminOrganization;

import biz.account.Account;
import ui.components.ParentUI;
import ui.network.extraCurricularOrganizationEnterprise.adminOrganization.*;

/**
 *
 * @author royn
 */
public class ADWorkArea extends javax.swing.JPanel {
    private ParentUI parentUI;
    private Account account;
    /**
     * Creates new form NewJPanel
     */
    public ADWorkArea(ParentUI parentUI,Account account) {
        initComponents();
        this.parentUI = parentUI;
        this.account = account;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAccount = new javax.swing.JButton();
        btnOrganization = new javax.swing.JButton();

        btnAccount.setText("Manage Accounts");
        btnAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccountActionPerformed(evt);
            }
        });

        btnOrganization.setText("Manage Organization");
        btnOrganization.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrganizationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(411, 411, 411)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnOrganization, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(408, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(btnAccount)
                .addGap(31, 31, 31)
                .addComponent(btnOrganization)
                .addContainerGap(385, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccountActionPerformed
        parentUI.pushComponent(new ADManageAccounts());
    }//GEN-LAST:event_btnAccountActionPerformed

    private void btnOrganizationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrganizationActionPerformed
        parentUI.pushComponent(new ADManageOrganizations(parentUI, account));
    }//GEN-LAST:event_btnOrganizationActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccount;
    private javax.swing.JButton btnOrganization;
    // End of variables declaration//GEN-END:variables
}
