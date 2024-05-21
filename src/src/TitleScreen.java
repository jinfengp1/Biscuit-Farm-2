import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class TitleScreen extends JPanel implements MouseListener {

    private boolean showOverworld = false;
    private boolean showCredits = false;

    private Rectangle playHitbox = new Rectangle(830,240,300,200);
    private Rectangle creditsHitbox = new Rectangle(700,600,400,150);

    public TitleScreen() {
        this.addMouseListener(this);
    };

    public boolean isShowOverworld() {
        return showOverworld;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = 0;
        int y = 0;
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("images/title.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        g.drawImage(image, 0 , 0, null);
    }

    public void mouseClicked(MouseEvent e) {

        Point clicked = e.getPoint();
        if (e.getButton() == 1) {
            if (playHitbox.contains(clicked)) { // IF LEFT CLICK PLAY BUTTON
                showOverworld = true;
            }
            if (creditsHitbox.contains(clicked)) {
                showCredits = true;
            }
        }


    }







    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}


}
