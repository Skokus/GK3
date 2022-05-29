import java.awt.*;
import java.util.ArrayList;

public class Material {
    private double ka;
    private double ks;
    private double kd;
    private double n;
    private String name;
    private final Color color;

    public static ArrayList<Material> materials = new ArrayList<>() {
        {
            add(new Material(0.2125, 0.714, 0.3935, 25.6, "Bronze", new Color(205, 127, 50)));
            add(new Material(0.19225, 0.50754, 0.508273, 51.2, "Silver", new Color(192,192,192)));
            add(new Material(0.24725, 0.75164, 0.628281, 51.2, "Gold", new Color(255,215,0)));
            add(new Material(0.329412, 0.780392, 0.992157, 27.8974, "Brass", new Color(173, 153, 12)));
            add(new Material(0.25, 0.4, 0.774597, 76.8, "Chrome", new Color(219,226,233)));
            add(new Material(0.105882, 0.427451, 0.333333, 9.84615, "Pewter", new Color(142,146,148)));
            add(new Material(0.0, 0.01, 0.5, 32, "Black Plastic", new Color(255, 255, 255)));
        }
    };

    public Material(double ka, double kd, double ks, double n, String name, Color color) {
        this.ka = ka;
        this.ks = ks;
        this.kd = kd;
        this.n = n;
        this.name = name;
        this.color = color;
    }

    public static Material getMaterial(int i) {
        int id;
        if (i < 0) {
            id = (6 - Math.abs(i % materials.size())) % 6;
        } else {
            id = i % materials.size();
        }
        return materials.get(id);
    }

    public Color getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getKa() {
        return ka;
    }

    public void setKa(double ka) {
        this.ka = ka;
    }

    public double getKs() {
        return ks;
    }

    public void setKs(double ks) {
        this.ks = ks;
    }

    public double getKd() {
        return kd;
    }

    public void setKd(double kd) {
        this.kd = kd;
    }

    public double getN() {
        return n;
    }

    public void setN(double n) {
        this.n = n;
    }
}
