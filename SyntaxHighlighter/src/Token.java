import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Stellt check methode f�r einzeilige Tokens zur verf�gung
 * @author Christian
 *
 */
public abstract class Token {
	protected String regex;
	protected String inhalt;
	protected String opentag, closetag;
	protected ArrayList<String> temp=new ArrayList<String>();
	/**
	 * Sucht nach dem Regulerem ausdruck in zuTestenderString und Schreibt ihn in endString
	 * @param zuTestenderString String der nach regulerem ausdruck abgesucht wird
	 * @param endString String in dem der code mit Html tags gespeichert werden soll
	 * @return String array [0]gefundenes token [1] zuTestenderString inhalt ersetzt mit ? wird an die n�achste check methode �bergeben [2] Code mit html tags 
	 * @throws TokenNotFundExeption Falls der RegEx in zuTestenderString nicht gefunden wurde
	 */
	String[] check(String zuTestenderString, String endString)throws TokenNotFoundExeption{
		Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE | Pattern.DOTALL);
		Matcher matcher = pattern.matcher(zuTestenderString);
		if (matcher.find()) {
			inhalt = matcher.group(1);
			
			zuTestenderString=zuTestenderString.replaceFirst(inhalt, "?");
			if(!temp.contains(inhalt)){
			endString=endString.replaceAll(inhalt, opentag+inhalt+closetag);
			}
			temp.add(inhalt);
		}else{
			throw new TokenNotFoundExeption();
		}
		String[] ret=new String[3];
		ret[0]=inhalt;
		ret[1]=zuTestenderString;
		ret[2]=endString;
		return ret;
	}
	/**
	 * Entfernt alle Token aus dem eingegeben text und giebt diesen zur�ck
	 * @param s String aus dem die Token entfernt werden sollen
	 * @return String ohne token
	 */
	public String removeToken(String s){
		return Pattern.compile(regex, Pattern.DOTALL).matcher(s).replaceAll("");
		
	}

}
