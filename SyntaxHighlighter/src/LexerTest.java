import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;


public class LexerTest {

	
	@Test
	public void MehrZKommentar(){
		Lexer l = new Lexer();
		l.setCode("/*asdasd\nasdasd\nasdasd*/");

		assertEquals(l.tokenTest(), "<html><body><font color=\"GREEN\">/*asdasd<BR>asdasd<BR>asdasd*/</font></body></html>");
		
	}
	
	
	@Test(expected = TokenNotFoundExeption.class)
	public void TokenNotFoundException()throws TokenNotFoundExeption{
		Schluesselwoerter s = new Schluesselwoerter();
		s.check("asdkasd", "");
		
		
	}
	@Test
	public void Anno(){
		Lexer l = new Lexer();
		l.setCode("@param");

		assertEquals(l.tokenTest(), "<html><body><font color=\"RED\">@param</font></body></html>");
	}
	@Test
	public void Chars(){
		Lexer l = new Lexer();
		l.setCode("'a'");

		assertEquals(l.tokenTest(), "<html><body><font color=\"YELLOW\">'a'</font></body></html>");
	}
	@Test
	public void EinZKommentar(){
		Lexer l = new Lexer();
		l.setCode("//Kommentar test");

		assertEquals(l.tokenTest(), "<html><body><font color=\"GREEN\">//Kommentar test</font></body></html>");
	}
	@Test
	public void JavaDoc(){
		Lexer l = new Lexer();
		l.setCode("/**Ein JavaDoc\n*/");
		assertEquals(l.tokenTest(), "<html><body><font color=\"RED\">/**Ein JavaDoc<BR>*/</font></body></html>");
	}
	@Test
	public void Rest(){
		Lexer l = new Lexer();
		l.setCode("Palaber");
		assertEquals(l.tokenTest(), "<html><body>Palaber</body></html>");
	}
	@Test
	public void Schluesselwoerter(){
		Lexer l = new Lexer();
		l.setCode("public\nprivate\nimport\nclass\nfinal\nstatic\nreturn\nif\nelse\nwhile\ntry\ncatch\finally");
		assertEquals(l.tokenTest(), "<html><body><font color=\"purple\">public</font><BR>" +
				"<font color=\"purple\">private</font><BR>" +
				"<font color=\"purple\">import</font><BR>" +
				"<font color=\"purple\">class</font><BR>" +
				"<font color=\"purple\">final</font><BR>" +
				"<font color=\"purple\">static</font><BR>" +
				"<font color=\"purple\">return</font><BR>" +
				"<font color=\"purple\">if</font><BR>" +
				"<font color=\"purple\">else</font><BR>" +
				"<font color=\"purple\">while</font><BR>" +
				"<font color=\"purple\">try</font><BR>" +
				"<font color=\"purple\">catch</font>inally</body></html>");
	}
	
	
	

}
