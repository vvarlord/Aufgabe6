import java.util.ArrayList;


public class Reihe {
	private int speed;
	private int richtung;
	private int hohe;
	private ArrayList<GameObject> go=new ArrayList<GameObject>();
	public ArrayList<GameObject> getGo() {
		return go;
	}
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
		if(go.size()>0)
		return go.get(go.size()-1);
		else{
			return new Car(300, getHohe(), getSpeed());
		}
	}
	public int getSpeed() {
		return speed;
	}
	public int getRichtung() {
		return richtung;
	}
	
}
