import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;


public class PublicMethodTest {
	
	@Test
	public void setShowTexttest(){
		GUI g = new GUI();
		g.setShowText("Blabla");
		assertEquals(g.editor.getText(), "Blabla");
	}
	@Test
	public void GUITest(){
		GUI g = new GUI();
		g.createGUI();
		assertNotNull(g);
	}
	@Test
	public void tokens(){
		Lexer l = new Lexer();
		l.setCode("//asdasd");
		l.generateToken();
		assertNotNull(l.tokens);
	}
	@Test
	public void einlesen(){
		Lexer l = new Lexer();
		assertEquals(l.einlesen("testAlex.txt"), "Test\n");
	}
	

}
