import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;



public class Frog extends GameObject{
	private boolean frogalive=true;
	protected int bewegung;
	File f = new File("images.jpg");
	BufferedImage img = null;
	public Frog(int x, int y, int bewegung) {
		super(x, y, 0);
		
		try {
			img = ImageIO.read(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	void paintTo(Graphics g) {
		
		
		g.drawImage(img, x, y, null);
	}
	public void setX(int x){
		this.x=x;
	}
	public void setY(int y){
		this.y=y;
	}

	public boolean isFrogalive() {
		return frogalive;
	}

	public void setFrogalive(boolean frogalive) {
		this.frogalive = frogalive;
	}
	
}

