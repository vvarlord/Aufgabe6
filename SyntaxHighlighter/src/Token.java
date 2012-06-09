import java.util.regex.Matcher;
import java.util.regex.Pattern;


public abstract class Token {
	String regex;
	String inhalt;
	String[] check(String zuTestenderString)throws TokenNotFundExeption{
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(zuTestenderString);
		if (matcher.find()) {
			inhalt = matcher.group(1);
			//System.out.println(zuTestenderString);
			String[] temp=zuTestenderString.split(inhalt);
			zuTestenderString=temp[0]+"?"+temp[1];
			//System.out.println(zuTestenderString);
			System.out.println(inhalt);
		}else{
			throw new TokenNotFundExeption();
		}
		String[] ret=new String[2];
		ret[0]=inhalt;
		ret[1]=zuTestenderString;
		return ret;
	}

}
