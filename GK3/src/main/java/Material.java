import java.util.ArrayList;

public class Material {
    private double ka;
    private double ks;
    private double kd;
    private double n;
    private String name;

    public static ArrayList<Material> materials = new ArrayList<>() {
        {
            add(new Material(0.2125, 0.714, 0.3935, 25.6, "Bronze"));
            add(new Material(0.19225, 0.50754, 0.508273, 51.2, "Silver"));
            add(new Material(0.24725, 0.75164, 0.628281, 51.2, "Gold"));
            add(new Material(0.329412, 0.780392, 0.992157, 27.8974, "Brass"));
            add(new Material(0.25, 0.4, 0.774597, 76.8, "Chrome"));
            add(new Material(0.5, 0.01, 0.4, 10, "Black Rubber"));
            add(new Material(0.0, 0.01, 0.50, 32, "Black Plastic"));
        }
    };

    public Material(double ka, double kd, double ks, double n, String name) {
        this.ka = ka;
        this.ks = ks;
        this.kd = kd;
        this.n = n;
        this.name = name;
    }

    public static Material getMaterial(int i) {
        int id = i % materials.size();
        return materials.get(id);
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
