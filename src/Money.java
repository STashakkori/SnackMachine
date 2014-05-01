import javax.swing.*;

/**
 * Created by rt on 4/21/14.
 */
public abstract class Money {

    ImageIcon icon;

    int imgHeight;
    int imgWidth;
    int centValue;

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    public void setImgHeight(int imgHeight) {
        this.imgHeight = imgHeight;
    }

    public void setImgWidth(int imgWidth) {
        this.imgWidth = imgWidth;
    }

    public void setCentValue(int centValue) {
        this.centValue = centValue;
    }

    public ImageIcon getIcon() {

        return icon;
    }

    public int getImgHeight() {
        return imgHeight;
    }

    public int getImgWidth() {
        return imgWidth;
    }

    public int getCentValue() {
        return centValue;
    }
}
