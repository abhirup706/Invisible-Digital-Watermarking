package image_watermark;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Welcome extends javax.swing.JFrame {

    static public String framePath;
    static public String KeyPath;
    static public String VideoPath;
    static public int vidcount = 1;
    static public int enhance = 0;
    static public String vid;
    String files;
    String Signature = "";
    String line;
    Connection con;

    public Welcome() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSlider1 = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setLayout(null);
        jPanel1.add(jSlider1);
        jSlider1.setBounds(70, 185, 156, 20);

        jLabel1.setFont(new java.awt.Font("Monotype Corsiva", 0, 24));
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setText("Piracy detection");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(140, 310, 150, 28);

        jTextField1.setText("Select Frames");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1);
        jTextField1.setBounds(30, 350, 220, 30);

        jButton1.setText("Browse");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(270, 350, 140, 30);

        jTextField2.setText("Select Copyright Info");
        jPanel1.add(jTextField2);
        jTextField2.setBounds(20, 140, 240, 30);

        jButton4.setText("Browse");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(270, 90, 100, 30);

        jButton5.setText("Browse");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(270, 140, 100, 30);

        jLabel2.setFont(new java.awt.Font("Monotype Corsiva", 0, 24));
        jLabel2.setForeground(new java.awt.Color(153, 0, 0));
        jLabel2.setText("Digital WaterMark ");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(130, 30, 210, 28);

        jLabel3.setText("Enter video id");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 420, 110, 14);

        jLabel4.setText("1         2          3          4          5");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(70, 220, 170, 14);

        jButton6.setText("Vedio Detection");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6);
        jButton6.setBounds(270, 410, 140, 30);

        jTextField3.setText("Select Video Frame");
        jPanel1.add(jTextField3);
        jTextField3.setBounds(20, 90, 240, 30);

        jButton9.setText("Watermark");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9);
        jButton9.setBounds(130, 250, 130, 40);

        jLabel5.setText("Select Enhancement");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(240, 220, 140, 14);
        jPanel1.add(jTextField4);
        jTextField4.setBounds(130, 410, 120, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new SelectFrames(this, 3).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        new SelectFrames(this, 1).setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        new SelectFrames(this, 2).setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:

     //   getVidcount();
        String str = jTextField1.getText();
        vidcount = Integer.parseInt(jTextField4.getText());
        Signature = "";
        Dewatermark.count=0;

        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(jTextField2.getText())));
            while ((line = br.readLine()) != null) {
                Signature += line;
            }
        } catch (Exception e) {
            System.out.println("Exception while capturing Signature");
        }
        System.out.println(Signature);


        File Folder = new File(str);
        File[] listOfFiles = Folder.listFiles();

        try {
            for (int i = 0; i < 1; i++) {
                if (listOfFiles[i].isFile()) {
                    files = str + "//" + listOfFiles[i].getName();
                    new Dewatermark(files, Signature, this);
                }
                jOptionPane1.showMessageDialog(this, "No Piracy Detected");
            }
        } catch (Exception e) {
            System.out.println("Pirated Vedio");
        }

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        enhance = jSlider1.getValue() / 20 + 1;
        Watermark.count=0;
        Signature = "";
        String str = jTextField3.getText();

        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(jTextField2.getText())));
            while ((line = br.readLine()) != null) {
                Signature += line;
            }
            System.out.println(Signature);
        } catch (Exception e) {
            System.out.println("Exception while capturing Signature");
        }
        File Folder = new File(str);
        File[] listOfFiles = Folder.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                files = str + "//" + listOfFiles[i].getName();
                new Watermark(files, Signature);
            }
        }

        System.out.println("create vid id");

        createVidID();
        jOptionPane1.showMessageDialog(this, "watermark completed, Vedio-ID : VID_" + vidcount);
        vidcount++;
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    public void setFramePath() {
        this.jTextField1.setText(framePath);
    }

    public void setVideoPath() {
        this.jTextField3.setText(VideoPath);
    }

    public void connectDB() {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

        } catch (java.lang.ClassNotFoundException e2) {
            System.err.print("ClassNotFoundException: ");
            System.err.println(e2.getMessage());
        }

        try {
            con = DriverManager.getConnection("jdbc:odbc:watermark", "watermark", "watermark");
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }


    }

    public void getVidcount()
    {
         connectDB();

        try {
            String sql = "SELECT count(*) FROM VID;";
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                String str = rs.getString(1);
                System.out.println(str);
                if (Integer.parseInt(str) > 1) {
                    vidcount = Integer.parseInt(str);
                }

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

         System.out.println("vidcount : " + vidcount);
    }

    public void createVidID() {

        getVidcount();

        System.out.println("vidcount = " + vidcount);

        try {
            String sql = "INSERT INTO VID VALUES (" + vidcount + ",'" + VideoPath + "\\output\\VID_" + vidcount + "');";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void setKeyPath() {
        this.jTextField2.setText(KeyPath);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Welcome().setVisible(true);
            }
        });
    }
    private JOptionPane jOptionPane1;
    private JOptionPane jOptionPane2;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
