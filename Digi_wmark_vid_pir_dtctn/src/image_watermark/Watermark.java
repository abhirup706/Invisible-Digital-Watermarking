package image_watermark;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Watermark {

    static BufferedImage image;
    HashMap pixels;
    Connection con;
    static int count = 0;
    static int X = 0;
    static int Y = 0;
    static int VAL = 0;
    static int COL = 0;

    Watermark(String frame, String Signature) {

        System.out.println("For image : " + frame);
        String line;
        try {
            image = ImageIO.read(new File(frame));
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        generateKey(image.getWidth(), image.getHeight(), Signature);
        try {
            File f = new File(Welcome.VideoPath + "\\output\\VID_" + Welcome.vidcount);
            if(!f.exists())
            f.mkdir();
            ImageIO.write(image, "png", new File(Welcome.VideoPath + "\\output\\VID_" + Welcome.vidcount + "\\" + ++count + ".png"));

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

    }

    public void generateKey(int x, int y, String watermark) {
        connectDB();
        pixels = new HashMap<String, Color>();

        for (int i = 0; i < watermark.length(); i++) {
            X = (int) (Math.random() * x);
            Y = (int) (Math.random() * y);
            VAL = (watermark.charAt(i) / 10) * Welcome.enhance;
            COL = (int) ((Math.random() * 10) / 4);

            changePixels();
            insertKey(i);
        }


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

    public void insertKey(int index) {
        try {

            String sql = "INSERT INTO Key VALUES ('VID_" + Welcome.vidcount + "'," + count + "," + index + "," + X + "," + Y + "," + VAL + "," + COL + ");";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, e1.toString());
        }
    }

    public void changePixels() {

        /*   int rgb = ((255 & 0xFF) << 24) | //alpha
        ((VAL & 0xFF) << 16) | //red
        ((VAL & 0xFF) << 8)  | //green
        ((VAL & 0xFF) << 0); //blue
         */

        int rgba = image.getRGB(X, Y);
        Color col = new Color(rgba, true);
        /*       switch (COL) {
        case 0:
        col = new Color(VAL, col.getGreen(), col.getBlue());
        break;
        case 1:
        col = new Color(col.getRed(), VAL, col.getBlue());
        break;
        case 2:
        col = new Color(col.getRed(), col.getGreen(),VAL);
        break;
        default:
        System.out.println("wrong color");
        }*/

        switch (COL) {
            case 0:
                if (col.getRed() > 127) {
                    VAL = col.getRed() - VAL;
                    col = new Color(VAL, col.getGreen(), col.getBlue());

                } else {
                    VAL = col.getRed() + VAL;
                    col = new Color(VAL, col.getGreen(), col.getBlue());

                }
                break;

            case 1:
                if (col.getGreen() > 127) {
                    VAL = col.getGreen() - VAL;
                    col = new Color(col.getRed(), VAL, col.getBlue());

                } else {
                    VAL = col.getGreen() + VAL;
                    col = new Color(col.getRed(), VAL, col.getBlue());

                }
                break;

            case 2:
                if (col.getBlue() > 127) {
                    VAL = col.getBlue() - VAL;
                    col = new Color(col.getRed(), col.getGreen(), VAL);

                } else {
                    VAL = col.getBlue() + VAL;
                    col = new Color(col.getRed(), col.getGreen(), VAL);

                }
                break;

            default:
                System.out.println("wromg color");
        }

        //     col = new Color(255, 255,255);

        System.out.println("  X\tY\tCOL");
        switch (COL) {
            case 0:
                System.out.println(X + "\t" + Y + "\t" + col.getRed());
                System.out.println(X + "\t" + Y + "\t" + VAL);
                break;
            case 1:
                System.out.println(X + "\t" + Y + "\t" + col.getGreen());
                System.out.println(X + "\t" + Y + "\t" + VAL);
                break;
            case 2:
                System.out.println(X + "\t" + Y + "\t" + col.getBlue());
                System.out.println(X + "\t" + Y + "\t" + VAL);
                break;
        }

        image.setRGB(X, Y, col.getRGB());
        pixels.put(X + "," + Y, col);
    }
}
