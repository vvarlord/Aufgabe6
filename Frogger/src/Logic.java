import java.awt.Graphics;
import java.util.ArrayList;

public class Logic {

	ArrayList<Reihe> reihe = new ArrayList<Reihe>();
	public Logic(int anzReihen) {
		for (int i = 0; i < 4; i++) {
			Reihe r=new Reihe((int) (Math.random() * (3 - 1) + 1), 1, 25+(50*i));
			r.addGO(new Car(0, r.getHohe(), r.getSpeed()));
			reihe.add(r);
		}
	}
	public void play(Graphics g) {
		for(Reihe r: reihe){
			
		}
	}
}
