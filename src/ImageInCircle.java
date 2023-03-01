import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;



public class ImageInCircle extends JPanel {
    JFrame f = new JFrame();
    Image img;
    int width;
    int height;
    static String imgFile =
            "assets/profile.jpg";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->new ImageInCircle().start());

    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }
    public ImageInCircle () {
        f.add(this);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public void start() {
        try {
            img = ImageIO.read(new File(imgFile));
        } catch (IOException fne) {
            fne.printStackTrace();
        }
        width = img.getWidth(null);
        height = img.getHeight(null);
        revalidate();
        f.setVisible(true);
        f.pack();

        f.setLocationRelativeTo(null);
        repaint();


    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.white);
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = bi.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        int circleDiameter = Math.min(width,height);
        Ellipse2D.Double circle = new Ellipse2D.Double(0,0,circleDiameter,circleDiameter);
        g2.setClip(circle);
        g2.drawImage(img,0,0,this);
        try {
            ImageIO.write(bi, "PNG", new File("yourImageName.PNG"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}