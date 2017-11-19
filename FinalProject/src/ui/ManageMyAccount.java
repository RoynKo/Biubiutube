/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import biz.EcoSystem;
import biz.account.Account;
import biz.org.Organization;
import biz.person.Person;

import javax.swing.JTable;

import ui.components.HasTitle;
import ui.components.ParentUI;
import ui.components.TablePopulatable;

import java.util.stream.Stream;

/**
 * @author hezj
 */
public class ManageMyAccount extends javax.swing.JPanel implements HasTitle, TablePopulatable<Account> {
    private ParentUI parent;
    private Account account;

    /**
     * Creates new form ManageAccount
     */
    public ManageMyAccount(ParentUI parent, Account account) {
        this.parent = parent;
        this.account = account;
        initComponents();
        populateTable();
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
        tbl = new javax.swing.JTable();
        btnChange = new javax.swing.JButton();

        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Username", "Password", "Role"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl);

        btnChange.setText("Change Selected Account's Password");
        btnChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnChange))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnChange)
                .addContainerGap(265, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeActionPerformed
        Account selected = getSelected();
        if (selected == null) {
            return;
        }
        parent.pushComponent(new ChangeMyPassword(selected));
    }//GEN-LAST:event_btnChangeActionPerformed

    @Override
    public String getTitle() {
        return String.format("%s's Accounts", account.getPerson());
    }

    @Override
    public JTable getTable() {
        return tbl;
    }

    @Override
    public Object[] populateRow(Account account) {
        return new Object[]{
                account,
                "********",
                account.getRole()
        };
    }

    @Override
    public void populateTable() {
        Person p = account.getPerson();
        Organization org = account.getOrg();
        Stream<Account> s;
        if (org == null) {
            s = EcoSystem.getInstance().getSystemAccountCatalog().getAccountArrayList().stream();
        } else {
            s = account.getOrg().getAccountCatalog().getAccountArrayList().stream();
        }
        populateTable(s.filter(acc -> acc.getPerson().equals(p)));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChange;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl;
    // End of variables declaration//GEN-END:variables
}
