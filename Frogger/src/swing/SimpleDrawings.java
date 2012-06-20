package swing;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Carsten Gips
 * @see VL 10 (11.06.2012)
 * @version 09062012
 * @see Idee nach Deitel&Deitel: "Java - How to Program"
 */
public class SimpleDrawings extends JPanel {
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.WHITE);

		g.setColor(Color.RED);
		g.drawLine(100, 20, 380, 20);

		g.setColor(Color.BLUE);
		g.drawRect(100, 40, 280, 80);
		g.fillRect(100, 130, 280, 80);

		g.setColor(Color.GREEN);
		g.drawOval(100, 220, 280, 80);
		g.fillOval(100, 310, 280, 80);
	}

	public static void main(String[] args) {
		JFrame f = new JFrame("Zeichenprimitive");
		SimpleDrawings panel = new SimpleDrawings();

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(panel);
		f.setSize(400, 460);
		f.setVisible(true);

	}

}
