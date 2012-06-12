import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.IOException;

public class LiveHandler implements KeyListener {
	
	private GUI g;

	LiveHandler(GUI g) {
		this.g = g;
	}

	@Override
	public void keyPressed(KeyEvent event) {
//		try {
Lexer l = new Lexer();
			//if (event.getKeyCode() == KeyEvent.VK_F1) {
				
				l.setCode(g.ta.getText());

				g.setShowText(l.tokenTest());
				g.repaint();
			

//		} catch (IOException e) {

//		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
