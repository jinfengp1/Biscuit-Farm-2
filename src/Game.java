
import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Game extends JPanel {

    public ArrayList<Item> inventory = new ArrayList<Item>();
    public BufferedImage coinImage;
    public int money;
    public int fees;
    public int day;
    public final Biscuit basic = new Biscuit("Basic", "The cheap reliable food of most Biscuitown residents.", 5, 8, 1);

    public Game() {
        money = 10;
        fees = 5;
        inventory.add(basic);
        inventory.add(basic);
        loadImage();
    }

    public void loadImage() {
        try {
            coinImage = ImageIO.read(new File("images/smalls/coin.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void calculateFees() {

    }


    public int getDay() {
        return day;
    }

    public int getMoney() { return money; }

    public void addMoney(int m) { money += m; }

    public void sellBiscuits() { // THIS METHOD WILL SELL A SELECTED ARRAY OF BISCUIT ITEMS
        return;
    }
}
