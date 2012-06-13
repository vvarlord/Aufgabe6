/**
 * Eine von MehrZToken abgeleitete Klasse, Regulärer Ausdruck für Javadoc Kommentare.
 * @author Christian Sander
 * 
 */
public class JavaDoc extends MehrZToken {
	JavaDoc(){
		regex ="(/\\*\\*.*?\\*/)";
		opentag ="<font color=\"RED\">";
		closetag = "</font>";
	}
	
}
