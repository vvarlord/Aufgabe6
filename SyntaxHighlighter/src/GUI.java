import java.awt.GridLayout;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.swing.text.html.*;
import javax.swing.*;

/**
 * 
 * @author Alexander Weinitschke
 * Eine einfache GUI mit einem Fenster zum Anzeigen vom Code mit Highlights
 */
public class GUI extends JFrame{
	//Panel für den Editor zum einsetzen in das Fenster mit GridLayout.
	private JPanel jp= new JPanel(new GridLayout(1, 1));
	//JEditorPane um HTML tags erlauben und Parsen zu können. Sonst selbes verhalten wie 
	//JTextarea
	private JEditorPane editor = new JEditorPane();
	
	
/**
 * Konstruktor ohne Übergabeparameter.
 * Setzt Fenstergröße, Standort und HTML tags werden innerhalb des Codes erlaubt und
 * bewertet.
 */
	public GUI(){
		super("SyntaxHighlighter");
		setSize(300,300);
        setLocation(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        editor.setEditable(true); 
        editor.setContentType("text/html");
        

        editor.setText("<html><body><br>testtest</body></html>");
        
        
        jp.add(editor);
        getContentPane().add(jp);
        
        this.setVisible(true);
        
	}
	/**
	 * 
	 * @param String text
	 * Funktion um den vom Lexer bearbeiteten Text in der GUI anzeigen zu können.
	 */
	public void setShowText(String t){
		editor.setText(t);
	}
	
	
	public static void main(String[] args){
		GUI mg = new GUI();
	}
	
}