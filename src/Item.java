

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Rectangle;

public class Item {
    public int cost;
    public String name;
    public BufferedImage image;
    public String description;
    public Rectangle rect;

    public Item(String name, int cost, String description) {
        this.name = name;
        this.cost = cost;
        this.description = description;
        try {
           image = ImageIO.read(new File("images/smalls/Coin.png")); // PLACEHOLDER FOR NOW
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        rect = new Rectangle(-100,-100,image.getWidth(),image.getHeight());
    }

    public int getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public BufferedImage getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }


}
