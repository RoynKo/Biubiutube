/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Boss.Order;

import UserInterface.Components.HasTitle;
import UserInterface.Components.ParentUI;
import UserInterface.Components.TablePopulatable;
import biz.Components.Business;
import biz.Components.Order;
import javax.swing.JTable;

/**
 *
 * @author royn
 */
public class ManageOrderJPanel extends javax.swing.JPanel implements HasTitle, TablePopulatable<Order> {
    private ParentUI parent;
    
    /**
     * Creates new form ManageOrderJPanel
     */
    public ManageOrderJPanel(ParentUI parent) {
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
        tblOrder = new javax.swing.JTable();
        btnView = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnView1 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Bought By", "Sold By", "Total Price", "Total Revenue"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblOrder);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 740, -1));

        btnView.setText("View");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });
        add(btnView, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 70, 180, 40));

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 20, 180, 40));

        btnView1.setText("<<Export");
        btnView1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnView1ActionPerformed(evt);
            }
        });
        add(btnView1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 120, 180, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        Order order = getSelected();
        if (order == null) {
            return;
        }
        parent.pushComponent(new OrderDetailJPanel(parent, order));
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnView1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnView1ActionPerformed
        // TODO add your handling code here:
        toCSV();
    }//GEN-LAST:event_btnView1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnView;
    private javax.swing.JButton btnView1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblOrder;
    // End of variables declaration//GEN-END:variables

    @Override
    public String getTitle() {
        return "Manage All Orders";
    }

    @Override
    public JTable getTable() {
        return tblOrder;
    }

    @Override
    public Object[] populateRow(Order order) {
        return new Object[] {
            order,
            order.getBoughtBy(),
            order.getSoldBy(),
            order.totalPrice(),
            order.getRevenue()
        };
    }

    @Override
    public void populateTable() {
        populateTable(Business.getInstance().getOrderDirectory().getElementArrayList());
    }
}
