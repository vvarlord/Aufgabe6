/**
 * Eine von MehrZToken abgeleitete Klasse, Regul�rer Ausdruck f�r Javadoc Kommentare.
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
