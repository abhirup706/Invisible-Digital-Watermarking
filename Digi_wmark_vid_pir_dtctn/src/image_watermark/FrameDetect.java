/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Interface.java
 *
 * Created on Dec 27, 2013, 9:21:26 PM
 */
package image_watermark;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Gogozz
 */
public class FrameDetect extends javax.swing.JFrame {

    File file;
    String path;
    File ifile;
    File ofile;
    FileWriter fw;
    BufferedWriter bw;
    BufferedImage image;
    int Width;
    int Height;
    HashMap pixels;

    public FrameDetect() {
        initComponents();
        this.setSize(565, 490);
        try {
            image = ImageIO.read(new File("C://1.png"));
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        Width = image.getWidth();
        Height = image.getHeight();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 102, 255), new java.awt.Color(153, 0, 255), null, null));
        jPanel1.setLayout(null);

        jLabel2.setBackground(new java.awt.Color(228, 194, 228));
        jScrollPane1.setViewportView(jLabel2);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(280, 60, 240, 220);

        jScrollPane3.setViewportView(jLabel1);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(20, 60, 250, 220);

        jButton2.setText("Perpetual");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(300, 310, 100, 40);

        jButton4.setText("Monochrome");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(410, 310, 100, 40);

        jLabel3.setFont(new java.awt.Font("Monotype Corsiva", 0, 24));
        jLabel3.setForeground(new java.awt.Color(153, 0, 0));
        jLabel3.setText("Piracy Frame Detection");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(190, 20, 210, 28);

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(160, 310, 90, 40);

        jButton3.setText("Exit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(60, 310, 90, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 540, 430);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        invertImage();
        try {
            jLabel2.setIcon(new ImageIcon(ImageIO.read(ofile)));
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        monochromeImage();
        try {
            jLabel2.setIcon(new ImageIcon(ImageIO.read(ofile)));
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    public void invertImage() {

        BufferedImage inputFile = null;
         ifile = new File(path);
        try {
            inputFile = ImageIO.read(ifile);
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        for (int x = 0; x < inputFile.getWidth(); x++) {
            for (int y = 0; y < inputFile.getHeight(); y++) {
                int rgba = inputFile.getRGB(x, y);
                Color col = new Color(rgba, true);
                col = new Color(255 - col.getRed(),
                        255 - col.getGreen(),
                        255 - col.getBlue());
                inputFile.setRGB(x, y, col.getRGB());
            }
        }

        try {
            int index = ifile.getPath().lastIndexOf(".");
            String Filepath = ifile.getPath().substring(0, index) + "mon_" + ifile.getPath().substring(index);
             ofile = new File(Filepath);
            ImageIO.write(inputFile, "png", ofile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void monochromeImage() {
        int MONO_THRESHOLD = 368;
        BufferedImage inputFile = null;
         ifile = new File(path);
        try {
           inputFile = ImageIO.read(ifile);
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

        for (int x = 0; x < inputFile.getWidth(); x++) {
            for (int y = 0; y < inputFile.getHeight(); y++) {
                int rgba = inputFile.getRGB(x, y);
                Color col = new Color(rgba, true);

                if (col.getRed() + col.getGreen() + col.getBlue() > MONO_THRESHOLD) {
                    col = new Color(255, 255, 255);
                } else {
                    col = new Color(0, 0, 0);
                }
                inputFile.setRGB(x, y, col.getRGB());
            }
        }

        try {
             int index = ifile.getPath().lastIndexOf(".");
            String Filepath = ifile.getPath().substring(0, index) + "inv_" + ifile.getPath().substring(index);
             ofile = new File(Filepath);
            ImageIO.write(inputFile, "png", ofile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generateKey(int x, int y, String watermark) {
        pixels = new HashMap<String, Color>();
        try {
            File file = new File("C://key.txt");
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < watermark.length(); i++) {
                int val = watermark.charAt(i);
                int X = (int) (Math.random() * x);
                int Y = (int) (Math.random() * y);
                int clr = (int) ((Math.random() * 10) / 4);
                bw.write(X + "\t" + Y + "\t" + val + "\t" + clr);
                bw.newLine();
                bw.flush();
                changePixels(X, Y, val, clr);

            }
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        System.out.println("pixels length : " + pixels.size());
    }

    public void changePixels(int x, int y, int val, int color) {
        /*   int rgb = ((255 & 0xFF) << 24) | //alpha
        ((val & 0xFF) << 16) | //red
        ((val & 0xFF) << 8)  | //green
        ((val & 0xFF) << 0); //blue
         */

        int rgba = image.getRGB(x, y);
        Color col = new Color(rgba, true);
        switch (color) {
            case 0:
                col = new Color(val,
                        col.getGreen(),
                        col.getBlue());
                break;

            case 1:
                col = new Color(col.getRed(),
                        val,
                        col.getBlue());
                break;

            case 2:
                col = new Color(val,
                        col.getGreen(),
                        val);
                break;

            default:
                System.out.println("wromg color");
        }

        image.setRGB(x, y, col.getRGB());
        pixels.put(x + "," + y, col);
    }

    public void setImage(String path) {
        this.path = path;
        jLabel1.setIcon(new ImageIcon(path));
        jLabel2.setIcon(new ImageIcon(path));
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FrameDetect().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
