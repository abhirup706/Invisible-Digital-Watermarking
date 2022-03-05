/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SelectFrames.java
 *
 * Created on Feb 9, 2014, 3:17:31 PM
 */
package image_watermark;

import image_watermark.Welcome;

/**
 *
 * @author Gogozz
 */
public class SelectFrames extends javax.swing.JFrame {

    Welcome welcome;    
    int i;

    /** Creates new form SelectFrames */
    public SelectFrames(Welcome welcome, int i) {
        initComponents();
        this.setSize(500, 500);               
        this.welcome = welcome;
        this.i = i;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jFileChooser1.setControlButtonsAreShown(false);
        jFileChooser1.setFileSelectionMode(javax.swing.JFileChooser.FILES_AND_DIRECTORIES);
        jFileChooser1.setSelectedFile(new java.io.File("C:\\Program Files\\MATLAB71\\work\\frames"));
        jFileChooser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooser1ActionPerformed(evt);
            }
        });
        getContentPane().add(jFileChooser1);
        jFileChooser1.setBounds(-3, -3, 560, 400);

        jButton1.setText("Select");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(290, 410, 100, 40);

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(170, 410, 100, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jFileChooser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooser1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFileChooser1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here.

        switch (i) {
            case 1:
                welcome.VideoPath = jFileChooser1.getSelectedFile().toString();
                welcome.setVideoPath();
                this.setVisible(false);
                break;
            case 2:
                welcome.KeyPath = jFileChooser1.getSelectedFile().toString();
                welcome.setKeyPath();
                this.setVisible(false);
                break;
            case 3:
                welcome.framePath = jFileChooser1.getSelectedFile().toString();
                welcome.setFramePath();                
                this.setVisible(false);
                break;
          /* case 10:
                framedetect.setImage(jFileChooser1.getSelectedFile().toString());
                this.setVisible(false);
                break;
           */
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new SelectFrames(null, 0).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JFileChooser jFileChooser1;
    // End of variables declaration//GEN-END:variables
}
