import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.StringReader;
import java.util.EventListener;



import javax.swing.*;

/**
 * 
 * @author Alexander Weinitschke
 * Eine einfache GUI mit einem Fenster zum Anzeigen vom Code mit Highlights
 */
public class GUI extends JFrame{
	//Panel für den Editor zum einsetzen in das Fenster mit GridLayout.
	private JPanel jp= new JPanel(new GridLayout(1, 2));
	//JEditorPane um HTML tags erlauben und Parsen zu können. Sonst selbes verhalten wie 
	//JTextarea
	JEditorPane editor = new JEditorPane();
	JTextArea ta = new JTextArea();
	private LiveHandler lh;
	
/**
 * Konstruktor ohne Übergabeparameter.
 * Setzt Fenstergröße, Standort und HTML tags werden innerhalb des Codes erlaubt und
 * bewertet.
 */
	public GUI(){
		super("SyntaxHighlighter");
       this.lh= new LiveHandler(this);
	}
	
	public void createGUI(){
		
		setSize(300,300);
        setLocation(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        editor.setEditable(false); 
        editor.setContentType("text/html");
        editor.setText("");
        
        
        ta.addKeyListener(lh);
        jp.add(ta);
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
	
	public BufferedReader sendText(){
		BufferedReader br = new BufferedReader(new StringReader(ta.getText()));
		
		return br;
	}
	
	
	public static void main(String[] args){
		GUI mg = new GUI();
		mg.createGUI();
	}
	
}