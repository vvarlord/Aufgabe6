import java.util.regex.Matcher;
import java.util.regex.Pattern;


public abstract class MehrZToken extends Token {
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
