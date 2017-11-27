/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui.network.nonprofitOrganizationEnterprise.adminDepartment;

import ui.network.advertisementEnterprise.adminOrganization.*;
import biz.account.Account;
import biz.enterprises.Enterprise;
import biz.enterprises.NPOEnterprise;
import biz.org.Organization;
import javax.swing.JTable;
import ui.components.HasTitle;
import ui.components.ParentUI;
import ui.components.TablePopulatable;

/**
 *
 * @author royn
 */
public class NPOManageOrganizations extends javax.swing.JPanel implements TablePopulatable<Organization>,HasTitle{
    private ParentUI parentUI;
    private Account account;
    private NPOEnterprise enterprise;
    public NPOManageOrganizations(ParentUI parent, Account account) {
         initComponents();
         this.parentUI = parent;
         this.account = account;
         this.enterprise = (NPOEnterprise)account.getOrg().getEnterprise();
         populateTable();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrg = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        tblOrg.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "                                 Organization"
            }
        ));
        jScrollPane1.setViewportView(tblOrg);

        jButton1.setText("Add Producer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Organizations:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(jButton1)))
                .addGap(0, 258, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(263, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(271, 271, 271))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        parentUI.pushComponent(new NPOCreateProducer(parentUI, enterprise));
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblOrg;
    // End of variables declaration//GEN-END:variables

    @Override
    public JTable getTable() {
        return tblOrg;
    }

    @Override
    public Object[] populateRow(Organization element) {
        return new Object[]{};
    }

    @Override
    public String getTitle() {
        return "Manage Advertisement Organizations";
    }

    @Override
    public void populateTable() {
        populateTable();
    }

}