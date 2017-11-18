/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.components;

import java.awt.Color;
import java.util.UUID;

/**
 *
 * @author hezj
 */
public class DemoJPanel extends javax.swing.JPanel implements HasTitle {
    private ParentUI parent;
    
    /**
     * Creates new form DemoJPanel
     */
    public DemoJPanel(ParentUI parent) {
        this.parent = parent;
        initComponents();
        this.setBackground(new Color(rand255(), rand255(), rand255()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPush = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        btnPush.setText("Push");
        btnPush.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPushActionPerformed(evt);
            }
        });

        jButton1.setText("U can see me");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnPush, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnPush)
                .addGap(572, 572, 572)
                .addComponent(jButton1))
        );
    }// </editor-fold>//GEN-END:initComponents

    private int rand255() {
        return (int)(Math.random() * 255); 
    }
    
    private void btnPushActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPushActionPerformed
        parent.pushComponent(new DemoJPanel(parent));
    }//GEN-LAST:event_btnPushActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPush;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables

    @Override
    public String getTitle() {
        return String.format("Demo %s", UUID.randomUUID());
    }
}
