/**
 * 
 * @author Christian Sander
 * Eine von MehrZToken abgeleitete Klasse, Regul�rer Ausdruck f�r Javadoc Kommentare.
 */
public class JavaDoc extends MehrZToken {
	JavaDoc(){
		regex ="(/\\*\\*.*?\\*/)";
		opentag ="<font color=\"RED\">";
		closetag = "</font>";
	}
	
}
