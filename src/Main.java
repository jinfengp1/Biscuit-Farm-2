import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        MainFrame frame = new MainFrame("Biscuit Farm 2");
        ImageIcon img = new ImageIcon("images/boys.png");
        frame.setIconImage(img.getImage());
    }
}

/*
SCREEN IS 1200x800 TOTAL
BACKGROUNDS ARE 800x500 , FROM THE TOP (CREATE AT 0,0)
SIDEBAR THING IS 400x800 , FROM THE RIGHT SIDE (CREATE AT 800,0)
DIALOGUE BOX IS 800x300 , FROM THE BOTTOM (CREATE AT 0,500)
ITEM SPRITES ARE 50x50
*/