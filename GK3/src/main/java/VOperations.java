public class VOperations {

    private VOperations(){

    }

    public static void normalize(double[] v){
        double len = Math.sqrt(v[0]*v[0] + v[1]*v[1] + v[2]*v[2]);
        v[0] /= len; v[1] /= len; v[2] /= len;
    }

    public static double dot(double[] x, double[] y){
        double d = x[0]*y[0] + x[1]*y[1] + x[2]*y[2];
        return d < 0 ? -d : 0;
    }
}
