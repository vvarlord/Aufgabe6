import java.awt.Color;
import java.awt.Graphics;

public abstract class GameObject {
	int x,y;
	int hohe, breite;
	Color farbe;
	int bewegung;
	public GameObject(int x, int y, int bewegung) {
		super();
		this.x = x;
		this.y = y;
		this.hohe = hohe;
		this.breite = breite;
		this.bewegung = bewegung;
	}
	public void move(){
		x=x+bewegung;
	}
	abstract void paintTo(Graphics g);
	
}
