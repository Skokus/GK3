public class VOperations {

    public static double length(double[] v){
        return Math.sqrt(v[0]*v[0]+v[1]*v[1]+v[2]*v[2]);
    }

    public static void normalize(double[] v){
        double len = Math.sqrt(v[0]*v[0] + v[1]*v[1] + v[2]*v[2]);
        v[0] /= len; v[1] /= len; v[2] /= len;
    }

    public static double dot(double[] x, double[] y){
        double d = x[0]*y[0] + x[1]*y[1] + x[2]*y[2];
        return d < 0 ? -d : 0;
    }

    public static double[] getReflection(double[] d, double[] n){
        double[] r = new double[3];
        double ddotn = dot(d, n);
        r[0] = 2*ddotn*n[0] - d[0];
        r[1] = 2*ddotn*n[1] - d[1];
        r[2] = 2*ddotn*n[2] - d[2];
        return r;
    }

    public static double cosVectors(double[] x, double[] y){
        return (x[0]*y[0] + x[1]*y[1] + x[2]*y[2])/(length(x)*length(y));
    }
}
