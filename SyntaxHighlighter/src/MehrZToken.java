import java.util.regex.Matcher;
import java.util.regex.Pattern;


public abstract class MehrZToken extends Token {
	/**
	 * Sucht nach dem Regulerem ausdruck in zuTestenderString und Schreibt ihn in endString
	 * @param zuTestenderString String der nach regulerem ausdruck abgesucht wird
	 * @param endString String in dem der code mit Html tags gespeichert werden soll
	 * @return String array [0]gefundenes token [1] zuTestenderString inhalt ersetzt mit ? wird an die näachste check methode übergeben [2] Code mit html tags 
	 * @throws TokenNotFundExeption Falls der RegEx in zuTestenderString nicht gefunden wurde
	 */
		String[] check(String zuTestenderString, String endString)throws TokenNotFundExeption{
		
		Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE | Pattern.DOTALL);
		Matcher matcher = pattern.matcher(zuTestenderString);
		if (matcher.find()) {
			inhalt = matcher.group(1);
			zuTestenderString=Pattern.compile(regex, Pattern.DOTALL).matcher(zuTestenderString).replaceFirst("?");
			if(!temp.contains(inhalt))
				zuTestenderString=Pattern.compile(regex, Pattern.DOTALL).matcher(zuTestenderString).replaceAll( opentag+inhalt+closetag);
			temp.add(inhalt);
		}else{
			throw new TokenNotFundExeption();
		}
		String[] ret=new String[3];
		ret[0]=inhalt;
		ret[1]=zuTestenderString;
		ret[2]=endString;
		return ret;
	}
}
