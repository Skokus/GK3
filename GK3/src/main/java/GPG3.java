import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class MyCanvas extends JComponent {
    public void paint(Graphics g) {
        double R = 300;
        double k = 0.12;
        double ambient = 0.1;
        Color color = Color.RED;
        double[] vec = new double[3];
        for(int i = (int)Math.floor(-R); i <= (int)Math.ceil(R); i++){
            double x = i + .5; //+ .5;
            for(int j = (int)Math.floor(-2 * R); j <= (int)Math.ceil(2 * R); j++){
                double y = j / 2. +.5;//+ .5;
                if(x * x + y * y <= R * R) {
                    vec[0] = x;
                    vec[1] = y;
                    vec[2] = Math.sqrt(R * R - x * x - y * y);
                    VOperations.normalize(vec);
                    double b = ambient; //Math.pow(VOperations.dot(GPG3.light, vec), k) +
                            System.out.println(b);
                    int intensity = (b <= 0) ?
                            GPG3.shades.length - 2 :
                            (int)Math.max((1 - b) * (GPG3.shades.length - 1), 0);
                    g.setColor(new Color((int)(color.getRed()*b), (int)(color.getBlue()*b),(int)(color.getGreen()*b)));
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

    public static double[] light = { 400, 400, -500 };
    public static char[] shades = {'.', ':', '!', '*', 'o', 'e', '&', '#', '%', '@'};

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

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public static void main(String[] args) {
        new GPG3();
    }
}
