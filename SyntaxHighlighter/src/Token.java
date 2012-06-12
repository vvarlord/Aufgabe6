import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public abstract class Token {
	String regex;
	String inhalt;
	String opentag, closetag;
	ArrayList<String> temp=new ArrayList<String>();
	String[] check(String zuTestenderString, String endString)throws TokenNotFundExeption{
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
			throw new TokenNotFundExeption();
		}
		String[] ret=new String[3];
		ret[0]=inhalt;
		ret[1]=zuTestenderString;
		ret[2]=endString;
		return ret;
	}

}
