import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class MyCanvas extends JComponent {
    public Color color;
    boolean white = false;

    public void paint(Graphics g) {
        double R = 300;
        color = (white) ? Color.WHITE : GPG3.material.getColor();
        double[] vec = new double[3];
        for(int i = (int)Math.floor(-R); i <= (int)Math.ceil(R); i++){
            double x = i + .5; //+ .5;
            for(int j = (int)Math.floor(-2 * R); j <= (int)Math.ceil(2 * R); j++){
                double y = j / 2. +.5;//+ .5;
                if(x * x + y * y <= R * R) {
                    vec[0] = 2*x;
                    vec[1] = 2*y;
                    double z = Math.sqrt(R * R - x * x - y * y);
                    vec[2] = 2*z; //N
                    double[] L = new double[3];
                    L[0] = GPG3.light[0] - vec[0];
                    L[1] = GPG3.light[1] - vec[1];
                    L[2] = GPG3.light[2] - vec[2];
                    double[] V = new double[3];
                    V[0] = GPG3.watcher[0] - vec[0];
                    V[1] = GPG3.watcher[1] - vec[1];
                    V[2] = GPG3.watcher[2] - vec[2];
                    VOperations.normalize(vec); //N znormalizowane
                    VOperations.normalize(L);
                    double[] r = VOperations.getReflection(L, vec);
                    VOperations.normalize(V);
                    VOperations.normalize(r);
                    double b = GPG3.Ia * GPG3.material.getKa() + GPG3.material.getKd()*GPG3.Ip*VOperations.dot(vec, L) + GPG3.Ip*GPG3.material.getKs()*Math.pow(VOperations.dot(r, V),GPG3.material.getN());
                    g.setColor(new Color(Math.min((int) (color.getRed()* b), 255),
                            Math.min((int)(color.getGreen()* b), 255),
                            Math.min((int)(color.getBlue()* b), 255))
                    );
                    g.drawLine(i+(int)R+20, (j/2)+(int)R+20, i+(int)R+20, (j/2)+(int)R+20);
                }
            }
        }

        //g.drawLine(500, 510, 500, 490);
        //g.drawLine(510, 500, 490, 500);
    }
}

public class GPG3 extends JFrame implements KeyListener {

    static MyCanvas currentCanvas = new MyCanvas();
    static JLabel label = new JLabel("Current material: Bronze");
    public static Material material = Material.materials.get(0);
    int i = 0;
    int j = 0;
    public static double Ia = 0.7;
    public static double Ip = 0.9;
    public static double[] light = { 400, 400, -500 };
    public static double[] watcher = { 0, 0, 500 };
    public static double krok = 100;

    GPG3(){
        setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        label.setBounds(0,700,700,20);
        currentCanvas.setBounds(0,0,700,700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(this);
        this.setBounds(0, 0, 700, 720);
        this.getContentPane().setBackground(Color.WHITE);
        this.add(currentCanvas);
        this.add(label);
        currentCanvas.repaint();
        this.setTitle("Paweł Cegielski 307332, Bartosz Kabała 307375 - Projekt 3");
        this.setResizable(false);
        this.setVisible(true);
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_Z -> light[2] -= krok;
            case KeyEvent.VK_D -> light[0] -= krok;
            case KeyEvent.VK_A -> light[0] += krok;
            case KeyEvent.VK_X -> light[2] += krok;
            case KeyEvent.VK_W -> light[1] += krok;
            case KeyEvent.VK_S -> light[1] -= krok;
            case KeyEvent.VK_C -> {
                i++;
                material = Material.getMaterial(i);
                label.setText("Current material: " + material.getName());
            }
            case KeyEvent.VK_V -> {
                i--;
                material = Material.getMaterial(i);
                label.setText("Current material: " + material.getName());
            }
            case KeyEvent.VK_R -> {
                j++;
                currentCanvas.white = !currentCanvas.white;
            }
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
