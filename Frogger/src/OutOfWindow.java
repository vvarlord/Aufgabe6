import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;


public class OutOfWindow implements MouseListener{
	private JFrame jf;

	private GUI g;

	OutOfWindow(JFrame jf, GUI g) {
		this.jf=jf;
		this.g=g;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		g.setPause(false);
		jf.setTitle("Frogger");
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		g.setPause(true);
		jf.setTitle("Pause");
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
