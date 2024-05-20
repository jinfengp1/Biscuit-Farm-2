
import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Sidebar extends JPanel implements MouseListener {
// SIDEBAR WILL BE USED IN SHOPS AND PLOTS.
    private ArrayList<Item> contents;


    private String title;
    public Sidebar(String title, ArrayList<Item> contents) {
        this.title = title;
        this.contents = contents;
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("images/sidebar.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        g.drawImage(image, 800 , 0, null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {}













    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}
