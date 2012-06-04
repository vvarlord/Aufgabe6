import java.util.regex.Matcher;
import java.util.regex.Pattern;


public abstract class Token {
	String regex;
	String inhalt;
	String check(String zuTestenderString)throws TokenNotFundExeption{
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(zuTestenderString);
		if (matcher.find()) {
			inhalt = matcher.group(1);

		}else{
			throw new TokenNotFundExeption();
		}
		return inhalt;
	}

}
