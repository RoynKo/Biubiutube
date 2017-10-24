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
import biz.Components.Product;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JTable;

/**
 *
 * @author royn
 */
public class ProductSoldAboveTargetPrice extends javax.swing.JPanel implements HasTitle, TablePopulatable<Product>{
    
    /**
     * Creates new form ProductSoldAboveTargetPrice
     */
    public ProductSoldAboveTargetPrice() {
        initComponents();
        populateTable();
    }
    
    public void PSResult(){
        ArrayList<Product> products = Business.getInstance().getAllProducts();
        products.sort((Product o1, Product o2) -> Double.compare(o2.getProductRevenue(), o1.getProductRevenue()));
        int toIndex = products.size() > 3 ? 3 : products.size();
        populateTable(new ArrayList<> (products.subList(0, toIndex)));
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
        jButton1 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Product Name", "Supplier", "Total Revenue"
            }
        ));
        jScrollPane1.setViewportView(tblProduct);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 680, -1));

        jButton1.setText("Find most Valuable Product");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 490, 270, 60));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        PSResult();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProduct;
    // End of variables declaration//GEN-END:variables

    @Override
    public String getTitle() {
        return "Top3 Products Sold Above Target Price";
    }

    @Override
    public JTable getTable() {
        return tblProduct;
    }

    @Override
    public Object[] populateRow(Product element) {
        return new Object[]{
            element,
            element.getSupplier(),
            String.format("%.2f", element.getProductRevenue())
        };
    }

    @Override
    public void populateTable() {
        populateTable(Business.getInstance().getAllProducts());
    }
}
