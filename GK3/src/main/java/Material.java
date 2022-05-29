import java.util.ArrayList;

public class Material {
    private double ka;
    private double ks;
    private double kd;
    private double n;

    public static ArrayList<Material> materials = new ArrayList<Material>(){
        {
            add(new Material(0.2125, 0.714, 0.3935, 25.6)); //Bronze
            add(new Material(0.19225, 0.50754, 0.508273, 51.2)); //Silver
            add(new Material(0.24725, 0.75164, 0.628281, 51.2)); //Gold
            add(new Material(0.5, 0.01, 0.4, 10)); //Black rubber (͡°͜ʖ͡°)
            add(new Material(0.5, 0.75, 0.25, 100));
            add(new Material(0.5, 0.5, 0.5, 100));//Black rubber (͡°͜ʖ͡°)
        }
    };
    public Material(double ka, double kd, double ks, double n) {
        this.ka = ka;
        this.ks = ks;
        this.kd = kd;
        this.n = n;
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
