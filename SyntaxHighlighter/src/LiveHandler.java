import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Logger;
/**
 * KeyListerner der bei tasten druck den text aus der textarea ta holt und mit html formatierung in den editor schreibt
 * @author Christian
 *
 */
public class LiveHandler implements KeyListener {
	Logger log=Logger.getLogger("Konsole");
	private GUI g;

	LiveHandler(GUI g) {
		this.g = g;
	}
	@Override
	/**
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	public void keyPressed(KeyEvent event) {

				Lexer l = new Lexer();
				String text=g.ta.getText();
				l.setCode(text);
				log.info(text);
				text=l.tokenTest();
				g.setShowText(text);

				
				g.repaint();

	


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
