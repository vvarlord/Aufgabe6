import java.awt.Graphics;
import java.util.ArrayList;

public class Logic {
	private boolean win = false;
	private int x = 220, y = 280;
	Frog f = new Frog(x, y, 0);
	ArrayList<Reihe> reihe = new ArrayList<Reihe>();

	public Logic() {
		for (int i = 0; i < 4; i++) {
			Reihe r = new Reihe((int) (Math.random() * (3 - 1) + 1), 1,
					75 + (50 * i));
			r.addGO(new Car(200, r.getHohe(), r.getSpeed()));
			reihe.add(r);
		}
	}

	public void play(Graphics g) {
		
		f.setX(x);
		f.setY(y);
		f.paintTo(g);
		try{
		for (Reihe r : reihe) {
			for (GameObject go : r.getGo()) {
				if (go.getX() < 500) {
					go.move(g);

					if (go.getX() < x && go.getX() + 80 > x) {

						if (go.getY() < y && go.getY() + 40 > y) {
							f.setFrogalive(false);
						}
					}

				} else
					r.removeGO(go);
			}
			if (r.getLast().getX() > 130) {
				if ((Math.random() * (100 - 1) + 1) < 2.3) {
					r.addGO(new Car(0, r.getHohe(), r.getSpeed()));
				}
			}
		}
		}catch(Exception e){
			
		}
	}

	public void setFrogPosition(int x, int y) {
		if (x < 450 && x > 0) {
			this.x = x;
		}
		if (y < 350 && y > 0) {
			this.y = y;
		}
		if(y<70){
			win=true;
		}
	}

	public int getFrogPositionX() {
		return this.x;
	}
	public boolean isWin(){
		return win;
	}

	public int getFrogPositionY() {
		return this.y;
	}

	public boolean frogalive() {
		return f.isFrogalive();
	}
}
