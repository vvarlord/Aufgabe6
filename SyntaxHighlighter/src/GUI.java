import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.EventListener;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.jws.Oneway;
import javax.swing.*;

/**
 * Eine einfache GUI mit einem Fenster zum
 * Anzeigen vom Code mit Highlights
 * @author Alexander Weinitschke 
 */
public class GUI extends JFrame {
	// Panel für den Editor zum einsetzen in das Fenster mit GridLayout.
	private JPanel jp = new JPanel(new GridLayout(1, 2));
	// JEditorPane um HTML tags erlauben und Parsen zu können. Sonst selbes
	// verhalten wie
	// JTextarea
	JEditorPane editor = new JEditorPane();
	JTextArea ta = new JTextArea();
	private LiveHandler lh;

	/**
	 * Konstruktor ohne Übergabeparameter. Setzt Fenstergröße, Standort und HTML
	 * tags werden innerhalb des Codes erlaubt und bewertet.
	 */
	public GUI() {
		super("SyntaxHighlighter");
		this.lh = new LiveHandler(this);
	}

	 private class Save extends WindowAdapter { 
		 /**
		  * bei Schliesen des fensters wird wenn über logger erlaubt der inhalt von der textarea ta in 2 html dateien gespeichert
		  */
	        public void windowClosing( WindowEvent e ) {
	        	Logger log2 = Logger.getLogger("Datei");
	        	Logger log3 = Logger.getLogger("Datei ohne kommentar");
	    		Lexer l = new Lexer();
	    		String text=ta.getText();
	    		l.setCode(text);
	    		log2.info(l.tokenTest());
	    		text=new EinZKommentar().removeToken(text);
	    		text= new MehrZKommentar().removeToken(text);
	    		l.setCode(text);
	    		log3.info(l.tokenTest());
	        }
	 }
	 /**
	  * Erstellt die Gui
	  */
	public void createGUI() {

		setSize(300, 300);
		setLocation(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		editor.setEditable(false);
		editor.setContentType("text/html");
		editor.setText("");

		ta.addKeyListener(lh);
		jp.add(ta);
		jp.add(editor);

		getContentPane().add(jp);

		this.setVisible(true);
		addWindowListener( new Save() );
	}

	/**
	 * text Funktion um den vom Lexer bearbeiteten Text in der GUI
	 * anzeigen zu können. 
	 * @param String
	 */
	public void setShowText(String t) {
		editor.setText(t);
	}
	/**
	 * Wandelt den ihnhalt von der textarea ta in einen BufferedReader um
	 * @return BufferedReader vom inhalt von ta
	 */
	public BufferedReader sendText() {
		BufferedReader br = new BufferedReader(new StringReader(ta.getText()));
		return br;
	}

	public static void main(String[] args) {
		GUI mg = new GUI();
		Logger log1 = Logger.getLogger("Konsole");
		Logger log2 = Logger.getLogger("Datei");
		Logger log3 = Logger.getLogger("Datei ohne kommentar");
		Argumente arg = new Argumente(args);
		if (arg.isLog1()) {
			log1.setLevel(Level.ALL);
			log1.setUseParentHandlers(false);
			ConsoleHandler fh = new ConsoleHandler();
			fh.setFormatter(new PlainTextFormatter());
			log1.addHandler(fh);
		} else {
			log1.setLevel(Level.WARNING);
		}
		if (arg.isLog2()) {
			log2.setLevel(Level.ALL);
			log2.setUseParentHandlers(false);
			log3.setLevel(Level.ALL);
			log3.setUseParentHandlers(false);
			FileHandler fh=null;
			FileHandler fh2=null;
			try {
				fh = new FileHandler("Code.html");
				fh2 = new FileHandler("Code ohne kommentare.html");
				fh.setFormatter(new PlainTextFormatter());
				fh2.setFormatter(new PlainTextFormatter());
				log2.addHandler(fh);
				log3.addHandler(fh2);
			} catch (SecurityException e) {
				log1.warning("Sicherheits verstoss beim öffnen der Datein!");
			} catch (IOException e) {
				log1.warning("Problem beim schreiben der Datein!");
			}
			
		} else {
			log2.setLevel(Level.OFF);
		}
		mg.createGUI();
	}
}