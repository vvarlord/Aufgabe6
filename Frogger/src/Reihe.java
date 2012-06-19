import java.util.ArrayList;


public class Reihe {
	int speed;
	int richtung;
	int hohe;
	ArrayList<GameObject> go=new ArrayList<GameObject>();
	public Reihe(int speed, int richtung, int hohe) {
		super();
		this.speed = speed;
		this.richtung = richtung;
		this.hohe=hohe;
	}
	void addGO(GameObject go){
		this.go.add(go);
	}
	void removeGO(GameObject go){
		this.go.remove(go);
	}
	public int getHohe() {
		return hohe;
	}
	GameObject getFirst(){
		return go.get(0);
	}
	GameObject getLast(){
		return go.get(go.size()-1);
	}
	public int getSpeed() {
		return speed;
	}
	public int getRichtung() {
		return richtung;
	}
	
}
