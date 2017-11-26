/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.network.university.college.viewer.anonymous;

import biz.EcoSystem;
import biz.nw.Network;

import javax.swing.JTable;

import biz.org.unv.UniverseCollegeOrganization;

import javax.swing.table.DefaultTableModel;

import biz.role.producerRole.CollegeLecturerRole;
import biz.role.producerRole.ECOLecturerRole;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import ui.components.HasTitle;
import ui.components.ParentUI;
import ui.components.TablePopulatable;

/**
 * @author hezj
 */
public class NCChoose extends javax.swing.JPanel implements HasTitle, TablePopulatable<Network> {
    private ParentUI parent;

    /**
     * Creates new form NetworkChoose
     */
    public NCChoose(ParentUI parent) {
        this.parent = parent;
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

        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNetwork = new javax.swing.JTable();
        btnChoose = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCollege = new javax.swing.JTable();

        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        tblNetwork.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Total Videos", "Total Lecturers"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNetwork.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblNetworkMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblNetwork);

        btnChoose.setText("Choose");
        btnChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        tblCollege.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Total Videos", "Total Lecturers"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblCollege);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnChoose))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnChoose)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        parent.popComponent();
    }//GEN-LAST:event_btnBackActionPerformed

    private void tblNetworkMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNetworkMouseReleased
        Network network = getSelected();

        DefaultTableModel dtm = (DefaultTableModel) tblCollege.getModel();
        dtm.setRowCount(0);
        for (UniverseCollegeOrganization org : network.getUniversity().getCollegeCatalog().getOrganizations()) {
            Object[] row = new Object[]{
                    org,
                    network.getVideoCatalog().getVideoArrayList().stream().filter(
                            v -> v.getUploaderAccount().getOrg().equals(org)
                    ).count(),
                    org.getAccountCatalog().getAccountArrayList().stream().filter(
                            a -> a.getRole() instanceof CollegeLecturerRole
                    ).count(),
            };
            dtm.addRow(row);
        }
    }//GEN-LAST:event_tblNetworkMouseReleased

    private void btnChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseActionPerformed
        int c = tblCollege.getSelectedRowCount();
        if (c != 1) {
            JOptionPane.showMessageDialog(this, "Please Select 1 and only 1 Colleges.");
            return;
        }
        UniverseCollegeOrganization college = (UniverseCollegeOrganization) tblCollege.getValueAt(tblCollege.getSelectedRow(), 0);
        parent.popComponent();
        JPanel container = parent.getContainerJPanel();
        JPanel topJPanel = (JPanel) container.getComponent(container.getComponentCount() - 1);
        Signup signup = (Signup) topJPanel.getComponent(0);
        signup.setNetwork(college.getEnterprise().getNetwork());
        signup.setCollege(college);
    }//GEN-LAST:event_btnChooseActionPerformed

    @Override
    public String getTitle() {
        return "Choose Network and College";
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnChoose;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblCollege;
    private javax.swing.JTable tblNetwork;
    // End of variables declaration//GEN-END:variables

    @Override
    public JTable getTable() {
        return tblNetwork;
    }

    @Override
    public Object[] populateRow(Network network) {
        return new Object[]{
                network,
                network.getVideoCatalog().getVideoArrayList().size(),
                EcoSystem.getInstance().getAllAccountArrayList().stream().filter(a -> ((a.getRole() instanceof CollegeLecturerRole) || (a.getRole() instanceof ECOLecturerRole)) && a.getOrg().getEnterprise().getNetwork().equals(network)
                ).count()
        };
    }

    @Override
    public void populateTable() {
        populateTable(EcoSystem.getInstance().getNetworkArrayList());
    }
}
