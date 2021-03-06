/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Interfaces.HighscoreItemInterface;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author priva_000
 */
public class HighscorePanel extends javax.swing.JPanel {

    /**
     * Creates new form HighscorePanel
     */
    public HighscorePanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        lblHeadline = new javax.swing.JLabel();
        contentPanel = new javax.swing.JPanel();
        highscoreScrollPane = new javax.swing.JScrollPane();
        tblHighscores = new javax.swing.JTable();
        btnGoBack = new javax.swing.JButton();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        lblHeadline.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblHeadline.setText("Highscore");

        contentPanel.setLayout(new javax.swing.BoxLayout(contentPanel, javax.swing.BoxLayout.LINE_AXIS));

        tblHighscores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Player", "Score"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHighscores.setFocusable(false);
        tblHighscores.setRowSelectionAllowed(false);
        tblHighscores.getTableHeader().setReorderingAllowed(false);
        highscoreScrollPane.setViewportView(tblHighscores);
        if (tblHighscores.getColumnModel().getColumnCount() > 0) {
            tblHighscores.getColumnModel().getColumn(0).setResizable(false);
            tblHighscores.getColumnModel().getColumn(1).setResizable(false);
            tblHighscores.getColumnModel().getColumn(1).setPreferredWidth(10);
        }

        contentPanel.add(highscoreScrollPane);

        btnGoBack.setText("Back");
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 778, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(lblHeadline, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnGoBack)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHeadline)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGoBack)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        MainViewState.getInstance().change("main");
    }//GEN-LAST:event_btnGoBackActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        GameController controller = GameController.getInstance();

        DefaultTableModel model = (DefaultTableModel) tblHighscores.getModel();

        // clear the table
        int numberOfRows = model.getRowCount();
        for (int rowIndex = numberOfRows - 1; rowIndex >= 0; rowIndex--) {
            model.removeRow(rowIndex);
        }

        // add the persons to the table
        for (HighscoreItemInterface highscoreItem : controller.getService().getHighscores()) {
            Object[] row = {
                highscoreItem.getName(), String.valueOf(highscoreItem.getScore())
            };

            model.addRow(row);
        }
    }//GEN-LAST:event_formComponentShown


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGoBack;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JScrollPane highscoreScrollPane;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblHeadline;
    private javax.swing.JTable tblHighscores;
    // End of variables declaration//GEN-END:variables
}
