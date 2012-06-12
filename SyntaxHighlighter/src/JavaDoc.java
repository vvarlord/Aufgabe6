/**
 * 
 * @author Christian Sander
 * Eine von MehrZToken abgeleitete Klasse, Regulärer Ausdruck für Javadoc Kommentare.
 */
public class JavaDoc extends MehrZToken {
	JavaDoc(){
		regex ="(/\\*\\*.*?\\*/)";
	}
	
}
