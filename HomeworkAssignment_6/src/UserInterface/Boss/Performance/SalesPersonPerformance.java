/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Boss.Performance;

import UserInterface.Components.HasTitle;
import UserInterface.Components.ParentUI;
import UserInterface.Components.TablePopulatable;
import biz.Components.Business;
import biz.Components.Order;
import biz.Components.OrderDirectory;
import java.util.Comparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author royn
 */
public class SalesPersonPerformance extends javax.swing.JPanel implements TablePopulatable<Order>, HasTitle {

    /**
     * Creates new form SalesPersonPerformance
     */
    private OrderDirectory orderDirectory;
    public SalesPersonPerformance() {
        initComponents();
        this.orderDirectory = Business.getInstance().getOrderDirectory();
//         populateTable();
        
    }
    public void ppt(OrderDirectory od){
        DefaultTableModel dtm = (DefaultTableModel)revenueT.getModel();
        dtm.setRowCount(0);
        for(Order o : od.getElementArrayList()){
            Object row[]= new Object[2];
            row[0] = o.getSoldBy();
            row[1] = o.getRevenue();
        }
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
        revenueT = new javax.swing.JTable();
        btnAbove = new javax.swing.JButton();
        btnBelow = new javax.swing.JButton();
        btnView1 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        revenueT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sales Person", "Order Revenue"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(revenueT);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 620, 470));

        btnAbove.setText("with consist above target sales");
        btnAbove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAboveActionPerformed(evt);
            }
        });
        add(btnAbove, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 510, 380, 40));

        btnBelow.setText("with below total order target sales");
        btnBelow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBelowActionPerformed(evt);
            }
        });
        add(btnBelow, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 510, 380, 40));

        btnView1.setText("<<Export");
        btnView1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnView1ActionPerformed(evt);
            }
        });
        add(btnView1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 120, 180, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void btnView1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnView1ActionPerformed
        // TODO add your handling code here:
        toCSV();
    }//GEN-LAST:event_btnView1ActionPerformed

    private void btnBelowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBelowActionPerformed
        // TODO add your handling code here:
        OrderDirectory odd = new OrderDirectory();
        for(Order o : orderDirectory.getElementArrayList()){
            if(o.getGap() < 0){
                odd.getElementArrayList().add(o);
            }
        }
        ppt(odd);
        
    }//GEN-LAST:event_btnBelowActionPerformed

    private void btnAboveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAboveActionPerformed
        // TODO add your handling code here:
        OrderDirectory odd = new OrderDirectory();
        for(Order o : orderDirectory.getElementArrayList()){
            if(o.getGap() > 0){
                odd.getElementArrayList().add(o);
            }
        }
        ppt(odd);
    }//GEN-LAST:event_btnAboveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbove;
    private javax.swing.JButton btnBelow;
    private javax.swing.JButton btnView1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable revenueT;
    // End of variables declaration//GEN-END:variables

    @Override
    public JTable getTable() {
        return revenueT;
    }

    @Override
    public Object[] populateRow(Order element) {
        return new Object[] {
            element,
            element.getSoldBy()            
        };
    }

    @Override
    public void populateTable() {
        populateTable(orderDirectory.getElementArrayList());
    }

    @Override
    public String getTitle() {
        return "Sales Person(People) Performance\nPress Button to view.";
    }
}
