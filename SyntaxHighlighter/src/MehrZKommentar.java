import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MehrZKommentar extends MehrZToken {
	MehrZKommentar(){
		regex ="(/\\*.*?\\*/)";
	}

}
