/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Interfaces.DrugInterface;
import Interfaces.MarketplaceInterface;
import Interfaces.PlayerInterface;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author priva_000
 */
public class MarketplacePanel extends javax.swing.JPanel implements Observer {

    /**
     * Creates new form MarketplacePanel
     */
    public MarketplacePanel() {
        initComponents();
        
        GameController.getInstance().addObserver(this);
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
        marketplaceItemsPanel = new javax.swing.JPanel();

        lblHeadline.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblHeadline.setText("Marketplace");

        marketplaceItemsPanel.setBackground(new java.awt.Color(204, 204, 0));
        marketplaceItemsPanel.setLayout(new javax.swing.BoxLayout(marketplaceItemsPanel, javax.swing.BoxLayout.Y_AXIS));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblHeadline)
                .addGap(0, 535, Short.MAX_VALUE))
            .addComponent(marketplaceItemsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(lblHeadline)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(marketplaceItemsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblHeadline;
    private javax.swing.JPanel marketplaceItemsPanel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object o1) {
        GameController controller = GameController.getInstance();
        PlayerInterface player = controller.getService().getPlayer();
        MarketplaceInterface marketplace = player.getCurrentCountry().getMarketplace();
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        for (final DrugInterface drug : marketplace.getDrugs().values()) {
            MarketplaceItem item = new MarketplaceItem();
            item.setData(marketplace, drug);
            
            panel.add(item);
            panel.revalidate();
            panel.repaint();
            
        }
        
        JScrollPane drugPanel = new JScrollPane(panel);
        drugPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
        marketplaceItemsPanel.removeAll();
        marketplaceItemsPanel.add(drugPanel);
        marketplaceItemsPanel.revalidate();
    }
}