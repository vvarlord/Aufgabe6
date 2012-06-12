import java.util.regex.Matcher;
import java.util.regex.Pattern;


public abstract class Token {
	String regex;
	String inhalt;
	String opentag, closetag;
	String[] check(String zuTestenderString, String endString)throws TokenNotFundExeption{
		Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE | Pattern.DOTALL);
		Matcher matcher = pattern.matcher(zuTestenderString);
		if (matcher.find()) {
			inhalt = matcher.group(1);
			//System.out.println(zuTestenderString);
			
			
			zuTestenderString=zuTestenderString.replaceFirst(inhalt, "?");
			endString=endString
			
			/*String[] temp=zuTestenderString.split(inhalt);
			zuTestenderString=temp[0]+"?"+temp[1];*/

			
			//System.out.println(zuTestenderString);
		}else{
			throw new TokenNotFundExeption();
		}
		String[] ret=new String[2];
		ret[0]=inhalt;
		ret[1]=zuTestenderString;
		return ret;
	}

}
