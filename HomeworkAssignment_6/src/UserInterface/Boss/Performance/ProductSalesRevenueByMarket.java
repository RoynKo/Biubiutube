/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Boss.Performance;

import UserInterface.Components.HasTitle;
import UserInterface.Components.TablePopulatable;
import biz.Components.Business;
import biz.Components.Market;
import javax.swing.JTable;

/**
 *
 * @author hezj
 */
public class ProductSalesRevenueByMarket extends javax.swing.JPanel implements HasTitle, TablePopulatable<Market>{

    /**
     * Creates new form ProductSalesRevenueByMarket
     */
    public ProductSalesRevenueByMarket() {
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
        tblMarket = new javax.swing.JTable();
        btnView3 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblMarket.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Market", "Revenue"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblMarket);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 590, -1));

        btnView3.setText("<<Export");
        btnView3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnView3ActionPerformed(evt);
            }
        });
        add(btnView3, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 120, 180, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void btnView3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnView3ActionPerformed
        // TODO add your handling code here:
        toCSV();
    }//GEN-LAST:event_btnView3ActionPerformed

    @Override
    public String getTitle() {
        return "Product Sales Revenue By Market";
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnView1;
    private javax.swing.JButton btnView2;
    private javax.swing.JButton btnView3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMarket;
    // End of variables declaration//GEN-END:variables

    @Override
    public JTable getTable() {
        return tblMarket;
    }

    @Override
    public Object[] populateRow(Market market) {
        return new Object[]{
            market,
            market.getMarketRevenue()
        };
    }

    @Override
    public void populateTable() {
        populateTable(Business.getInstance().getMarketCatalog().getElementArrayList());
    }
}