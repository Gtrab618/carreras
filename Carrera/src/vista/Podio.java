/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import javax.swing.JLabel;

/**
 *
 * @author gt618
 */
public class Podio extends javax.swing.JFrame {
    private SoundEffect soundPodio = new SoundEffect("src/sound/podio.wav");

    public SoundEffect getSoundPodio() {
        return soundPodio;
    }

    public void setSoundPodio(SoundEffect soundPodio) {
        this.soundPodio = soundPodio;
    }
    
    public Podio() {
        initComponents();
    }

    public JLabel getLbl_primer() {
        return lbl_primer;
    }

    public void setLbl_primer(JLabel lbl_primer) {
        this.lbl_primer = lbl_primer;
    }

    public JLabel getLbl_segun() {
        return lbl_segun;
    }

    public void setLbl_segun(JLabel lbl_segun) {
        this.lbl_segun = lbl_segun;
    }

    public JLabel getLbl_tercer() {
        return lbl_tercer;
    }

    public void setLbl_tercer(JLabel lbl_tercer) {
        this.lbl_tercer = lbl_tercer;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_tercer = new javax.swing.JLabel();
        lbl_primer = new javax.swing.JLabel();
        lbl_segun = new javax.swing.JLabel();
        lbl_podio = new javax.swing.JLabel();
        lbl_fondoPodio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(lbl_tercer, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 100, 35));
        getContentPane().add(lbl_primer, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 100, 35));
        getContentPane().add(lbl_segun, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 100, 35));

        lbl_podio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/podio.png"))); // NOI18N
        getContentPane().add(lbl_podio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 360, 170));

        lbl_fondoPodio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/f5c8d5f3d83056ccb6551b4c0ee636d0.gif"))); // NOI18N
        getContentPane().add(lbl_fondoPodio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbl_fondoPodio;
    private javax.swing.JLabel lbl_podio;
    private javax.swing.JLabel lbl_primer;
    private javax.swing.JLabel lbl_segun;
    private javax.swing.JLabel lbl_tercer;
    // End of variables declaration//GEN-END:variables
}
