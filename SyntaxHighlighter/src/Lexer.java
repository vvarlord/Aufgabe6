import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;
/**
 * Lexer der aus java quellcode mit html tags eingef�rbtem code erstellt
 * @author Christian
 *
 */
public class Lexer {
	private ArrayList<Token> tokens;
	private String code = "";
	/**
	 * Erzeuft neuen Lexer liest code aus einer datei ein
	 * @param dateiname Der Path f�r die auszulesende datei
	 */
	Lexer(String dateiname) {
		tokens = new ArrayList<Token>();
		code = einlesen(dateiname);
		generateToken();
	}

	/**
	 * Erzeuft neuen Lexer, Anschlie�end muss die methode setCode aufgerufen werden
	 */
	Lexer() {
		tokens = new ArrayList<Token>();
		generateToken();
	}
	/**
	 * Setzt den code aus einem BufferedReader
	 * @param inp BufferedReader inhalt wirde ausgelesen
	 * @throws IOException falls �bergebener reader defekt ist
	 */
	public void setCode(BufferedReader inp) throws IOException {
		String temp = "";
		while (inp.ready()) {
			temp = temp + inp.readLine() + "\n";
		}
		code = temp;
	}
	//setzt alle tokens
	private void generateToken() {
		tokens.add(new JavaDoc());
		tokens.add(new MehrZKommentar());
		tokens.add(new EinZKommentar());
		tokens.add(new Strings());
		tokens.add(new Chars());
		tokens.add(new Anno());
		tokens.add(new Schluesselwoerter());
		tokens.add(new Rest());
	}
	//Liest code aus einer datei ein
	private String einlesen(String dateiname) {
		BufferedReader input = null;
		File f = new File(dateiname);
		if (!f.exists()) {
			System.err.print("Datei nicht gefunden!\n");
			return "";
		}
		try {
			input = new BufferedReader(new FileReader(f));
		} catch (FileNotFoundException e) {
			System.err.print("Datei nicht gefunden!");
		}
		String temp = "";
		try {
			while (input.ready()) {
				temp = temp + input.readLine() + "\n";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
/**
 * Wertet den akutellen code aus und gibt den code mit Html tags zur�ck
 * @return Html tag best�ckter codes
 */
	private String tokenTest() {
		String rueckgabe = code;
		for (Token t : tokens) {
			boolean ende = false;
			while (!ende) {
				try {
					String temp[] = t.check(code, rueckgabe);
					code = temp[1];
					rueckgabe = temp[2];
				} catch (TokenNotFoundExeption e) {
					ende = true;

				}
			}
		}
		rueckgabe = rueckgabe.replaceAll("\\n", "<BR>");
		rueckgabe = "<html><body>"+rueckgabe+"</html></body>";
		return rueckgabe;
	}

	public static void main(String args[]) {
		Lexer l = new Lexer("test.txt");
		l.tokenTest();
	}
}
