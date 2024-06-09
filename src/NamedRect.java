
import java.awt.*;
public class NamedRect extends Rectangle{
    private String name;
    private String fileName;
    public boolean clickable;

    public NamedRect(String n,String f, int x, int y, int width, int height) {
        super(x,y,width,height);
        fileName = f;
        name = n;
        clickable = true;

    }
    public NamedRect(String f, int x, int y, int width, int height) {
        super(x,y,width,height);
        fileName = f;
        name = f;
        clickable = true;
    }

    public String getName() {
        return name;
    }

    public String getFileName() { return fileName; }

    public void setFileName(String f) { fileName = f; }

    public boolean isClickable() { return clickable; }

    public void setClickable(boolean c) {
        clickable = c;
    }

}
