import java.awt.Color;
import java.awt.Graphics;

public abstract class GameObject {
	protected int x, y;
	protected int hohe, breite;
	protected Color farbe;
	protected int bewegung;
	public GameObject(int x, int y, int bewegung) {
		super();
		this.x = x;
		this.y = y;
		this.bewegung = bewegung;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getBreite() {
		return breite;
	}

	public int getBewegung() {
		return bewegung;
	}

	public void move(Graphics g) {
		x = x + bewegung;
		paintTo(g);
	}

	abstract void paintTo(Graphics g);

}
