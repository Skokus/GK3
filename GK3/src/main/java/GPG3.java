import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class MyCanvas extends JComponent {
    public void paint(Graphics g) {
        double R = 300;
        Color color = Color.WHITE;
        double[] vec = new double[3];
        for(int i = (int)Math.floor(-R); i <= (int)Math.ceil(R); i++){
            double x = i + .5; //+ .5;
            for(int j = (int)Math.floor(-2 * R); j <= (int)Math.ceil(2 * R); j++){
                double y = j / 2. +.5;//+ .5;
                if(x * x + y * y <= R * R) {
                    vec[0] = x;
                    vec[1] = y;
                    double z = Math.sqrt(R * R - x * x - y * y);
                    vec[2] = z; //N
                    VOperations.normalize(vec); //N znormalizowane
                    double[] L = new double[3];
                    L[0] = GPG3.light[0] - vec[0];
                    L[1] = GPG3.light[1] - vec[1];
                    L[2] = GPG3.light[2] - vec[2];
                    VOperations.normalize(L);
                    double[] V = new double[3];
                    V[0] = GPG3.watcher[0] - vec[0];
                    V[1] = GPG3.watcher[1] - vec[1];
                    V[2] = GPG3.watcher[2] - vec[2];
                    VOperations.normalize(V);
                    double[] r = VOperations.getReflection(L, vec);
                    VOperations.normalize(r);
                    double cos = VOperations.cosVectors(r,V);
                    double b = GPG3.Ia*GPG3.material.getKa()+GPG3.Ip*GPG3.material.getKd()*VOperations.dot(vec, L)+ GPG3.Ip* GPG3.material.getKs()*Math.pow(cos,GPG3.material.getN()); //Math.pow(VOperations.dot(GPG3.light, vec), k) +
                    g.setColor(new Color((int) (color.getRed()*b), (int) (color.getBlue()*b), (int) (color.getGreen()*b)));
                    g.drawLine(i+(int)R, (j/2)+(int)R, i+(int)R, (j/2)+(int)R);
                }
            }
            System.out.println();
        }

        //g.drawLine(500, 510, 500, 490);
        //g.drawLine(510, 500, 490, 500);
    }
}

public class GPG3 extends JFrame implements KeyListener {

    static JFrame window = new JFrame();
    static MyCanvas currentCanvas = new MyCanvas();
    public static Material material = Material.materials.get(0);
    int i = 0;
    public static double Ia = 0.7;
    public static double Ip = 0.7;
    public static double[] light = { 400, 400, -500 };
    public static double[] watcher = { 0, 0, -500 };
    public static double krok = 100;
    GPG3(){
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.addKeyListener(this);
        window.setBounds(0, 0, 1000, 1000);
        window.getContentPane().setBackground(Color.WHITE);
        window.add(currentCanvas);
        currentCanvas.repaint();
        window.setTitle("Paweł Cegielski 307332, Bartosz Kabała 307375 - Projekt 3");
        window.setResizable(false);
        window.setVisible(true);
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_Z:
                light[2] -= krok;
                break;
            case KeyEvent.VK_D:
                light[0] -= krok;
                break;
            case KeyEvent.VK_A:
                light[0] += krok;
                break;
            case KeyEvent.VK_X:
                light[2] += krok;
                break;
            case KeyEvent.VK_W:
                light[1] += krok;
                break;
            case KeyEvent.VK_S:
                light[1] -= krok;
                break;
            case KeyEvent.VK_C:
                i++;
                material = Material.materials.get(i);
                break;
            case KeyEvent.VK_V:
                i--;
                material = Material.materials.get(i);
                break;
        }
        currentCanvas.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public static void main(String[] args) {
        new GPG3();
    }
}
