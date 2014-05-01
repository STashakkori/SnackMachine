import javax.swing.*;
import java.util.Date;
import java.awt.*;

/**
 * Created by rt on 4/18/14.
 */
public abstract class Snack {

    String name;
    String supplier;

    ImageIcon icon;

    int imgHeight;
    int imgWidth;
    int weight;
    int calories;
    int sodium;
    int fat;
    double price;

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    public ImageIcon getIcon() { return icon; }

    Date expiration;

    public void setName(String name) {
        this.name = name;
    }

    public void setManufacturer(String manufacturer) {
        this.supplier = manufacturer;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

    public void setImgHeight(int imgHeight) {
        this.imgHeight = imgHeight;
    }

    public void setImgWidth(int imgWidth) {
        this.imgWidth = imgWidth;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public String getName() {

        return name;
    }

    public String getManufacturer() {
        return supplier;
    }

    public Date getExpiration() {
        return expiration;
    }

    public int getImgHeight() {
        return imgHeight;
    }

    public int getImgWidth() {
        return imgWidth;
    }

    public int getWeight() {
        return weight;
    }

    public int getCalories() {
        return calories;
    }

    public int getSodium() {
        return sodium;
    }

    public int getFat() {
        return fat;
    }
}
