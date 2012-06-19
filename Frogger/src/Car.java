import java.awt.Graphics;


public class Car extends GameObject{

	public Car(int x, int y, int bewegung) {
		super(x, y, bewegung);
		hohe=40;
		breite=80;
	}
	@Override
	void paintTo(Graphics g) {
		g.drawRect(x, y, hohe, breite);
	}

}
