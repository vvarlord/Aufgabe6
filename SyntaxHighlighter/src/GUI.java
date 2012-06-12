import java.awt.GridLayout;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.swing.text.html.*;
import javax.swing.*;


public class GUI extends JFrame{
	private JPanel jp= new JPanel(new GridLayout(1, 1));
	private JEditorPane editor = new JEditorPane();
	
	
	
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
	
	
	
	
	public static void main(String[] args){
		GUI mg = new GUI();
	}
	
}