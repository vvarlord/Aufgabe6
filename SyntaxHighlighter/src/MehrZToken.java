import java.util.regex.Matcher;
import java.util.regex.Pattern;


public abstract class MehrZToken extends Token {
	String[] check(String zuTestenderString)throws TokenNotFundExeption{
		Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE | Pattern.DOTALL);
		Matcher matcher = pattern.matcher(zuTestenderString);
		if (matcher.find()) {
			inhalt = matcher.group(1);
			zuTestenderString=Pattern.compile(regex, Pattern.DOTALL).matcher(zuTestenderString).replaceFirst("?");

		}else{
			throw new TokenNotFundExeption();
		}
		String[] ret=new String[2];
		ret[0]=inhalt;
		ret[1]=zuTestenderString;
		return ret;
	}
}
