/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Boss.Product;

import UserInterface.Components.HasTitle;
import UserInterface.Components.ParentUI;
import UserInterface.Components.TablePopulatable;
import biz.Components.Business;
import biz.Components.Product;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;


/**
 *
 * @author royn
 */
public class ManageProductJPanel extends javax.swing.JPanel implements HasTitle, TablePopulatable<Product>{
    private ParentUI parent;

    /**
     * Creates new form ManageProductJPanel
     */
    public ManageProductJPanel(ParentUI parent) {
        initComponents();
        this.parent = parent;
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
        tblProduct = new javax.swing.JTable();
        btnSearchProduct = new javax.swing.JButton();
        btnView2 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Product Name", "Product Number", "Facotry Price", "Supplier", "Stock"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProduct);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 750, -1));

        btnSearchProduct.setText("Search");
        btnSearchProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchProductActionPerformed(evt);
            }
        });
        add(btnSearchProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 100, 170, 40));

        btnView2.setText("<<Export");
        btnView2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnView2ActionPerformed(evt);
            }
        });
        add(btnView2, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 170, 180, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchProductActionPerformed
        final String productName = JOptionPane.showInputDialog(this, "Please input the name of Product you want to find");
        ArrayList<Product> productList = Business.getInstance().findProducts(product -> product.getProductName().equals(productName));
        populateTable(productList);
    }//GEN-LAST:event_btnSearchProductActionPerformed

    private void btnView2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnView2ActionPerformed
        // TODO add your handling code here:
        toCSV();
    }//GEN-LAST:event_btnView2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearchProduct;
    private javax.swing.JButton btnView1;
    private javax.swing.JButton btnView2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProduct;
    // End of variables declaration//GEN-END:variables

    @Override
    public String getTitle() {
        return "View All Products";
    }

    @Override
    public JTable getTable() {
        return tblProduct;
    }

    @Override
    public Object[] populateRow(Product p) {
        return new Object[] {p, p.getProductName(), p.getFactoryPrice(), p.getSupplier(), p.getStock()};
    }

    @Override
    public void populateTable() {
        ArrayList<Product> p = Business.getInstance().getAllProducts();
        populateTable(p);    
    }
}
