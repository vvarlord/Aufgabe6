import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JPanel {
	boolean pause = false;

	public boolean isPause() {
		return pause;
	}

	public void setPause(boolean pause) {
		this.pause = pause;
	}

	Logic l = null;
	OutOfWindow oow = null;
	JFrame jf = null;

	public GUI() {
		l = new Logic();

		jf = new JFrame("Frogger");
		jf.setLocation(100, 100);
		jf.setSize(500, 400);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(this);
		for (int i = 0; i < 1000; i++) {
			repaint();
		}
		jf.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					if (!pause) {
						l.setFrogPosition(l.getFrogPositionX() + 50,
								l.getFrogPositionY());
						getParent().repaint();
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					if (!pause) {
						l.setFrogPosition(l.getFrogPositionX() - 50,
								l.getFrogPositionY());

						getParent().repaint();
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					if (!pause) {
						l.setFrogPosition(l.getFrogPositionX(),
								l.getFrogPositionY() - 50);
						getParent().repaint();
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					if (!pause) {
						l.setFrogPosition(l.getFrogPositionX(),
								l.getFrogPositionY() + 50);
						getParent().repaint();
					}
				}

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		oow = new OutOfWindow(jf, this);
		jf.addMouseListener(oow);
		paintGame();
	}

	public void paintComponent(Graphics g) {
		int xadd = 50, xstart = 70;
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.drawLine(0, xstart, 500, xstart);
		g.drawLine(0, xstart + xadd, 500, xstart + xadd);
		g.drawLine(0, xstart + (2 * xadd), 500, xstart + (2 * xadd));
		g.drawLine(0, xstart + (3 * xadd), 500, xstart + (3 * xadd));
		g.drawLine(0, xstart + (4 * xadd), 500, xstart + (4 * xadd));

		l.play(g);

	}

	public void paintGame() {
		while (true) {
			try {
				Thread.sleep(15);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (!l.frogalive()) {
				// JOptionPane.showMessageDialog(jf, "Verloren");
				int i = JOptionPane.showConfirmDialog(jf,
						"Verloren. Neustarten?");
				if (i == JOptionPane.YES_OPTION) {
					l = new Logic();
				} else {
					System.exit(1);
					break;
				}
			}
			if (l.isWin()) {
				// JOptionPane.showMessageDialog(jf, "Gewonnen!");
				int i = JOptionPane.showConfirmDialog(jf,
						"Gewonnen! Neustarten?");
				if (i == JOptionPane.YES_OPTION) {
					l = new Logic();
				} else {
					System.exit(1);
					break;
				}
			}

			if (!pause) {
				repaint();
			}

		}
	}

	public static void main(String[] args) {
		GUI g = new GUI();
	}
}
