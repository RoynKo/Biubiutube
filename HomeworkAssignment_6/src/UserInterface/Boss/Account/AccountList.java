/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Boss.Account;

import UserInterface.Components.HasTitle;
import UserInterface.Components.ParentUI;
import UserInterface.Components.TablePopulatable;
import biz.Components.Account;
import biz.Components.Boss;
import biz.Components.Business;
import biz.Components.SalesPerson;
import biz.Components.Supplier;
import javax.swing.JTable;

/**
 *
 * @author hezj
 */
public class AccountList extends javax.swing.JPanel implements HasTitle, TablePopulatable<Account> {
    private ParentUI parent;
    
    /**
     * Creates new form AccountList
     */
    public AccountList(ParentUI parent) {
        initComponents();
        this.parent = parent;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblAccount = new javax.swing.JTable();
        btnUpdate = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();

        tblAccount.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Username", "Role"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblAccount);

        btnUpdate.setText("Update Selected");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        removeButton.setText("Remove Selected");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUpdate)
                    .addComponent(removeButton))
                .addContainerGap(279, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        Account selected = getSelected();
        if (selected == null) {
            return;
        }
        AccountUpdate jp = new AccountUpdate(selected);
        parent.pushComponent(jp);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        removeSelected(Business.getInstance().getAccountCatalog());
    }//GEN-LAST:event_removeButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUpdate;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton removeButton;
    private javax.swing.JTable tblAccount;
    // End of variables declaration//GEN-END:variables

    @Override
    public String getTitle() {
        return "Account List";
    }

    @Override
    public JTable getTable() {
        return tblAccount;
    }

    @Override
    public Object[] populateRow(Account element) {
        String role;
        if (element instanceof Boss) {
            role = "Boss";
        } else if (element instanceof Supplier) {
            role = "Supplier";
        } else if (element instanceof SalesPerson) {
            role = "SalesPerson";
        } else {
            role = "Unknown Role";
        }
        return new Object[] {element, role};
    }

    @Override
    public void populateTable() {
        populateTable(Business.getInstance().getAccountCatalog().getElementArrayList());
    }
}