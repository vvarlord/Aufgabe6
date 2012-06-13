import java.util.logging.Formatter;
import java.util.logging.LogRecord;
/**
 * Formatter der String ohne weiter angaben und mit \n am ende ausgiebt
 * @author Christian
 *
 */

public class PlainTextFormatter extends Formatter{

	@Override
	public String format(LogRecord arg0) {
		String s = arg0.getMessage()+"\n";
		return s;
	}
}
