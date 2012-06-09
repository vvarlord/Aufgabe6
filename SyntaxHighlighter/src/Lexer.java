import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class Lexer {
	ArrayList<Token> tokens;
	String code = "";
	Lexer(String dateiname){
		tokens=new ArrayList<Token>();
		code = einlesen(dateiname);
		tokens.add(new JavaDoc());
		tokens.add(new ZweiZKommentar());
		tokens.add(new EinZKommentar());
		tokens.add(new Strings());
		tokens.add(new Chars());
		tokens.add(new Anno());
		tokens.add(new Schluesselwoerter());
		//tokens.add(new Rest());
	}
	private String einlesen(String dateiname){
		BufferedReader input = null;
		File f = new File(dateiname);
		if (!f.exists()){
			System.err.print("Datei nicht gefunden!\n");
			return "";
		}
		try {
			input = new BufferedReader(new FileReader(f));
		} catch (FileNotFoundException e) {
			System.err.print("Datei nicht gefunden!");
		}
		String temp="";
		try {
			while (input.ready()) {
					temp = temp + input.readLine()+"\n";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
	public void tokenTest(){
		
		for(Token t:tokens){
			boolean ende=false;
			//System.out.println(t.regex);
			while(!ende){
				try {
					String temp[]=t.check(code);
					code=temp[1];
					System.out.println(temp[0]);
				} catch (TokenNotFundExeption e) {
					ende=true;
				}
			}
		}
	}
	public static void main(String args[]){
		Lexer l = new Lexer("test.txt");
		l.tokenTest();
	}
}
