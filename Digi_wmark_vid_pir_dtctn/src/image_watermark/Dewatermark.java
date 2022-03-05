package image_watermark;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Dewatermark {

    BufferedImage image;
    HashMap pixels;
    Connection con;
    static int count = 0;
    static int X = 0;
    static int Y = 0;
    static int VAL = 0;
    static int COL = 0;
    Welcome welcome;

    Dewatermark(String frame, String Signature, Welcome welcome) throws Exception {
        String line;
        welcome =  this.welcome;
         try {
            image = ImageIO.read(new File(frame));
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        DegenerateKey(Signature);
 
    }

    public void DegenerateKey(String watermark) throws Exception{
        connectDB();
        pixels = new HashMap<String, Color>();
    
        
        for (int i = 0; i < watermark.length(); i++) {
            getKey(i);        
            Deval(X, Y, VAL, COL);
        }
        count++;
     
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

    public void getKey(int index) {
        try {
             System.out.println("checkpoint");
            String sql = "SELECT * FROM Key where Vid_ID = 'VID_"+ Welcome.vidcount +"' and  Image_ID = " + count + "and Key_ID =" + index;
            System.out.println(sql);
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                X = rs.getInt("X");
                Y = rs.getInt("Y");
                VAL = rs.getInt("Val");
                COL = rs.getInt("Col");
            }
            System.out.println(X + "\t" + Y + "\t" + VAL + "\t" + COL);
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, e1.toString());
        }
    }

    public void Deval  (int x, int y, int val, int color) throws Exception{
        int flag=0;
        int rgba = image.getRGB(x, y);
        Color col = new Color(rgba, true);
        switch (color) {
            case 0:
                System.out.println(x + "\t" + y + "\t" + col.getRed());
                if(val==col.getRed())
                    flag=1;
                break;
            case 1:
                System.out.println(x + "\t" + y + "\t" + col.getGreen());
                     if(val==col.getGreen())
                    flag=1;
                break;
            case 2:
                System.out.println(x + "\t" + y + "\t" + col.getBlue());
                 if(val==col.getBlue())
                    flag=1;
                break;
            default:
                System.out.println("Invalid entry");
        }
           System.out.println("______________________flag = " + flag + "____________________________");
           if(flag==0)
           {
                  jOptionPane1.showMessageDialog(welcome, "Pirated Vedio");
                  throw new Exception();
           }
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
                if (col.getRed() > 127) {
                    if (col.getRed() - val > 0) {
                        col = new Color(col.getRed() - val, col.getGreen(), col.getBlue());
                    } else {
                        col = new Color(0, col.getGreen(), col.getBlue());
                    }

                } else {
                    if (col.getRed() + val < 255) {
                        col = new Color(col.getRed() + val, col.getGreen(), col.getBlue());
                    } else {
                        col = new Color(255, col.getGreen(), col.getBlue());
                    }

                }
                break;

            case 1:
                if (col.getGreen() > 127) {
                    if (col.getGreen() - val > 0) {
                        col = new Color(col.getRed(), col.getGreen() - val, col.getBlue());
                    } else {
                        col = new Color(col.getRed(), 0, col.getBlue());
                    }

                } else {
                    if (col.getGreen() + val < 255) {
                        col = new Color(col.getRed(), col.getGreen() + val, col.getBlue());
                    } else {
                        col = new Color(col.getRed(), 255, col.getBlue());
                    }

                }
                break;

            case 2:
                if (col.getBlue() > 127) {
                    if (col.getBlue() - val > 0) {
                        col = new Color(col.getRed(), col.getGreen(), col.getBlue() - val);
                    } else {
                        col = new Color(col.getRed(), col.getGreen(), 0);
                    }

                } else {
                    if (col.getBlue() + val < 255) {
                        col = new Color(col.getRed(), col.getGreen(), col.getBlue() + val);
                    } else {
                        col = new Color(col.getRed(), col.getGreen(), 255);
                    }

                }
                break;

            default:
                System.out.println("wromg color");
        }

        image.setRGB(x, y, col.getRGB());
        pixels.put(x + "," + y, col);
    }

private JOptionPane jOptionPane1;
}
