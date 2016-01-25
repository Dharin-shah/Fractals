import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;


public class FractalTree extends JFrame {
	//Colors[] colors;
	Random rand;
	Color color = new Color(15);
	private Color[] colors = {Color.BLACK,Color.BLUE,Color.GREEN,Color.RED,Color.GRAY,Color.CYAN,Color.MAGENTA,Color.ORANGE};
    public FractalTree() {
    	super("Fractal Tree");
        //colors = Colors.values();
        rand = new Random();
        setBounds(100, 100, 800, 600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
 
    private void drawTree(Graphics g, int x1, int y1, double angle, int depth) {
        if (depth == 0) return;
        int x2 = x1 + (int) (Math.cos(Math.toRadians(angle))* depth * 5);
        int y2 = y1 + (int) (Math.sin(Math.toRadians(angle))* depth * 5);
        g.drawLine(x1, y1, x2, y2);
        g.setColor(colors[rand.nextInt(colors.length)]);
        drawTree(g, x2, y2, angle - 40, depth - 1);
        drawTree(g, x2, y2, angle - 10, depth - 1);
        drawTree(g, x2, y2, angle + 10, depth - 1);
        drawTree(g, x2, y2, angle + 40, depth - 1);
    }
 
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLUE);
        int x1 = 100;
        int x2 = 250;
        int y1 = 50;
        int y2 = 300;
       // g.drawArc(x1, y1, x2, y2, 0, 60);
        
        drawTree(g, 600, 300, -90, 9);
        //drawTree(g, 600, 200, -90, 8);
        //drawTree(g, 200, 200, -90, 8);
    }
 
    public static void main(String[] args) {
        new FractalTree().setVisible(true);
    }
}

