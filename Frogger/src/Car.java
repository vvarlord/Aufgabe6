import java.awt.Color;
import java.awt.Graphics;


public class Car extends GameObject{

	protected int bewegung;
	public Car(int x, int y, int bewegung) {
		super(x, y, bewegung);
		
		farbe=new Color((int)(Math.random() * (255 - 20) + 20), (int)(Math.random() * (255 - 20) + 20), (int)(Math.random() * (255 - 20) + 20));
		hohe=40;
		breite=80;
		this.bewegung = bewegung;
	}
	@Override
	void paintTo(Graphics g) {
		g.setColor(farbe);
		g.fillRect(x, y, breite, hohe);
		
	}

}
