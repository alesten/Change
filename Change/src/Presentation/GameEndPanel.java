/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Interfaces.PlayerInterface;

/**
 *
 * @author priva_000
 */
public class GameEndPanel extends javax.swing.JPanel {

    /**
     * Creates new form GameEndPanel
     */
    public GameEndPanel() {
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

        lblHeadline = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblText = new javax.swing.JLabel();
        btnGoToStart = new javax.swing.JButton();
        btnGoToHighscore = new javax.swing.JButton();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        lblHeadline.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblHeadline.setText("Gameover");

        lblText.setText("<html><body> The game is over!<br /> <br />All your're drugs have been sold to the country you were traveling to marketprice<br /><br/> You finished with a score of {score} </body></html>");

        btnGoToStart.setText("Go to start");
        btnGoToStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoToStartActionPerformed(evt);
            }
        });

        btnGoToHighscore.setText("Highscore");
        btnGoToHighscore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoToHighscoreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblHeadline, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnGoToStart)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnGoToHighscore)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGoToStart)
                    .addComponent(btnGoToHighscore))
                .addContainerGap(252, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        GameController controller = GameController.getInstance();
        PlayerInterface player = controller.getService().getPlayer();

        String labelText = this.lblText.getText()
                .replace("{score}", String.valueOf(player.getBalance()));

        this.lblText.setText(labelText);
    }//GEN-LAST:event_formComponentShown

    private void btnGoToStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoToStartActionPerformed
        MainViewState.getInstance().change("main");
    }//GEN-LAST:event_btnGoToStartActionPerformed

    private void btnGoToHighscoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoToHighscoreActionPerformed
        MainViewState.getInstance().change("highscore");
    }//GEN-LAST:event_btnGoToHighscoreActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGoToHighscore;
    private javax.swing.JButton btnGoToStart;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblHeadline;
    private javax.swing.JLabel lblText;
    // End of variables declaration//GEN-END:variables
}
